/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mr.flooringOrders.ui;

import com.mr.flooringOrders.dto.Order;
import com.mr.flooringOrders.dto.Product;
import com.mr.flooringOrders.dto.StateTax;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 *
 * @author michaelrodriguez
 */
public class FlooringOrdersView {

    private UserIo io;

    public FlooringOrdersView(UserIo io) {
        this.io = io;
    }

    public int getMenuSelection() {

        return io.readInt(" *  <<Flooring Program>>\n"
                + "    * 1. Display Orders\n"
                + "    * 2. Add an Order\n"
                + "    * 3. Edit an Order\n"
                + "    * 4. Remove an Order\n"
                + "    * 5. Save Current Work\n"
                + "    * 6. Quit \n"
                + "Enter Menu Selection",
                1, 6);

    }

    public int getOrderById() {
        String id = io.readString("Enter Order Id");
        int parsedInt = Integer.parseInt(id);
        return parsedInt;

    }

    public Order editOrder(Order updatedOrder) {

        String customerName = getCustomerName();
        String product = getProductType();
        String state = getState();
        Double area = getArea();

        if (customerName.trim().length() == 0) {
            updatedOrder.setCustomerName(updatedOrder.getCustomerName());
        } else {
            updatedOrder.setCustomerName(customerName);
        }
        if (product.trim().length() == 0) {
            updatedOrder.setProductType(updatedOrder.getProductType());
        } else {
            updatedOrder.setProductType(product);
        }
        if (state.trim().length() == 0) {
            updatedOrder.setState(updatedOrder.getState());
        } else {
            updatedOrder.setState(state);
        }
        if (area.isNaN()) {
            updatedOrder.setArea(updatedOrder.getArea());
        } else {
            updatedOrder.setArea(area);

        }

        return updatedOrder;

    }

    public Order getNewOrderInfo(List<Product> products, List<StateTax> taxes) {
        return null;

    }

    public String getCustomerName() {
        return io.readString("Enter Name");

    }

    public String getState() {
        return io.readString("Enter Valid State");

    }

    public double getArea() {
        return io.readDouble("Enter Area");

    }

    public String getProductType() {
        return io.readString("Enter Prouduct Type");

    }

    public BigDecimal getStateTaxRate(Order order) {
        return order.getTax();

    }

    public void displayAllOrders(List<Order> ordersList) {

        ordersList.forEach(order -> System.out.print("================================\n"+ "Order # : " + order.getOrderId() + "\n " + "Customer's Name : " + order.getCustomerName() + "\n "
               + "State : " + order.getState() + "\n " + "State Tax : " + order.getStateTaxes().setScale(2, RoundingMode.DOWN) + "\n " +"Product Type: " + order.getProductType() + "\n " +"Area : "+ order.getArea() + "\n "
                + "Cost Per Square Foot : "+ order.getCostPerSqFoot().setScale(2, RoundingMode.DOWN) + "\n " +"Labor Cost : "+ order.getLaborCostPerSqFoot().setScale(2, RoundingMode.DOWN) + "\n " +"Material Cost : "+ order.getMaterialCost().setScale(2, RoundingMode.DOWN) + "\n "
               + "Labor Cost : "+ order.getLaborCost().setScale(2, RoundingMode.DOWN) + "\n " + "Tax : "+ order.getTax().setScale(2, RoundingMode.DOWN) + "\n " +"Total : "+ order.getTotal().setScale(2, RoundingMode.DOWN) + "\n"
              + "___________________________________\n" ));

    }

    public void displaySelectedOrder(Order order) {
        io.print(order.toString());

    }

    public LocalDate getLocalDate() {
        LocalDate localDate = LocalDate.now();

        return localDate;
    }

    public LocalDate getSelectedDate() {
        String selectedDate = io.readString("Enter Date You Wish to Retrieve Orders From : MMDDYYYY");
        LocalDate dateParsed = LocalDate.parse(selectedDate, DateTimeFormatter.ofPattern("MMddyyyy"));
        return dateParsed;
    }

    public int displayEditOptions() {
        return io.readInt("Edit + \n"
                + "1. Edit Name \n"
                + "2. Edit State \n "
                + "3. Edit Product \n"
                + "4. Edit Area \n",
                1, 4);

    }

    public int getSaveOption() {
        return io.readInt("Save Order?  \n"
                + "1. YES  \n"
                + "2. NO  \n",
                 1, 2);
    }

    public void displayEditBanner() {
        io.print("========Edit Order==========\n"
                + "So let me break this down.\n"
                + "After selecting the order,\n"
                + "If you add something new to the order.\n"
                + "It will overr-ride what you had before.\n"
                + "If it remains blank that no updates will occur.");
    }

    public int getSaveResult() {
        int answer = io.readInt("Are you saving an order from today\n"
                + "1. Yes\n"
                + "2. No", 1, 2);
        return answer;
    }
    
    public int getDeleteConfirmation(Order deletedOrder) { 
        int orderNumber = deletedOrder.getOrderId();
        String orderName = deletedOrder.getCustomerName();
       
        int answer = io.readInt("Are you sure you want to delete this order? \n"
                + "OrderId: " + orderNumber + ", OrderName: " + orderName + " \n"
                + "1. Y \n"
                + "2. N ", 1, 2);
        return answer;
    }
}


