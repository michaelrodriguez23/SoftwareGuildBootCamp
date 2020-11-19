/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mr.flooringOrders.daos;

import com.mr.flooringOrders.dto.Order;
import com.mr.flooringOrders.service.PersistenceException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

/**
 *
 * @author michaelrodriguez
 */
public interface OrderDao {
    
    

    public Order create(Order order) throws IOException, PersistenceException;

    public List<Order> readAll(LocalDate localDate)throws FileNotFoundException;

    public Order readById(LocalDate localDate,Integer orderId) throws FileNotFoundException;

    public Order update(LocalDate localDate, Integer orderId, Order updatedOrder) throws FileNotFoundException;

    public void delete(LocalDate localDate, Order order) throws FileNotFoundException;
    
    public void saveOrder(LocalDate selectedDate) throws PersistenceException, IOException; 

}
