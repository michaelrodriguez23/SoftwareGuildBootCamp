/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mr.flooringOrders.service;

import com.mr.flooringOrders.dto.Order;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author michaelrodriguez
 */
public interface FlooringOrderService {

    public Order addOrder(LocalDate date, Order order) throws InvalidOrderException,IOException, 
    InvalidProductException, InvalidStateException, PersistenceException, DuplicateOrderException, InvalidMaterialException ;

    public List<Order> displayAllOrdersToDate(LocalDate localDate) throws InvalidOrderException, FileNotFoundException, Exception;

    public Order editOrder(LocalDate localDate, Integer orderId, Order updatedOrder) throws InvalidOrderException, FileNotFoundException;

    public void removeOrder(LocalDate localDate, Order order) throws InvalidOrderException, OrderNotFoundException, FileNotFoundException;

    public void saveOrder(LocalDate selectedDate) throws PersistenceException, FileNotFoundException, IOException;

    public Order getOrder(LocalDate localDate, int orderId) throws InvalidOrderException, FileNotFoundException ;
    
    public Order validateEditedOrder(LocalDate selectedDate, Order order, int orderId);

    public Order validateOrder(Order order) throws InvalidOrderException, DuplicateOrderException, AreaMinimumException;

    public String validateState(String stateName) throws InvalidStateException;

    public String validateProduct(String productName) throws InvalidProductException; 
    
    public BigDecimal getStateTaxRate(String stateName) throws InvalidStateException; 

    public BigDecimal getCostPerSqFt(String product) throws InvalidProductException;

    public BigDecimal getLaborCostPerSqFt(String product) throws InvalidProductException;

    public BigDecimal getMaterialCost(BigDecimal costPerSqFt, Double area);

    public BigDecimal getLaborCost(BigDecimal laborCostPerSqFt, Double area);

    public BigDecimal getTax(BigDecimal taxRate, BigDecimal laborCost, BigDecimal materialCost);

    public BigDecimal getTotal(BigDecimal tax, BigDecimal laborCost, BigDecimal materialCost);
} 


