/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mr.flooringOrders.daos;

import com.mr.flooringOrders.dto.Order;
import com.mr.flooringOrders.dto.Product;
import com.mr.flooringOrders.dto.StateTax;
import com.mr.flooringOrders.service.PersistenceException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.stereotype.Repository;

/**
 *
 * @author michaelrodriguez
 */
@Repository
public class OrderDaoProdStubImpl implements OrderDao {

    private Map<LocalDate, Map<Integer, Order>> orders = new HashMap<>();
      Map<Integer, Order> orderList = new HashMap<>();
      
      


        Product onlyProduct;
        Order onlyOrder;
        StateTax onlyState;

 
    
    

    

    public void OrderDaoProdStubImpl() {
        LocalDate ld = LocalDate.now();


        onlyProduct = new Product();
        onlyProduct.setProductType("Tile");
        onlyProduct.setCostPerSquareFoot(BigDecimal.valueOf(3.50));
        onlyProduct.setLaborCostPerSquareFoot(BigDecimal.valueOf(4.15));

     
        onlyState = new StateTax();
        onlyState.setState("NY");
        onlyState.setTaxRate(BigDecimal.valueOf(3.00));

       
        onlyOrder = new Order();
        onlyOrder.setOrderId(01);
        onlyOrder.setCustomerName("Bob");
        onlyOrder.setState(onlyState.getState());
        onlyOrder.setTax(BigDecimal.valueOf(2.00));
        onlyOrder.setProductType(onlyProduct.getProductType());
        onlyOrder.setArea(10.00);
        onlyOrder.setCostPerSqFoot(onlyProduct.getCostPerSquareFoot());
        onlyOrder.setLaborCostPerSqFoot(onlyProduct.getLaborCostPerSquareFoot());
        onlyOrder.setMaterialCost(BigDecimal.valueOf(10.00));
        onlyOrder.setLaborCost(BigDecimal.valueOf(3.00));
        onlyOrder.setTax(onlyState.getTaxRate());

     
        orderList.put(onlyOrder.getOrderId(), onlyOrder);
        
        
        
        orders.put(ld, orderList);

    }

    /**
     *
     * @param order
     * @return
     * @throws java.io.IOException
     * @throws com.mr.flooringOrders.service.PersistenceException
     */
    @Override
    public Order create(Order order) throws IOException, PersistenceException {
            LocalDate ld = LocalDate.now();


        onlyProduct = new Product();
        onlyProduct.setProductType("Tile");
        onlyProduct.setCostPerSquareFoot(BigDecimal.valueOf(3.50));
        onlyProduct.setLaborCostPerSquareFoot(BigDecimal.valueOf(4.15));

     
        onlyState = new StateTax();
        onlyState.setState("NY");
        onlyState.setTaxRate(BigDecimal.valueOf(3.00));

       
        onlyOrder = new Order();
        onlyOrder.setOrderId(01);
        onlyOrder.setCustomerName("Bob");
        onlyOrder.setState(onlyState.getState());
        onlyOrder.setTax(BigDecimal.valueOf(2.00));
        onlyOrder.setProductType(onlyProduct.getProductType());
        onlyOrder.setArea(10.00);
        onlyOrder.setCostPerSqFoot(onlyProduct.getCostPerSquareFoot());
        onlyOrder.setLaborCostPerSqFoot(onlyProduct.getLaborCostPerSquareFoot());
        onlyOrder.setMaterialCost(BigDecimal.valueOf(10.00));
        onlyOrder.setLaborCost(BigDecimal.valueOf(3.00));
        onlyOrder.setTax(onlyState.getTaxRate());

     
        orderList.put(onlyOrder.getOrderId(), onlyOrder);
        
        
        
        orders.put(ld, orderList);
        
        int orderId = order.getOrderId();
        if ((orderId == order.getOrderId())) {
            return onlyOrder;
        } else {
            return null;
        }
    }

    @Override
    public List<Order> readAll(LocalDate localDate) throws FileNotFoundException {
          orderList = orders.get(localDate);

        List<Order> orders = orderList.values()
                .stream()
                .collect(Collectors.toList());

        return orders;
    }

    @Override
    public Order readById(LocalDate localDate, Integer orderId) throws FileNotFoundException {
        Integer onlyOrderId = onlyOrder.getOrderId();

        if (onlyOrderId.equals(orderId)) {
            return onlyOrder;
        } else {
            return null;
        }
    }

    @Override
    public Order update(LocalDate localDate, Integer orderId, Order updatedOrder) throws FileNotFoundException {
        Order order = readById(localDate, orderId);
        if (order.equals(onlyOrder)) {
            return onlyOrder;
        } else {
            return null;
        }

    }

    @Override
    public void saveOrder(LocalDate selectedDate) throws PersistenceException, IOException {

    }

    @Override
    public void delete(LocalDate localDate, Order order) throws FileNotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
