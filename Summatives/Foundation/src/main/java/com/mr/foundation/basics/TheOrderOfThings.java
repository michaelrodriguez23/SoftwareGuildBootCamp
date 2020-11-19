/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mr.foundation.basics;

/**
 *
 * @author michaelrodriguez
 */
public class TheOrderOfThings {
    public static void main(String[] args) {
        double number; 
        String opinion, size, age, shape, color, origin, material, purpose; 
        String noun; 
        
        number = 5.0;
        opinion = "AWESOME";
        size = "Little-dudes"; 
        age = "new"; 
        shape = "circle"; 
        color = "yellow";
        origin = "New York"; 
        material = "platinum";
        purpose = "fire breathing"; 
        
        noun = "dog"; 
        
        // When you use + with strings, Java concatenates ( e.g., string them together) them instead of adding them. 
        System.out.println(number + " " + opinion + " " + age + " " + size + " " + color + " " + shape + "from " + origin + " " + material + " "
        + " " + purpose + " " + noun);
    }
    
}
