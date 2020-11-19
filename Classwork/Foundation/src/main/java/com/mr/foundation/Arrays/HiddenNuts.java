/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mr.foundation.Arrays;

import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author michaelrodriguez
 */
public class HiddenNuts {
    public static void main(String[] args) {
        
        String[] hidingSpots = new String[100]; 
        Random squirrel = new Random(); 
        hidingSpots[squirrel.nextInt(hidingSpots.length)] = "Nut"; 
        System.out.println("The nut has been hidden ... ");
        
        //Nut finding code should go here!
//        System.out.println(Nut);
        
    }
    
}
