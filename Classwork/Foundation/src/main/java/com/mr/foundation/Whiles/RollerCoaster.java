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
public class RollerCoaster {
    public static void main(String[] args) {
        
        Scanner userInput = new Scanner(System.in);
        
        System.out.println("We're going to go on a roller coaster...");
        System.out.println("Let me know when you want to get off...");
        
        String keepRiding = "y";
        int loopsLooped = 0;
        while(keepRiding.equals("y")){
            System.out.println("WheeeeeeEEEeeeeee!!!!");
            System.out.println("Want to keep going? (y/n) :");
            keepRiding = userInput.nextLine();
            loopsLooped++;
        }
        System.out.println("Wow, that was Fun!");
        System.out.println("We looped that loop " +loopsLooped + " times!! ");
        }
    }
// If we change the condition to "n" the while code is skipped & drops down
// and executes the print lines on the bottom
// there is not int because its in the same scope, 
// if it was in a different method we will have to reassign and declare the type
