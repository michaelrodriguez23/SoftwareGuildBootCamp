/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mr.simplecalculator;

import java.util.Scanner;

/**
 *
 * @author michaelrodriguez
 */
public class View {
    
    private Scanner sc = new Scanner(System.in); 
    
    /**
     * this method takes in a string message & prints to the screen
     * @param message this is the output to the screen
     */
    public void print(String message){ 
        System.out.println(message);
    }
    /**
     * this method takes in message & returns user input. 
     * @param output to the the screen
     * @return user input 
     */
    public String read(String message){
        print(message);
        return sc.nextLine();
    }
    /**
     * This method prompts user for an integer. 
     * @param this is the out put to the screen. 
     * @return 
     */
    public int readInt(String message){
        String userInput = read(message);
        int result = Integer.parseInt(userInput);
        return result; 
        
    }
}
