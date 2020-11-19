/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mr.foundation.Random;
import java.util.Random;
/**
 *
 * @author michaelrodriguez
 */
public class HighRoller {
    public static void main(String[] args) {
        Random diceRoller = new Random(); 
        
        int rollResult = diceRoller.nextInt(6) + 1; 
        
        System.out.println("TIME TO ROOOOOOL THE DICE!");
        System.out.println("I rolled a " + rollResult);
        
        if(rollResult == 1){
            System.out.println("You rolled a critical failure");
        }
    }
}
