/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mr.flooringOrders.daos;

import com.mr.flooringOrders.dto.Order;
import com.mr.flooringOrders.dto.Product;
import com.mr.flooringOrders.dto.StateTax;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


/**
 *
 * @author michaelrodriguez
 */
public class OrderDaoFileProdImplTest {

    private OrderDaoFileProdImpl orderDao = new OrderDaoFileProdImpl();


    @BeforeAll
    public static void setUpClass() {
    }

    @AfterAll
    public static void tearDownClass() {
    }

    @BeforeEach
    public void setUp() throws FileNotFoundException {
    }

    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of save method, of class OrderDaoFileProdImpl.
     */
    @Test
    public void testSave() throws Exception {
    }

    /**
     * Test of create method, of class OrderDaoFileProdImpl.
     */
    @Test
    public void testCreate() throws Exception {
        LocalDate ld = LocalDate.now();

        Product product = new Product();
        product.setProductType("Tile");
        product.setCostPerSquareFoot(BigDecimal.valueOf(3.50));
        product.setLaborCostPerSquareFoot(BigDecimal.valueOf(4.15));

        StateTax state = new StateTax();
        state.setState("OH");
        state.setTaxRate(BigDecimal.valueOf(3.00));

        Order order = new Order();
        order.setCustomerName("Janet");
        order.setState(state.getState());
        order.setTax(BigDecimal.valueOf(5.00));
        order.setProductType(product.getProductType());
        order.setArea(3.00);
        order.setCostPerSqFoot(product.getCostPerSquareFoot());
        order.setLaborCostPerSqFoot(product.getLaborCostPerSquareFoot());
        order.setMaterialCost(BigDecimal.valueOf(10.00));
        order.setLaborCost(BigDecimal.valueOf(3.00));
        order.setTax(state.getTaxRate());
        order.setOrderId(1);
        

        order = orderDao.create(order);

        Order fromDao = orderDao.readById(ld, order.getOrderId());

        assertEquals(order, fromDao);

    }


    /**
     * Test of readAll method, of class OrderDaoFileProdImpl.
     */
    @Test
    public void testReadAll() throws Exception {
      LocalDate ld = LocalDate.now();

        Product product = new Product();
        product.setProductType("Tile");
        product.setCostPerSquareFoot(BigDecimal.valueOf(3.50));
        product.setLaborCostPerSquareFoot(BigDecimal.valueOf(4.15));

        StateTax state = new StateTax();
        state.setState("OH");
        state.setTaxRate(BigDecimal.valueOf(3.00));

        Order order = new Order();
        order.setCustomerName("Janet");
        order.setState(state.getState());
        order.setTax(BigDecimal.valueOf(5.00));
        order.setProductType(product.getProductType());
        order.setArea(3.00);
        order.setCostPerSqFoot(product.getCostPerSquareFoot());
        order.setLaborCostPerSqFoot(product.getLaborCostPerSquareFoot());
        order.setMaterialCost(BigDecimal.valueOf(10.00));
        order.setLaborCost(BigDecimal.valueOf(3.00));
        order.setTax(state.getTaxRate());
        order.setOrderId(1);

        order = orderDao.create(order);
        
        Order order2 = new Order();
        order2.setCustomerName("michael");
        order2.setState(state.getState());
        order2.setTax(BigDecimal.valueOf(5.00));
        order2.setProductType(product.getProductType());
        order2.setArea(3.00);
        order2.setCostPerSqFoot(product.getCostPerSquareFoot());
        order2.setLaborCostPerSqFoot(product.getLaborCostPerSquareFoot());
        order2.setMaterialCost(BigDecimal.valueOf(10.00));
        order2.setLaborCost(BigDecimal.valueOf(3.00));
        order2.setTax(state.getTaxRate());
        order2.setOrderId(1);

        order2 = orderDao.create(order2);
        
        List <Order> orders = orderDao.readAll(ld);

        assertEquals(2, orders.size());
        assertTrue(orders.contains(order));

        
        

        Order fromDao = orderDao.readById(ld, order.getOrderId());

        assertEquals(order, fromDao);
    }

    /**
     * Test of readById method, of class OrderDaoFileProdImpl.
     */
    @Test
    public void testReadById() throws Exception {
 
        // Tested from the Create method
    }

    /**
     * Test of update method, of class OrderDaoFileProdImpl.
     * @throws java.lang.Exception
     */
    @Test
    public void testUpdate() throws Exception {
     LocalDate ld = LocalDate.now();

        Product product = new Product();
        product.setProductType("Tile");
        product.setCostPerSquareFoot(BigDecimal.valueOf(3.50));
        product.setLaborCostPerSquareFoot(BigDecimal.valueOf(4.15));

        StateTax state = new StateTax();
        state.setState("OH");
        state.setTaxRate(BigDecimal.valueOf(3.00));

        Order order = new Order();
        order.setCustomerName("Janet");
        order.setState(state.getState());
        order.setTax(BigDecimal.valueOf(5.00));
        order.setProductType(product.getProductType());
        order.setArea(3.00);
        order.setCostPerSqFoot(product.getCostPerSquareFoot());
        order.setLaborCostPerSqFoot(product.getLaborCostPerSquareFoot());
        order.setMaterialCost(BigDecimal.valueOf(10.00));
        order.setLaborCost(BigDecimal.valueOf(3.00));
        order.setTax(state.getTaxRate());
        order.setOrderId(1);

        order = orderDao.create(order);

        Order fromDao = orderDao.readById(ld, order.getOrderId());

        assertEquals(order, fromDao);
        
        order.setCustomerName("michelle");
        
        order = orderDao.update(ld, 1, order);
         assertEquals(order, fromDao);
    }

    /**
     * Test of delete method, of class OrderDaoFileProdImpl.
     */
    @Test
    public void testDelete() throws Exception {
   // There is no delete functionality in this program 
   

    }

}
