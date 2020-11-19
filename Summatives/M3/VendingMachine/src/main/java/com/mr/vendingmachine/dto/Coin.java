/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mr.vendingmachine.dto;

/**
 *
 * @author michaelrodriguez
 */
public class Coin {

    private int moneyInsterted = 0; 
    private int change = 0;
    private int quarters = 0;
    private int dimes = 0;
    private int nickels = 0;
    private int pennies = 0;

    public int getMoneyInsterted() {
        return moneyInsterted;
    }

    public void setMoneyInsterted(int moneyInsterted) {
        this.moneyInsterted = moneyInsterted;
    }

    public int getChange() {
        return change;
    }

    public void setChange(int change) {
        this.change = change;
    }

    public int getQuarters() {
        return quarters;
    }

    public void setQuarters(int quarters) {
        this.quarters = quarters;
    }

    public int getDimes() {
        return dimes;
    }

    public void setDimes(int dimes) {
        this.dimes = dimes;
    }

    public int getNickels() {
        return nickels;
    }

    public void setNickels(int nickels) {
        this.nickels = nickels;
    }

    public int getPennies() {
        return pennies;
    }

    public void setPennies(int pennies) {
        this.pennies = pennies;
    }

  

}
