/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tsg.helloworld;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author michaelrodriguez
 */
import  java.util.Scanner;
public class Hello {
    public static void main(String[] args) {
       System.out.println("Hello, World");
        String name = "Randall"; // alpha-numeric 
        int age = 34; // Whole number
        double weight = 165.1f; // decimals 
        boolean hasHair = false;
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter your name:");
        name = sc.nextLine();
        System.out.println("Please enter your age:");
        age = Integer.parseInt( sc.nextLine());
        System.out.println("Pick your class (Mage, Rogue, Fighter)");
        String playerClass = sc.nextLine();
        if("Goku".equals(name)){
            System.out.println("Wow! It's goku!");
        }
    }
        
        
}


