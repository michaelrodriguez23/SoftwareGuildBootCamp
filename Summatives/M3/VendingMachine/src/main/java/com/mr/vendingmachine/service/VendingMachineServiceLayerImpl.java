/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mr.vendingmachine.service;

import com.mr.vendingmachine.dao.VendingMachineAuditDao;
import com.mr.vendingmachine.dao.VendingMachineDao;
import com.mr.vendingmachine.dto.Coin;
import com.mr.vendingmachine.dto.Item;
import java.math.BigDecimal;
import java.util.List;

public class VendingMachineServiceLayerImpl
        implements VendingMachineServiceLayer {

    // Global Variables
    // Instantiated & Assigned Variables
    private BigDecimal amount = new BigDecimal("0");
    BigDecimal change = new BigDecimal("0");
    BigDecimal quarter = new BigDecimal("25");
    BigDecimal dime = new BigDecimal("10");
    BigDecimal nickle = new BigDecimal("5");
    BigDecimal penny = new BigDecimal("1");
    BigDecimal hundred = new BigDecimal("100");
    
    // Instantiated Coin Object 
    Coin coin = new Coin();
    
    // Instantiated String
    String selectedItem;
    
    // Instantiated Dao
    VendingMachineDao dao;
    
    // Instantiated AuditDao
    private VendingMachineAuditDao auditDao;

 
    
    // 
    
// Created a constructor from the same class
// To be able to add dependency injection 
// For the Dao, and auditDao
    public VendingMachineServiceLayerImpl(VendingMachineDao Dao,
            VendingMachineAuditDao auditDao) {
        this.dao = Dao;
        this.auditDao = auditDao;

    }
// Interface Methods

    VendingMachineServiceLayerImpl(VendingMachineDao dao) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    // Communicating to the dao to retrieve all the Items in the HashMap List
    
    @Override
    public List<Item> getItems() throws VendingMachinePersistenceException {
        return dao.getAllItems();
    }
    
    
    // This Service Layer method is communicating to the controller, 
    // Which is then communicating to the view, which relays it back through
    // from the controller, and finally back here inside the insertMoney Constructor
    // as "convertedMoney"
    // then BigDecimal "amount" that has been added by the user
    // is asigned to the "amount" in the global variable by using the return statement. 
    
    @Override
    public BigDecimal insertMoney(BigDecimal convertedMoney) {
        amount = amount.add(convertedMoney);
        return amount;
    }
     // selectItem is is communicating to the controller to then acess the 
    // view to retrieve the user itemCode which was inputted. 
    // A new Item object is instantiated, and is communicating to the 
    // dao to retrieve the item by using getItem() method, and passing in
    // the itemCode inputted by the user 
    

    
    // Logic 
    // if Item is null, throw ItemNotFoundException
    //  if all is fine -> else -> safely assign the itemCode to the selectedItem
    // global variable
    @Override
    public void selectItem(String itemCode) throws ItemNotFoundException, VendingMachinePersistenceException {

        Item item = dao.getItem(itemCode);
       
        if (item == null) {

            throw new ItemNotFoundException("Item not found");
        } else {
            selectedItem = itemCode;
            
            

        }
    }
    // A new item object is instantiated locally. 
    // passing through the verified itemcode aka selectedItem allows us
    // to retrieve that item stored in the Dao
    
    // Logic : 
    // If item qty is less than or equal to 0 : Throw OutOfStockException
    // If the selected item's cost compared to the amount in the balance is greater
    // throw an InsufficientFundException
    // If everything is fine -> else -> 
    // remove one Qty from the stock, and update the inventory
    // Then accesing the dao to edit the item by its id 
    // The new balance "amount" is modified, by subtracting the items cost
    // Change is returned 
    // and the vend item is logged + which is appending. 
    @Override
    public Coin vendItem() throws ItemOutOfStockException,
            InsufficientFundException, VendingMachinePersistenceException  {

        Item item = dao.getItem(selectedItem);

        if (item.getQty() <= 0) {
            throw new ItemOutOfStockException("Item Out Of Stock");
        }

        if (item.getCost().compareTo(amount) == 1) {
            throw new InsufficientFundException("not enough money");

        } else {
            int updatedInventory = item.getQty() - 1;
            item.setQty(updatedInventory);
            dao.editItem(item.getId(), item);
            amount = amount.subtract(item.getCost());
            returnChange();
            auditDao.writeAuditEntry(" Item " + selectedItem + " VENDED.");

        }

        return coin;
    }

// This is where the logic lives to return change to the user. 
// 1st created a pennies int variable, then multiplied the balance "amount" 
// by 100, and converting it to an int
// to get a value thats easier to work with. Simplifying the amount into pennies

// Logic 
    // if amount of pennies is greater than or = to 25
    // Go to coin object -> and setQuarters to the amountof times 
    // change is divisible by 25. 
    // We need to have a remainder that can be accessed to continue
    // the sequence of logic to give approite amount of chage. 
    // We instantiated a int variable amountOfChange to equal the amount 
    // of quarters multiplied by 25 to get back an amount that do further
    // math operations with pennies. 
    // the new amount given to pennies = pennies minus the amountOfChange dispensed. 
    
    // The logic continues down to then dimes, nickels, and pennies. 
    // All coins are returned to the Coin DTO. 
    
    @Override
    public Coin returnChange() {

        int pennies = amount.multiply(hundred).intValue();

        if (pennies >= 25) {
            coin.setQuarters(pennies / 25);
            int amountOfChange = coin.getQuarters() * 25;
            pennies = pennies - (amountOfChange);

        }

        if (pennies >= 10) {
            coin.setDimes(pennies / 10);
            int amountOfChange = coin.getDimes() * 10;
            pennies = pennies - (amountOfChange);
        }
        if (pennies >= 5) {
            coin.setNickels(pennies / 5);
            int amountOfChange = coin.getNickels() * 5;
            pennies = pennies - (amountOfChange);

        }
        if (pennies >= 1) {
            coin.setPennies(pennies / 1);
            int amountOfChange = coin.getPennies() * 1;
            pennies = amountOfChange;

        }
        return coin;

    }
}
