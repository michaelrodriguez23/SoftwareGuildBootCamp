/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mr.flooringOrders.service;

import com.mr.flooringOrders.daos.OrderDao;
import com.mr.flooringOrders.daos.ProductDao;
import com.mr.flooringOrders.daos.StateTaxDao;
import com.mr.flooringOrders.dto.Order;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author michaelrodriguez
 */
public class FlooringOrderServiceImpl implements FlooringOrderService {

    private OrderDao orderDao;


    public FlooringOrderServiceImpl(OrderDao orderDao) {
        this.orderDao = orderDao;
     
   
    }

    @Override
    public Order addOrder(LocalDate localDate, Order order) throws InvalidOrderException,
            InvalidProductException, InvalidStateException, DuplicateOrderException, IOException, PersistenceException {
        if (order == null) {
            throw new DuplicateOrderException("Error could not addOrder. Order Id " + order.getOrderId() + " Already Exist");
        }
        if (order.getCustomerName() == null || order.getCustomerName().trim().length() == 0 || order.getState() == null || order.getState().trim().length() == 0 || order.getTax() == null
                || order.getProductType() == null || order.getProductType().trim().length() == 0 || order.getArea() == null || order.getCostPerSqFoot() == null || order.getLaborCostPerSqFoot() == null
                || order.getMaterialCost() == null || order.getLaborCost() == null || order.getState() == null) {
            throw new InvalidOrderException("Error : All Fields Are Required");
        }
        
        return orderDao.create(order);
    }

    @Override
    public List<Order> displayAllOrdersToDate(LocalDate selectedDate) throws InvalidOrderException, FileNotFoundException, Exception {

        if (orderDao.readAll(selectedDate) == null) {
            throw new InvalidOrderException("No Such Order Exist");
        }
        try {
            return orderDao.readAll(selectedDate);
        } catch (Exception e) {
            e.getLocalizedMessage();

        }
        return orderDao.readAll(selectedDate);
    }

    @Override
    public Order editOrder(LocalDate localDate, Integer orderId, Order updatedOrder) throws InvalidOrderException, FileNotFoundException {

        try {
            orderDao.create(updatedOrder);
            return updatedOrder;
        } catch (IOException ex) {
            Logger.getLogger(FlooringOrderServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (PersistenceException ex) {
            Logger.getLogger(FlooringOrderServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return updatedOrder;
    }

    @Override
    public void removeOrder(LocalDate localDate, Order order) throws InvalidOrderException, OrderNotFoundException, FileNotFoundException {
      orderDao.delete(localDate, order);
    }

    @Override
    public Order getOrder(LocalDate localDate, int orderId) throws InvalidOrderException, FileNotFoundException {
        return orderDao.readById(localDate, orderId);
    }

    @Override
    public Order validateEditedOrder(LocalDate selectedDate, Order order, int orderId) {

        try {
            return orderDao.update(selectedDate, orderId, order);

        } catch (FileNotFoundException ex) {
            Logger.getLogger(FlooringOrderServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return order;
    }

    public Double validateAreaInput(Double area) {
        if (area == null) {
            area = 0.00;
            return area;
        }
        return area;

    }

    @Override
    public Order validateOrder(Order order) throws InvalidOrderException, DuplicateOrderException {
        if (order.getCustomerName() == null || order.getCustomerName().trim().length() == 0 || order.getState() == null || order.getState().trim().length() == 0 || order.getTax() == null
                || order.getProductType() == null || order.getProductType().trim().length() == 0 || order.getArea() == null || order.getCostPerSqFoot() == null || order.getLaborCostPerSqFoot() == null
                || order.getMaterialCost() == null || order.getLaborCost() == null || order.getState() == null) {
            throw new InvalidOrderException("Error : All Fields Are Required");
        }
        return order;
    }

    @Override
    public String validateState(String stateName) throws InvalidStateException {

        if (stateName.equalsIgnoreCase("OH") || stateName.equalsIgnoreCase("PA") || stateName.equalsIgnoreCase("MI") || stateName.equalsIgnoreCase("IN") && stateName.trim().length() != 0) {
            return stateName;

        }
        if (stateName.equals("")) {
            return stateName;
        } else {
            throw new InvalidStateException("Error : Please Select from the following states : \n "
                    + "OH, PA, MI, IN ");
        }

    }

    @Override
    public String validateProduct(String productName) throws InvalidProductException {
        if ("carpet".equalsIgnoreCase(productName) || "tile".equalsIgnoreCase(productName) || "wood".equalsIgnoreCase(productName) || "laminate".equalsIgnoreCase(productName)) {
            return productName;
        }
        if (productName.trim().length() == 0) {
            throw new InvalidProductException("Error: Looks like you put some extra spacing there. Please Re-Enter withtout the space.");

        }
        if (productName.equals("")) {
            return productName;
        } else {
            throw new InvalidProductException("Looks like the product you entered didn't match our inventory");
        }
    }

    // public BigDecimal calcalateLaborCost(Product product) {
    //  return null;
    @Override
    public BigDecimal getStateTaxRate(String stateName) throws InvalidStateException {
        switch (stateName.toUpperCase()) {

            case "OH":
                BigDecimal stateTaxRate = new BigDecimal(6.25);
                return stateTaxRate;

            case "PA":
                stateTaxRate = new BigDecimal(6.75);
                return stateTaxRate;

            case "MI":
                stateTaxRate = new BigDecimal(5.75);
                return stateTaxRate;

            case "IN":
                stateTaxRate = new BigDecimal(6.00);

                return stateTaxRate;
            default:
                stateTaxRate = new BigDecimal(0.00);
                System.out.println("tax rate is set at 0 by default because date wasnt selected");

                return stateTaxRate;

        }

    }

    @Override
    public BigDecimal getCostPerSqFt(String product) throws InvalidProductException {
        switch (product.toUpperCase()) {

            case "CARPET":
                BigDecimal costPerSqFt = new BigDecimal(6.25);
                return costPerSqFt;

            case "LAMINATE":
                costPerSqFt = new BigDecimal(6.75);
                return costPerSqFt;

            case "TILE":
                costPerSqFt = new BigDecimal(5.75);
                return costPerSqFt;

            case "WOOD":
                costPerSqFt = new BigDecimal(6.00);
                return costPerSqFt;

            case "":
                costPerSqFt = new BigDecimal(0.00);
                return costPerSqFt;
            default:
                throw new InvalidProductException("Something is not right here");

        }
    }

    @Override
    public BigDecimal getLaborCostPerSqFt(String product) throws InvalidProductException {
        switch (product.toUpperCase()) {

            case "CARPET":
                BigDecimal laborCostPerSqFt = new BigDecimal(2.10);
                return laborCostPerSqFt;

            case "LAMINATE":
                laborCostPerSqFt = new BigDecimal(2.10);
                return laborCostPerSqFt;

            case "TILE":
                laborCostPerSqFt = new BigDecimal(4.15);
                return laborCostPerSqFt;

            case "WOOD":
                laborCostPerSqFt = new BigDecimal(4.75);
                return laborCostPerSqFt;
            case "":
                laborCostPerSqFt = new BigDecimal(4.75);
                return laborCostPerSqFt;

            default:
                throw new InvalidProductException("Something is not right here");
        }
    }

    @Override
    public BigDecimal getMaterialCost(BigDecimal costPerSqFt, Double area) {
        BigDecimal materialCost = new BigDecimal(area).multiply(costPerSqFt).setScale(2, RoundingMode.DOWN);
        return materialCost;

    }

    @Override
    public BigDecimal getLaborCost(BigDecimal laborCostPerSqFt, Double area) {
        BigDecimal laborCost = new BigDecimal(area).multiply(laborCostPerSqFt).setScale(2, RoundingMode.DOWN);
        return laborCost;

        
    }

    @Override
    public BigDecimal getTax(BigDecimal taxRate, BigDecimal laborCost, BigDecimal materialCost) {
        BigDecimal laborAndMaterialCost = (laborCost.add(materialCost));
        BigDecimal taxTotal = laborAndMaterialCost.multiply(taxRate).multiply(new BigDecimal(.100).setScale(2, RoundingMode.FLOOR));
        return taxTotal;
    }

    @Override
    public BigDecimal getTotal(BigDecimal taxTotal, BigDecimal laborCost, BigDecimal materialCost) {
        BigDecimal total = (laborCost.add(materialCost).add(taxTotal));
        return total;
    }

    @Override
    public void saveOrder(LocalDate selectedDate) throws PersistenceException, FileNotFoundException, IOException {
        orderDao.saveOrder(selectedDate);
    }

}
