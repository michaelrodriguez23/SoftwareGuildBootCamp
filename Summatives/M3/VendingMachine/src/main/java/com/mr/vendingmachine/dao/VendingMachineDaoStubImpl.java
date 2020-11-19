/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mr.vendingmachine.dao;

import com.mr.vendingmachine.dto.Item;
import com.mr.vendingmachine.service.VendingMachinePersistenceException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author michaelrodriguez
 */
// Implements the Dao since it is a stub (Mock Dao) 
public class VendingMachineDaoStubImpl implements VendingMachineDao {

    // Two Global Variables
    Item onlyItem;
    List<Item> itemList = new ArrayList<>();

    // Defualt Constructor * No Parameters
    public VendingMachineDaoStubImpl() {
        onlyItem = new Item("C1");
        onlyItem.setId("C1");
        onlyItem.setName("Sharpie");
        onlyItem.setCost(new BigDecimal("1.00"));
        onlyItem.setQty(10);

        itemList.add(onlyItem);

        Item onlyItem2 = new Item("D1");
        onlyItem2.setId("D1");
        onlyItem2.setName("Mints");
        onlyItem2.setCost(new BigDecimal("1.00"));
        onlyItem2.setQty(0);

        itemList.add(onlyItem2);

        Item onlyItem3 = new Item("A3");
        onlyItem3.setId("A3");
        onlyItem3.setName("ChapStick");
        onlyItem3.setCost(new BigDecimal("1.00"));
        onlyItem3.setQty(100);

        itemList.add(onlyItem3);

    }

    @Override
    public Item getItem(String id) throws VendingMachinePersistenceException {
        // If the Id is equal to the item object we can return the item object, if not return null 
        // We are re-creating how these methods works
        if (id.equals(onlyItem.getId())) {
            return onlyItem;
        } else {
            return null;
        }

    }

    @Override
    public List<Item> getAllItems() throws VendingMachinePersistenceException {
        return (List<Item>) itemList;

    }

    @Override
    public Item editItem(String id, Item item) throws VendingMachinePersistenceException {
    
        // The editItem() Method has the same behavior has getItem(), if the Id is equal to to the object Id return the onlyItem
        // Otherwise return null 
        if (id.equals(onlyItem.getId())) {
            return onlyItem;
        } else {
            return null;
        }
    }

}
