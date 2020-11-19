/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mr.vendingmachine.ui;

import com.mr.vendingmachine.dto.Coin;
import com.mr.vendingmachine.dto.Item;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author michaelrodriguez
 */
public class VendingMachineView {

    private UserIo io;

    public VendingMachineView(UserIo io) {
        this.io = io;
    }

//    UserIo io = new UserIoConsoleImpl();
    public int printMenuAndGetSelection() {
        io.print("1. Put that hard earned money in me ");
        io.print("2. Shake Me Baby");
        io.print("3. Im sort of creeped out, Ill walk away now");

        return io.readInt("Please Select from "
                + "the above choices", 1, 3);
    }

    public String getItemIdChoice() {
        return io.readString("Please enter the Item ID from above.");

    }

    public BigDecimal insertMoney() {
        BigDecimal moneyInserted = io.readBigDecimal("Insert Money");
        return moneyInserted;
    }

    public void displayItemSelectedBanner() {
        io.print("===Item Selected===");
    }

    public void displayItemList(List<Item> itemList) {
        itemList.stream()
                .forEach(s -> System.out.println(s.getId() + " " + s.getName() + " "
                + s.getCost() + " " + s.getQty()));

    }

    public void displayItemSelected(Item item) {
        if (item != null) {
            io.print(item.getId());
            io.print(item.getName());
            io.print(item.getCost().toString());

        } else {
            io.print("No Such Item Exist in this Machine");
        }
        io.readString("Please hit enter to continue");

    }

    public void displayExitBanner() {
        io.print("Thanks For Your Hard Earned Money \n "
                + "PEACE OUT");

    }

    public void displayUnknownCommandBanner() {
        io.print("Unknown Command");
    }

    public void displayMachineShakeMessage() {
        io.print("CAN YOU NOT");
        io.print("IM FRAGILE");
        io.print("Geez louiz");
        io.print("I have a headache");
        io.print("Here is a **** INSERT CODE *** randomly selected item");

    }

    public void displayBreak() {
        io.print("███▒▒▒▒▒▒▒███▒▒▒▒▒▒▒███▒▒▒▒▒▒▒███▒▒▒▒▒▒▒███▒▒▒▒▒▒▒");
    }

    public void displayStartingBanner() {
        io.print("ROT YOUR TEETH AND MIND VENDING ROBOT MACHINE\n"
                + "✿ ✿ ✿ ✿ ✿ ✿ ✿ ✿ ✿ ✿ ✿ ✿ ✿ ✿ ✿ ✿ ✿ ✿ ✿ ✿ ✿  \n"
                + "Please Take a look at our selected goodies" + "\n"
                + "✿ ✿ ✿ ✿ ✿ ✿ ✿ ✿ ✿ ✿ ✿ ✿ ✿ ✿ ✿ ✿ ✿ ✿ ✿ ✿ ✿  ");
    }

    public void displayVendItem(Coin coin) {

        io.print("Change Yielded");
        io.print("Quarters : " + coin.getQuarters());
        io.print("Dime : " + coin.getDimes());
        io.print("Nickels : " + coin.getNickels());
        io.print("Pennies : " + coin.getPennies());

    }

    public void currentBalance(BigDecimal amount) {
        io.print("current balance : " + amount);
    }

    public void displayInsuffificientFund(String msg) {
        io.print("Insert enough money");
    }

}
