/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mr.foundation.Debugging;

import java.util.Scanner;

/**
 *
 * @author michaelrodriguez
 */
public class WindowMasterDebugging {
    public static void main(String[] args) {
        
        
    // Declare variables for height and width
    float height;
    float width;
    // Declare String variables to hold the user's height and width
    // input
    String stringHeight;
    String stringWidth;

    // Declare other variables
    float areaOfWindow;
    float cost;
    float perimeterOfWindow;

    // Declare and initialize our Scanner
    Scanner sc = new Scanner(System.in);

    // Get input from user
//    System.out.println("Please enter window height:");
//    stringHeight = sc.nextLine();
//    System.out.println("Please enter window width:");
//    stringWidth = sc.nextLine();
//
//    // Convert String values of height and width to floats
//    height = Float.parseFloat(stringHeight);
//    width = Float.parseFloat(stringWidth);
    
    height = readValue("Please enter the window height: "); 
    width = readValue("Please enter the window width: ");

    // Calculate area of window
    areaOfWindow = height * width;

    // Calculate the perimeter of the window
    perimeterOfWindow = 2 * (height + width);

    // Calculate total cost - use hard coded for material cost
    cost = ((3.50f * areaOfWindow) + (2.25f * perimeterOfWindow));

    System.out.println("Window height = " + height);
    System.out.println("Window width = " + width);
    System.out.println("Window area = " + areaOfWindow);
    System.out.println("Window perimeter = " + perimeterOfWindow);
    System.out.println("Total Cost = " + cost);
}
    public static float readValue(String prompt) { 
        Scanner sc = new Scanner(System.in);
        System.out.println(prompt);
        
        String input = sc.nextLine(); 
        float floatVal = Float.parseFloat(input);
        return floatVal;
    }
}
