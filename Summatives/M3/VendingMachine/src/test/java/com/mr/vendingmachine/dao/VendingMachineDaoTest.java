/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mr.vendingmachine.dao;

import com.mr.vendingmachine.dto.Item;
import com.mr.vendingmachine.service.VendingMachinePersistenceException;
import java.math.BigDecimal;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author michaelrodriguez
 */
public class VendingMachineDaoTest {
// This gives us a handle to our dao, to be used for our test
    
    private VendingMachineDao dao = new VendingMachineDaoFileImpl();

    public VendingMachineDaoTest() {
    }

    @BeforeAll
    public static void setUpClass() {
    }

    @AfterAll
    public static void tearDownClass() {
    } 
// The Setup method is going to start b4 each of the test. 
    // Lets set it up to be in a good state 
    @BeforeEach
    public void setUp() throws Exception {
            
            
            
        
    }

    @AfterEach
    public void tearDown() throws VendingMachinePersistenceException {


    }

    @Test
    public void testGetItem() throws VendingMachinePersistenceException {
        Item itemFromDao = dao.getItem("A1");
 
        assertEquals(itemFromDao, dao.getItem("A1"));
        
     
    }

    @Test
    public void testGetAllItems() throws VendingMachinePersistenceException, Exception {
        
        
        Item item1 = new Item("B10");
        item1.setId("B1");
        item1.setName("Snapple");
        item1.setCost(new BigDecimal("1.00"));
        item1.setQty(10);

        dao.editItem(item1.getId(), item1);

        Item item2 = new Item("B11");
        item2.setId("B11");
        item2.setName("Doritos");
        item2.setCost(new BigDecimal("1.25"));
        item2.setQty(1);

        dao.editItem(item2.getId(), item2);
        
  

        assertEquals(11, dao.getAllItems().size());
        
       

    }

    @Test
    public void editItem() throws VendingMachinePersistenceException {
        Item item1 = new Item("B11");
        item1.setId("B11");
        item1.setName("Doritos");
        item1.setCost(new BigDecimal("1.25"));
        item1.setQty(2);
        
        dao.editItem(item1.getId(), item1); 
        
        Item ItemFromDao = dao.getItem("B11");
        
        assertEquals(ItemFromDao, item1, "Should be the same Item, It was overided");
  
        
        
        


    }

}
