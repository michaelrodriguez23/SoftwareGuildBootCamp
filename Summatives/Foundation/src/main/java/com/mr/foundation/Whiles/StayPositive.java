/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mr.foundation.Whiles;
import java.util.Scanner; 
/**
 *
 * @author michaelrodriguez
 */
public class StayPositive {
    public static void main(String[] args) {
       
        Scanner userInput = new Scanner(System.in); 
        System.out.println("What number should I count down from? ");
        int userNumber = userInput.nextInt(); 
        int counter = 0; 
        while(userNumber>0){
            userNumber--;
            System.out.print(userNumber + ", ");
        
        }
    }  
    }


