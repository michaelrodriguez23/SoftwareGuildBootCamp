/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mr.flooringOrders.controllers;

import com.mr.flooringOrders.dto.Order;
import com.mr.flooringOrders.dto.Product;
import com.mr.flooringOrders.dto.StateTax;
import com.mr.flooringOrders.service.DuplicateOrderException;
import com.mr.flooringOrders.service.FlooringOrderService;
import com.mr.flooringOrders.service.InvalidMaterialException;
import com.mr.flooringOrders.service.InvalidOrderException;
import com.mr.flooringOrders.service.InvalidProductException;
import com.mr.flooringOrders.service.InvalidStateException;
import com.mr.flooringOrders.service.OrderNotFoundException;
import com.mr.flooringOrders.service.PersistenceException;
import com.mr.flooringOrders.ui.FlooringOrdersView;
import com.mr.flooringOrders.ui.UserIo;
import com.mr.flooringOrders.ui.UserIoConsoleImpl;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class FlooringController {

    private FlooringOrderService service;
    private FlooringOrdersView view;
    private static final AtomicInteger count = new AtomicInteger(0);

    LocalDate ld;
    LocalDate selectedDate;
    Order order;
    StateTax stateTax;
    Product product;
    Integer orderId = count.incrementAndGet();
    BigDecimal taxRate;

    public FlooringController(FlooringOrderService service, FlooringOrdersView view) {

        this.service = service;
        this.view = view;
    }
    private UserIo io = new UserIoConsoleImpl();

    public void run() throws Exception {

        boolean keepGoing = true;
        boolean hasError = true;
        int menuSelection = 0;
        while (keepGoing) {
            menuSelection = view.getMenuSelection();

            switch (menuSelection) {
                case 1:
                    hasError = true;
                    // this gets the date from the user, then assigns it to the global selectedDate Variable. 
                    while (hasError) {
                        getSelectedDate();
                        try {
                            displayAllOrders();
                        } catch (InvalidOrderException e) {
                            io.print(e.getLocalizedMessage() + " try again");
                            hasError = true;

                        }
                        keepGoing = true;
                        hasError = false;
                    }

                    break;

                case 2:
                    addOrder();
                    break;
                case 3:

                    editOrder();
                    break;

                case 4:
                    removeOrder();
                    break;

                case 5:
                    LocalDate saveDate = getDateForSave();
                    saveWork(saveDate);
                    break;
                case 6: 
                    io.print("BYE");
                    keepGoing = false;
                    break;
                default:
                    System.out.println("default");
            }
        }
    }

    private void editOrder() throws InvalidOrderException, FileNotFoundException, InvalidProductException, InvalidStateException, PersistenceException, DuplicateOrderException, InvalidMaterialException, IOException {
        Order updatedOrder = new Order();
        view.displayEditBanner();

        selectedDate = getSelectedDate();

        int orderId = view.getOrderById();

        updatedOrder = service.getOrder(selectedDate, orderId);
        updatedOrder = view.editOrder(updatedOrder);

        // Setting all the calculations for the object. ////////////////////////
        BigDecimal costPerSqFt = getCostPerSqFt(updatedOrder.getProductType());
        updatedOrder.setCostPerSqFoot(costPerSqFt);
        BigDecimal laborCostPerSqFt = getLaborCostPerSqFt(updatedOrder.getProductType());
        updatedOrder.setLaborCostPerSqFoot(laborCostPerSqFt);
        BigDecimal materialCost = getMaterialCost(updatedOrder.getArea(), costPerSqFt);
        updatedOrder.setMaterialCost(materialCost);
        BigDecimal laborCost = getLaborCost(updatedOrder.getArea(), laborCostPerSqFt);
        updatedOrder.setLaborCost(laborCost);
        BigDecimal taxRate = getStateTaxRate(updatedOrder.getState());
        BigDecimal tax = getTax(taxRate, laborCost, materialCost);
      
        BigDecimal taxRounded = tax.setScale(2, RoundingMode.DOWN);
        updatedOrder.setTax(taxRounded);
        BigDecimal total = getTotal(tax, laborCost, materialCost);
        BigDecimal totalRounded = total.setScale(2, RoundingMode.DOWN);
        updatedOrder.setTotal(totalRounded);
        //service.addOrder(ld, updatedOrder);
        ///////////////////////////////////////////////////////////////////////////

        service.validateEditedOrder(selectedDate, updatedOrder, orderId);

    }

    private void removeOrder() throws InvalidOrderException, FileNotFoundException, OrderNotFoundException {
        Order deletedOrder = new Order();
        selectedDate = getSelectedDate();
        int orderId = view.getOrderById();
        deletedOrder = service.getOrder(selectedDate, orderId);
        int answer = view.getDeleteConfirmation(deletedOrder);
        if(answer == 1){ 
            service.removeOrder(selectedDate, deletedOrder);
        }
        

    }

    private Order addEditedOrder() throws InvalidOrderException, InvalidProductException, InvalidStateException, PersistenceException, DuplicateOrderException, InvalidMaterialException, FileNotFoundException, IOException {
        Order order = new Order();
        order.setCustomerName(addCustomerName());
        String state = addState();
        order.setState(state);
        String product = addProductType();
        order.setProductType(product);
        order.setArea(addArea());
        order.setStateTaxes(getStateTaxRate(state));
        order.setCostPerSqFoot(getCostPerSqFt(product));
        BigDecimal laborCostPerSqFt = getLaborCostPerSqFt(product);
        order.setLaborCostPerSqFoot(laborCostPerSqFt);
        BigDecimal costPerSqFt = getCostPerSqFt(product);
        Double area = addArea();
        order.setArea(area);
        BigDecimal materialCost = getMaterialCost(area, costPerSqFt);
        order.setMaterialCost(materialCost);
        BigDecimal laborCost = getLaborCost(area, laborCostPerSqFt);
        order.setLaborCost(laborCost);
        taxRate = getStateTaxRate(state);
        BigDecimal tax = getTax(taxRate, laborCost, materialCost);
        MathContext mc = new MathContext(5);
        BigDecimal taxRounded = tax.round(mc);
        order.setTax(taxRounded);

        return order;
    }

    public LocalDate getLocalDate() {
        this.ld = view.getLocalDate();

        return ld;
    }

    public LocalDate getSelectedDate() {
        selectedDate = view.getSelectedDate();
        return selectedDate;
    }

    public List<Order> displayAllOrders() throws InvalidOrderException, Exception {

        // Creating a list and assigning it to the serviceLayer -> 
        // passing in the gloabal variable of selected date .
        // It is spitting the List back and reading it back.  
        List<Order> listOfOrdersFromDate = service.displayAllOrdersToDate(selectedDate);
        view.displayAllOrders(listOfOrdersFromDate);

        return listOfOrdersFromDate;
    }

    public String addCustomerName() throws InvalidOrderException {

        String customersName = view.getCustomerName();

        return customersName;

    }

    public String addState() {
        String state = view.getState();

        return state;

    }

    public double addArea() {
        double area = view.getArea();

        return area;
    }

    public String addProductType() {
        String productType = view.getProductType();

        return productType;
    }

    public String validateState(String stateName) throws InvalidStateException {
        String validatedState = service.validateState(stateName);
        return validatedState;
    }

    public String validateProduct(String product) throws InvalidProductException {
        String validatedProduct = service.validateProduct(product);
        return validatedProduct;
    }

    public BigDecimal getStateTaxRate(String stateName) throws InvalidOrderException, FileNotFoundException, InvalidStateException {
        BigDecimal stateTaxRate = service.getStateTaxRate(stateName);
        return stateTaxRate;

    }

    public BigDecimal getCostPerSqFt(String product) throws InvalidProductException, InvalidStateException {
        BigDecimal costPerSqFt = service.getCostPerSqFt(product);
        return costPerSqFt;
    }

    private BigDecimal getLaborCostPerSqFt(String product) throws InvalidProductException {
        BigDecimal laborCostPerSqFt = service.getLaborCostPerSqFt(product);
        return laborCostPerSqFt;
    }

    private BigDecimal getMaterialCost(Double area, BigDecimal costPerSqFt) {
        BigDecimal materialCost = service.getMaterialCost(costPerSqFt, area);
        return materialCost;
    }

    private BigDecimal getLaborCost(Double area, BigDecimal laborCostPerSqFt) {
        BigDecimal laborCost = service.getLaborCost(laborCostPerSqFt, area);
        return laborCost;

    }

    private BigDecimal getTax(BigDecimal taxRate, BigDecimal laborCost, BigDecimal materialCost) {
        BigDecimal tax = service.getTax(taxRate, laborCost, materialCost);
        return tax;
    }

    private BigDecimal getTotal(BigDecimal tax, BigDecimal laborCost, BigDecimal materialCost) {
        BigDecimal total = service.getTotal(tax, laborCost, materialCost);
        return total;
    }

    private void saveWork(LocalDate selectedDate) throws PersistenceException, FileNotFoundException, IOException {
        service.saveOrder(selectedDate);
    }

    private LocalDate getDateForSave() {

        int answer = view.getSaveResult();
        if (answer == 1) {
            LocalDate saveDate = LocalDate.now();
            return saveDate;
        } else {

            io.print("Please enter the date you will be saving for");
            LocalDate saveDate = view.getSelectedDate();
            return saveDate;

        }

    }

    private Order addOrder() throws InvalidOrderException, InvalidProductException, InvalidStateException, PersistenceException, DuplicateOrderException, InvalidMaterialException, FileNotFoundException, IOException {
        boolean hasStateError = true;
        boolean hasProductError = true;

        Order newOrder = new Order();
        String stateName;

        getLocalDate();

        String customerName = addCustomerName();
        newOrder.setCustomerName(customerName);
        while (hasStateError) {

            try {

                stateName = addState();
                validateState(stateName);
                newOrder.setState(stateName);
                taxRate = getStateTaxRate(stateName);
                newOrder.setStateTaxes(taxRate);
                hasStateError = false;
                break;

            } catch (InvalidStateException e) {
                io.print(e.getLocalizedMessage());
                hasStateError = true;
            }

        }

        while (hasProductError) {
            try {
                String product = addProductType();
                validateProduct(product);
                newOrder.setProductType(product);
                Double area = addArea();
                newOrder.setArea(area);
                BigDecimal costPerSqFt = getCostPerSqFt(product);
                newOrder.setCostPerSqFoot(costPerSqFt);
                BigDecimal laborCostPerSqFt = getLaborCostPerSqFt(product);
                newOrder.setLaborCostPerSqFoot(laborCostPerSqFt);
                BigDecimal materialCost = getMaterialCost(area, costPerSqFt);
                newOrder.setMaterialCost(materialCost);
                BigDecimal laborCost = getLaborCost(area, laborCostPerSqFt);
                newOrder.setLaborCost(laborCost);
                BigDecimal tax = getTax(taxRate, laborCost, materialCost);
                MathContext mc = new MathContext(5);
                BigDecimal taxRounded = tax.setScale(2, RoundingMode.DOWN);
                newOrder.setTax(taxRounded);
                System.out.println("tax: " + taxRounded);
                BigDecimal total = getTotal(tax, laborCost, materialCost);
                BigDecimal totalRounded = total.setScale(2, RoundingMode.DOWN);
                newOrder.setTotal(totalRounded);
                System.out.println("total: " + totalRounded);
                hasProductError = false;
                int answer = view.getSaveOption();
                if (answer == 1) {
                    try {

                        service.addOrder(ld, newOrder);

                    } catch (InvalidOrderException e) {
                        io.print(e.getLocalizedMessage());

                    }

                }
                break;
            } catch (InvalidProductException e) {
                io.print(e.getLocalizedMessage());
                hasProductError = true;

            }

        }
        return newOrder;
    }
}
