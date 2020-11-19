/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mr.flooringOrders.service;

import com.mr.flooringOrders.daos.OrderDao;
import com.mr.flooringOrders.daos.OrderDaoProdStubImpl;
import com.mr.flooringOrders.dto.Order;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.Test;

/**
 *
 * @author michaelrodriguez
 */
public class FlooringOrderServiceImplTest {

    // class level variable of service layer
    private FlooringOrderServiceImpl service;

    private OrderDaoProdStubImpl dao = new OrderDaoProdStubImpl();

    public FlooringOrderServiceImplTest() {
        //ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        OrderDao dao = new OrderDaoProdStubImpl();

        service = new FlooringOrderServiceImpl(dao);

    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of addOrder method, of class FlooringOrderServiceImpl.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testAddOrder() throws Exception {
        LocalDate ld = LocalDate.now();

        Order order = new Order();
        order.setOrderId(02);
        order.setCustomerName("sally");
        order.setProductType("wood");
        order.setState("OH");
        order.setArea(1.00);
        order.setCostPerSqFoot(BigDecimal.valueOf(1));
        order.setLaborCost(BigDecimal.valueOf(1));
        order.setLaborCostPerSqFoot(BigDecimal.valueOf(1));
        order.setStateTaxes(BigDecimal.valueOf(1));
        order.setMaterialCost(BigDecimal.valueOf(1));
        order.setTax(BigDecimal.valueOf(1));

        service.addOrder(ld, order);

    }

    @Test
    public void testCreateOrderDuplicateId() throws Exception {
        LocalDate ld = LocalDate.now();

        Order order = new Order();
        order.setOrderId(01);
        order.setCustomerName("sally");
        order.setProductType("wood");
        order.setState("OH");

        try {
            service.addOrder(ld, order);
            fail("Expected InvalidOrderException was not thrown");
        } catch (InvalidOrderException e) {
            return;
        }

    }

    @Test
    public void testCreateOrderInvalid() throws Exception {
        LocalDate ld = LocalDate.now();

        Order order = new Order();
        order.setOrderId(02);
        order.setCustomerName("sally");
        order.setProductType("");
        order.setState("");

        try {
            service.addOrder(ld, order);
            fail("Expected InvalidOrderException was not thrown");
        } catch (InvalidOrderException e) {
            return;
        }

    }

    /**
     * Test of displayAllOrdersToDate method, of class FlooringOrderServiceImpl.
     */
    @Test
    public void testDisplayAllOrdersToDate() throws Exception {
        LocalDate ld = LocalDate.now();

        Order order = new Order();
        order.setOrderId(02);
        order.setCustomerName("sally");
        order.setProductType("wood");
        order.setState("OH");
        order.setArea(1.00);
        order.setCostPerSqFoot(BigDecimal.valueOf(1));
        order.setLaborCost(BigDecimal.valueOf(1));
        order.setLaborCostPerSqFoot(BigDecimal.valueOf(1));
        order.setStateTaxes(BigDecimal.valueOf(1));
        order.setMaterialCost(BigDecimal.valueOf(1));
        order.setTax(BigDecimal.valueOf(1));

        service.addOrder(ld, order);
        assertEquals(1, service.displayAllOrdersToDate(ld).size());
    }

    /**
     * Test of editOrder method, of class FlooringOrderServiceImpl.
     */
    @Test
    public void testEditOrder() throws Exception {
        LocalDate ld = LocalDate.now();

        Order order = new Order();
        order.setOrderId(02);
        order.setCustomerName("sally");
        order.setProductType("wood");
        order.setState("OH");
        order.setArea(1.00);
        order.setCostPerSqFoot(BigDecimal.valueOf(1));
        order.setLaborCost(BigDecimal.valueOf(1));
        order.setLaborCostPerSqFoot(BigDecimal.valueOf(1));
        order.setStateTaxes(BigDecimal.valueOf(1));
        order.setMaterialCost(BigDecimal.valueOf(1));
        order.setTax(BigDecimal.valueOf(1));

        order = service.addOrder(ld, order);

        order.setCustomerName("jolly");

        Order fromDao = service.editOrder(ld, order.getOrderId(), order);

        assertEquals(order, fromDao);

    }

    /**
     * Test of removeOrder method, of class FlooringOrderServiceImpl.
     */
    @Test
    public void testRemoveOrder() throws Exception {
        // Program doesnt do this
    }

    /**
     * Test of getOrder method, of class FlooringOrderServiceImpl.
     */
    @Test
    public void testGetOrder() throws Exception {
        LocalDate ld = LocalDate.now();

        Order order = new Order();
        order.setOrderId(02);
        order.setCustomerName("sally");
        order.setProductType("wood");
        order.setState("OH");
        order.setArea(1.00);
        order.setCostPerSqFoot(BigDecimal.valueOf(1));
        order.setLaborCost(BigDecimal.valueOf(1));
        order.setLaborCostPerSqFoot(BigDecimal.valueOf(1));
        order.setStateTaxes(BigDecimal.valueOf(1));
        order.setMaterialCost(BigDecimal.valueOf(1));
        order.setTax(BigDecimal.valueOf(1));

        order = service.addOrder(ld, order);

        Order fromDao = service.getOrder(ld, order.getOrderId());

        assertEquals(order, fromDao);

    }

    /**
     * Test of validateEditedOrder method, of class FlooringOrderServiceImpl.
     */
    @Test
    public void testValidateEditedOrder() throws InvalidOrderException, InvalidProductException, InvalidStateException, DuplicateOrderException, IOException, PersistenceException {
        LocalDate ld = LocalDate.now();

        Order order = new Order();
        order.setOrderId(02);
        order.setCustomerName("sally");
        order.setProductType("wood");
        order.setState("OH");
        order.setArea(1.00);
        order.setCostPerSqFoot(BigDecimal.valueOf(1));
        order.setLaborCost(BigDecimal.valueOf(1));
        order.setLaborCostPerSqFoot(BigDecimal.valueOf(1));
        order.setStateTaxes(BigDecimal.valueOf(1));
        order.setMaterialCost(BigDecimal.valueOf(1));
        order.setTax(BigDecimal.valueOf(1));

        order.setCustomerName("");

        try {
            order = service.addOrder(ld, order);
            fail("Expected InvalidOrderException was not thrown");
        } catch (InvalidOrderException e) {
            return;
        }

        Order fromDao = service.editOrder(ld, order.getOrderId(), order);

        assertEquals(order, fromDao);

    }

    /**
     * Test of validateAreaInput method, of class FlooringOrderServiceImpl.
     */
    @Test
    public void testValidateAreaInput() throws InvalidOrderException, InvalidProductException, InvalidStateException, DuplicateOrderException, IOException, PersistenceException {
        LocalDate ld = LocalDate.now();

        Order order = new Order();
        order.setOrderId(02);
        order.setCustomerName("sally");
        order.setProductType("wood");
        order.setState("OH");
        // removed set area 
        order.setCostPerSqFoot(BigDecimal.valueOf(1));
        order.setLaborCost(BigDecimal.valueOf(1));
        order.setLaborCostPerSqFoot(BigDecimal.valueOf(1));
        order.setStateTaxes(BigDecimal.valueOf(1));
        order.setMaterialCost(BigDecimal.valueOf(1));
        order.setTax(BigDecimal.valueOf(1));

        try {
            order = service.addOrder(ld, order);
            fail("Expected InvalidStateException was not thrown");
        } catch (InvalidOrderException e) {
            return;
        }
    }

    /**
     * Test of validateOrder method, of class FlooringOrderServiceImpl.
     */
    @Test
    public void testValidateOrder() throws Exception {
        // already tested above
    }

    /**
     * Test of validateState method, of class FlooringOrderServiceImpl.
     */
    @Test
    public void testValidateState() throws Exception, InvalidStateException {
        LocalDate ld = LocalDate.now();

        Order order = new Order();
        order.setOrderId(02);
        order.setCustomerName("sally");
        order.setProductType("wood");
        order.setState("NY");
        order.setArea(1.00);
        order.setCostPerSqFoot(BigDecimal.valueOf(1));
        order.setLaborCost(BigDecimal.valueOf(1));
        order.setLaborCostPerSqFoot(BigDecimal.valueOf(1));
        order.setStateTaxes(BigDecimal.valueOf(1));
        order.setMaterialCost(BigDecimal.valueOf(1));
        order.setTax(BigDecimal.valueOf(1));

        try {
            service.validateState(order.getState());
            fail("Expected InvalidStateException was not thrown");
        } catch (InvalidStateException e) {
            return;

        }
    }

    /**
     * Test of validateProduct method, of class FlooringOrderServiceImpl.
     */
    @Test
    public void testValidateProduct() throws Exception {
        LocalDate ld = LocalDate.now();

        Order order = new Order();
        order.setOrderId(02);
        order.setCustomerName("sally");
        order.setProductType("plasti");
        order.setState("OH");
        order.setArea(1.00);
        order.setCostPerSqFoot(BigDecimal.valueOf(1));
        order.setLaborCost(BigDecimal.valueOf(1));
        order.setLaborCostPerSqFoot(BigDecimal.valueOf(1));
        order.setStateTaxes(BigDecimal.valueOf(1));
        order.setMaterialCost(BigDecimal.valueOf(1));
        order.setTax(BigDecimal.valueOf(1));

        try {
            service.validateProduct(order.getProductType());
            fail("Expected InvalidProductException was not thrown");
        } catch (InvalidProductException e) {
            return;

        }

    }

    /**
     * Test of getStateTaxRate method, of class FlooringOrderServiceImpl.
     */
    @Test
    public void testGetStateTaxRate() throws Exception, InvalidStateException {
        LocalDate ld = LocalDate.now();

        Order order = new Order();
        order.setOrderId(02);
        order.setCustomerName("sally");
        order.setProductType("wood");
        order.setState("NY"); // changed to NY which is invalid
        order.setArea(1.00);
        order.setCostPerSqFoot(BigDecimal.valueOf(1));
        order.setLaborCost(BigDecimal.valueOf(1));
        order.setLaborCostPerSqFoot(BigDecimal.valueOf(1));
        order.setStateTaxes(BigDecimal.valueOf(1));
        order.setMaterialCost(BigDecimal.valueOf(1));
        order.setTax(BigDecimal.valueOf(1));

        service.getStateTaxRate(order.getState());

    }

    /**
     * Test of getCostPerSqFt method, of class FlooringOrderServiceImpl.
     */
    @Test
    public void testGetCostPerSqFt() throws Exception {
        LocalDate ld = LocalDate.now();

        Order order = new Order();
        order.setOrderId(02);
        order.setCustomerName("sally");
        order.setProductType("wood");
        order.setState("NY"); // changed to NY which is invalid
        order.setArea(1.00);
        order.setCostPerSqFoot(BigDecimal.valueOf(1));
        order.setLaborCost(BigDecimal.valueOf(1));
        order.setLaborCostPerSqFoot(BigDecimal.valueOf(1));
        order.setStateTaxes(BigDecimal.valueOf(1));
        order.setMaterialCost(BigDecimal.valueOf(1));
        order.setTax(BigDecimal.valueOf(1));

        service.getCostPerSqFt(order.getProductType());
    }

    /**
     * Test of getLaborCostPerSqFt method, of class FlooringOrderServiceImpl.
     */
    @Test
    public void testGetLaborCostPerSqFt() throws Exception {
        LocalDate ld = LocalDate.now();

        Order order = new Order();
        order.setOrderId(02);
        order.setCustomerName("sally");
        order.setProductType("wood");
        order.setState("NY"); // changed to NY which is invalid
        order.setArea(1.00);
        order.setCostPerSqFoot(BigDecimal.valueOf(1));
        order.setLaborCost(BigDecimal.valueOf(1));
        order.setLaborCostPerSqFoot(BigDecimal.valueOf(1));
        order.setStateTaxes(BigDecimal.valueOf(1));
        order.setMaterialCost(BigDecimal.valueOf(1));
        order.setTax(BigDecimal.valueOf(1));

        service.getLaborCostPerSqFt(order.getProductType());

    }

    /**
     * Test of getMaterialCost method, of class FlooringOrderServiceImpl.
     */
    @Test
    public void testGetMaterialCost() {
        LocalDate ld = LocalDate.now();

        Order order = new Order();
        order.setOrderId(02);
        order.setCustomerName("sally");
        order.setProductType("wood");
        order.setState("NY"); // changed to NY which is invalid
        order.setArea(1.00);
        order.setCostPerSqFoot(BigDecimal.valueOf(1));
        order.setLaborCost(BigDecimal.valueOf(1));
        order.setLaborCostPerSqFoot(BigDecimal.valueOf(1));
        order.setStateTaxes(BigDecimal.valueOf(1));
        order.setMaterialCost(BigDecimal.valueOf(1));
        order.setTax(BigDecimal.valueOf(1));

        service.getMaterialCost(order.getCostPerSqFoot(), order.getArea());

    }

    /**
     * Test of getLaborCost method, of class FlooringOrderServiceImpl.
     */
    @Test
    public void testGetLaborCost() {
        LocalDate ld = LocalDate.now();

        Order order = new Order();
        order.setOrderId(02);
        order.setCustomerName("sally");
        order.setProductType("wood");
        order.setState("NY"); // changed to NY which is invalid
        order.setArea(1.00);
        order.setCostPerSqFoot(BigDecimal.valueOf(1));
        order.setLaborCost(BigDecimal.valueOf(1));
        order.setLaborCostPerSqFoot(BigDecimal.valueOf(1));
        order.setStateTaxes(BigDecimal.valueOf(1));
        order.setMaterialCost(BigDecimal.valueOf(1));
        order.setTax(BigDecimal.valueOf(1));

        service.getLaborCost(order.getCostPerSqFoot(), order.getArea());

    }

    /**
     * Test of getTax method, of class FlooringOrderServiceImpl.
     */
    @Test
    public void testGetTax() {
        LocalDate ld = LocalDate.now();

        Order order = new Order();
        order.setOrderId(02);
        order.setCustomerName("sally");
        order.setProductType("wood");
        order.setState("NY"); // changed to NY which is invalid
        order.setArea(1.00);
        order.setCostPerSqFoot(BigDecimal.valueOf(1));
        order.setLaborCost(BigDecimal.valueOf(1));
        order.setLaborCostPerSqFoot(BigDecimal.valueOf(1));
        order.setStateTaxes(BigDecimal.valueOf(1));
        order.setMaterialCost(BigDecimal.valueOf(1));
        order.setTax(BigDecimal.valueOf(1));

        service.getTax(order.getStateTaxes(), order.getLaborCost(), order.getMaterialCost());

    }

    /**
     * Test of getTotal method, of class FlooringOrderServiceImpl.
     */
    @Test
    public void testGetTotal() {
        LocalDate ld = LocalDate.now();

        Order order = new Order();
        order.setOrderId(02);
        order.setCustomerName("sally");
        order.setProductType("wood");
        order.setState("NY"); // changed to NY which is invalid
        order.setArea(1.00);
        order.setCostPerSqFoot(BigDecimal.valueOf(1));
        order.setLaborCost(BigDecimal.valueOf(1));
        order.setLaborCostPerSqFoot(BigDecimal.valueOf(1));
        order.setStateTaxes(BigDecimal.valueOf(1));
        order.setMaterialCost(BigDecimal.valueOf(1));
        order.setTax(BigDecimal.valueOf(1));

        service.getTotal(order.getTax(), order.getLaborCost(), order.getMaterialCost());

    }

    /**
     * Test of saveOrder method, of class FlooringOrderServiceImpl.
     */
    @Test
    public void testSaveOrder() throws Exception {
        LocalDate ld = LocalDate.now();

        Order order = new Order();
        order.setOrderId(02);
        order.setCustomerName("sally");
        order.setProductType("wood");
        order.setState("NY"); // changed to NY which is invalid
        order.setArea(1.00);
        order.setCostPerSqFoot(BigDecimal.valueOf(1));
        order.setLaborCost(BigDecimal.valueOf(1));
        order.setLaborCostPerSqFoot(BigDecimal.valueOf(1));
        order.setStateTaxes(BigDecimal.valueOf(1));
        order.setMaterialCost(BigDecimal.valueOf(1));
        order.setTax(BigDecimal.valueOf(1));

        service.saveOrder(ld);
    }
}
