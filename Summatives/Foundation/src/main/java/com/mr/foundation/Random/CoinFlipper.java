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
public class CoinFlipper {
    public static void main(String[] args) {
        
        Random coinToss = new Random(); 
        
        Boolean result = coinToss.nextBoolean(); 
        System.out.println("READY, SET, FLIP...!!!");
        
        if(result == false){
            System.out.println("TAILS");
        }else { 
            System.out.println("HEADS");
        }
        
    }
}
