/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mr.vendingmachine.dao;

import com.mr.vendingmachine.dto.Item;
import com.mr.vendingmachine.service.VendingMachinePersistenceException;
import java.util.List;

/**
 *
 * @author michaelrodriguez
 */
public interface VendingMachineDao {

    Item getItem(String id) throws VendingMachinePersistenceException;

    List<Item> getAllItems() throws VendingMachinePersistenceException;

    Item editItem(String id, Item item) throws VendingMachinePersistenceException;

   

  

}
