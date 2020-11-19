/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mr.goblintower;

import java.util.Random;

/**
 *
 * @author michaelrodriguez
 */
public class Dice {
     private static  Random DICEROLL = new Random();
     
     int diceOne; 
     int diceTwo; 
     int diceRollSum; 

    public int getDiceOne() {
        this.diceOne = DICEROLL.nextInt(0 - 5) + 1;
        return diceOne;
    }

    public void setDiceOne(int diceOne) {
        this.diceOne = diceOne;
    }

    public int getDiceTwo() {
        this.diceTwo = DICEROLL.nextInt(0-5)+1;
        return diceTwo;
    }

    public void setDiceTwo(int DiceTwo) {
        this.diceTwo = diceTwo;
    }

    public int getDiceRollSum() {
        diceRollSum = diceOne + diceTwo;
        return diceRollSum;
    }

    public void setDiceRollSum(int DiceRollSum) {
        this.diceRollSum = DiceRollSum;
    }
     
    
}
