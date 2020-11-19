/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mr.vendingmachine.service;

import com.mr.vendingmachine.dto.Coin;
import com.mr.vendingmachine.dto.Item;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author michaelrodriguez
 */
public interface VendingMachineServiceLayer {

    List<Item> getItems() throws VendingMachinePersistenceException;

    BigDecimal insertMoney(BigDecimal money);

    void selectItem(String itemCode) throws ItemNotFoundException, VendingMachinePersistenceException;

    Coin vendItem() throws ItemOutOfStockException, InsufficientFundException, VendingMachinePersistenceException;

    Coin returnChange();
}
