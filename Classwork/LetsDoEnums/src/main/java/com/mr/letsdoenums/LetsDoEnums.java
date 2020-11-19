/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mr.letsdoenums;

/**
 *
 * @author michaelrodriguez
 */
//Enums dont have types , they are just labels
// Is good practice to make them uppercase, to easily
// differ from the rest of the code. 

// Enums are cleaner and easier. compared to an array. 

enum  Level {
    LOW, MEDIUM, HIGH
}
public class LetsDoEnums {
    // An Enum can be put inside of a class, or outside of a class. 
    // We use the word static in string so we dont have to create
    // an objet to access it. 
    
   
    
//    static String[] levels = {"Low", "Medium", "High"}; 
    public static void main(String[] args) {
        Level l = Level.LOW; 
        Level m = Level.MEDIUM; 
        Level h = Level.HIGH;
        
        
        System.out.println(Level.HIGH);
        
        switch(l){
            case LOW: 
                System.out.println("Low Level");
                break; 
            case MEDIUM: 
                System.out.println("Medium Level");
            case HIGH: 
                System.out.println("High Level");
                break; 
           default : 
               System.out.println("Invalid Input");
               break; 
                
        }
        
//        System.out.println(levels[0]);
//        System.out.println(levels[1]);
//        System.out.println(levels[2]);
//        
    }
}
