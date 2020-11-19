/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mr.foundation.flowcontrol;

/**
 *
 * @author michaelrodriguez
 */
public class SpaceRustlers {
    public static void main(String[] args) {
        
        int spaceships = 10; 
        int aliens = 25; 
        int cows = 100; 
        
        // checking if there are more aliens than spaceships. If true the following block will print. 
        
        if(aliens> spaceships) { 
            System.out.println("Vroom, vroom! Let's get going!");
            
        // if the condition is not true, then the else block will print
        
        } else { 
            System.out.println("There aren't enough green guys to drive these ships!");
        }   
        
        // if there are an equal amount of cows & spaceships. It will print the following block.
        
        if (cows == spaceships){ 
            System.out.println("Wow, way to plan ahead! Just enough room for all these hamburgers!");
        
        // if the condition above is false, it will check the condition below, if true it will print the following block. 
        
        } else if( cows > spaceships) {
            System.out.println("Dangit! I don't how we're going to fit all these cows in here!");
        // if everything above proves false, it will default to the else statement, and print the following block. 
        
        } else  { 
            System.out.println("Too many ships! Not enough cows.");
        }
        if ( aliens > cows ){
            System.out.println("Hurrah, we've got the grub! Hamburger party on Alpha Centauri"); 
        }
        else if(cows >= aliens){
            System.out.println("Oh no! The herds got restless and took over! Looks like _we're_ hamburger now!!");
        }
    }
    
}
	// if you remove the else, from the else if, there will be no default code to execute.