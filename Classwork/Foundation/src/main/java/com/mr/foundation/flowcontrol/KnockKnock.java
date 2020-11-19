/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mr.foundation.flowcontrol;
import java.util.Scanner;
/**
 *
 * @author michaelrodriguez
 */
public class KnockKnock {
    public static void main(String[] args) {
        Scanner inputReader = new Scanner(System.in);
        
        System.out.println("Knock Knock!  Guess Who!!  ");
        String nameGuess = inputReader.nextLine();
        
        // == Is only used if we are comparing values point to the same memory location
        // .equal() evaluates to the comparison of values in an object.
        // The objects are not the same. Marty McFly & The users input (nameGuess) are in two different locations, therefore we compare the values of the strings using .equals()
        
        // If you dont type the right capitalization Java will return it as false, use .equalsIgnoresCase()
        if(nameGuess.equalsIgnoreCase("Marty McFly")){
            System.out.println("Hey! Thats right! Im back!");
            System.out.println("... From the Future.");
            // Sorry, had to!
        } else{ 
            System.out.println("Dude, do I -look- like " + nameGuess);
        }
    }
    
}
