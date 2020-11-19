/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mr.vendingmachine.controller;

import com.mr.vendingmachine.dto.Coin;
import com.mr.vendingmachine.dto.Item;
import com.mr.vendingmachine.service.InsufficientFundException;
import com.mr.vendingmachine.service.ItemNotFoundException;
import com.mr.vendingmachine.service.ItemOutOfStockException;
import com.mr.vendingmachine.service.VendingMachinePersistenceException;
import com.mr.vendingmachine.service.VendingMachineServiceLayer;
import com.mr.vendingmachine.ui.UserIo;
import com.mr.vendingmachine.ui.UserIoConsoleImpl;
import com.mr.vendingmachine.ui.VendingMachineView;
import java.math.BigDecimal;
import java.util.List;

// 
public class VendingMachineController {

    private VendingMachineServiceLayer service;
    private VendingMachineView view;
   

public VendingMachineController(VendingMachineServiceLayer service, VendingMachineView view) {

        this.service = service;
        this.view = view;
        
    }  

    private UserIo io = new UserIoConsoleImpl();

    public void run() throws VendingMachinePersistenceException, ItemNotFoundException, ItemOutOfStockException, InsufficientFundException {
        boolean keepGoing = true;
        boolean hasFundErrors = true;
        boolean hasItemErrors = true;

        int menuSelection = 0;
        listItems();
        displayStartingBanner();
        menuSelection = getMenuSelection();
        
        switch (menuSelection) {
            case 1:

                try {
                    do {
                        try {

                            if (hasFundErrors) {
                                insertMoney();
                                displayBalance();
                            }
                            if (hasItemErrors) {
                                while (hasItemErrors) {
                                    selectItem();
                                    vendItem();
                                    returnChange();
                                    keepGoing = false;
                                    hasItemErrors = false;
                                }
                            }

                        } catch (InsufficientFundException e) {
                            io.print("Insufficient funds");
                            hasFundErrors = true;
                        } catch (ItemNotFoundException e) {
                            io.print(e.getLocalizedMessage());
                            hasItemErrors = true;
                            hasFundErrors = false;
                            keepGoing = true;
                        } catch (ItemOutOfStockException e) {
                            io.print(e.getLocalizedMessage());
                            hasItemErrors = true;
                            hasFundErrors = false;
                            keepGoing = true;

                        }

                    } while (keepGoing);

                } catch (VendingMachinePersistenceException e) {
                    io.print(e.getLocalizedMessage());

                }
                break;

            case 2:
                shakeMachine();
            case 3:
                view.displayExitBanner();

        }
    }

    private void displayStartingBanner() {
        view.displayStartingBanner();
    }

    private void displayErrorMessage() {
        io.print("====ERROR===");
        view.displayUnknownCommandBanner();
    }

    private int getMenuSelection() {

        return view.printMenuAndGetSelection();
    }

    private void selectItem() throws ItemNotFoundException, VendingMachinePersistenceException {
        String itemCode = view.getItemIdChoice();

        service.selectItem(itemCode);

    }

    private BigDecimal insertMoney() throws ItemNotFoundException, VendingMachinePersistenceException {

        BigDecimal convertedMoney = view.insertMoney();
        service.insertMoney(convertedMoney);
        return convertedMoney;

    }

    private void displayBalance() throws ItemNotFoundException, VendingMachinePersistenceException {
        //BigDecimal is declared
        BigDecimal money = service.insertMoney(new BigDecimal("0"));
        view.currentBalance(money);
    }

    private void shakeMachine() {
        view.displayMachineShakeMessage();

    }

    private void listItems() throws VendingMachinePersistenceException {
        List<Item> itemList = service.getItems();
        view.displayItemList(itemList);
        view.displayBreak();
    }

    private void vendItem() throws ItemOutOfStockException, InsufficientFundException, VendingMachinePersistenceException {
        Coin coin = service.vendItem();
        view.displayVendItem(coin);

    }

    private void returnChange() throws ItemOutOfStockException, InsufficientFundException, VendingMachinePersistenceException {
        service.returnChange(); 

    }

}
