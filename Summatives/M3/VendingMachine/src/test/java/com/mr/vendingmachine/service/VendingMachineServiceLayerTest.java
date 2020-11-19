/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mr.vendingmachine.service;

import com.mr.vendingmachine.dao.VendingMachineDao;
import com.mr.vendingmachine.dao.VendingMachineDaoStubImpl;
import com.mr.vendingmachine.dto.Coin;
import com.mr.vendingmachine.dto.Item;
import java.math.BigDecimal;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author michaelrodriguez
 */
public class VendingMachineServiceLayerTest {

    // Instanciating the service , Stub dao 
    private VendingMachineServiceLayer service;

    private VendingMachineDao dao = new VendingMachineDaoStubImpl();

    public VendingMachineServiceLayerTest() {

        // This is instantiating the Application context, and reading the test file for appContext.xml
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        // We are asking for the bean for the service layer 
        // because that is what we are testing

        // The 1st parameter is the id for the bean, and the 2nd parameter is the class
        // VendingMachineServiceLayer  is the class above using the member field service. 
        // So we are casting the class . 
        service = ctx.getBean("serviceLayer", VendingMachineServiceLayer.class);

//        //Imported & Instantiated
//        VendingMachineDao dao = new VendingMachineDaoStubImpl();
//        VendingMachineAuditDao auditDao = new VendingMachineAuditDaoStubImpl();
////
//        //Initializing the service class member variable. 
//        // Pass in the dao, and auditDao 
//        // to wire them together 
//        service = new VendingMachineServiceLayerImpl(dao, auditDao);
    }

    @BeforeAll
    public static void setUpClass() {
    }

    @AfterAll
    public static void tearDownClass() {
    }

    @BeforeEach
    public void setUp() {
    }

    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of getItems method, of class VendingMachineServiceLayer.
     */
    @Test
    public void testGetItems() throws Exception {

        List<Item> items = dao.getAllItems();

        assertEquals(3, items.size());

    }

    /**
     * Test of insertMoney method, of class VendingMachineServiceLayer.
     */
    @Test
    public void testInsertMoney() {

        BigDecimal testBigDecimal = service.insertMoney(new BigDecimal("2.00"));
        BigDecimal expectedDecimal = new BigDecimal("2.00");

        assertEquals(testBigDecimal, expectedDecimal, "Should Be the same");

    }

    /**
     * Test of selectItem method, of class VendingMachineServiceLayer.
     */
    // Happy Path 
    @Test
    public void testItemNotFound() throws Exception {

        service.getItems();

        service.insertMoney(new BigDecimal("3.00"));

        try {
            service.selectItem("E99");
            fail("Item shouldn't be found");
        } catch (ItemNotFoundException e) {
            // add exception here
            return;

        }

    }

    @Test
    public void testInsufficientFunds() throws Exception {
        service.insertMoney(new BigDecimal(.2));
        service.selectItem("C1");
        //service.selectItem("C1");

        try {

            service.vendItem();
            fail("Should Be Insufficient");
        } catch (InsufficientFundException e) {
            return;

        }
    }

    @Test
    public void testReturnChange() throws Exception {
        service.insertMoney(new BigDecimal(1.25));
        service.selectItem("C1");
        Coin expectedCoin1 = new Coin();
        expectedCoin1.setQuarters(1);

        try {
            Coin coin = service.vendItem();
            assertEquals(expectedCoin1, 0);
            assertEquals(expectedCoin1.toString(), coin.toString(), "same amount of coins");
        } catch (InsufficientFundException e) {
            return;

        }
    }

}
