/*
Your company has organized a morale event! They're hosting a picnic and field day in the park, and of course, they want to play games! Team games! Team building games!
To do that they want to assign all the people who show up to certain teams based on their last name - they've figured out the distribution break down - all they need YOU to do is to write the program that can sort them! Your program will take a last name as input and output the team name.
Here are the specs:
	•	If a person's name falls before Baggins, then they are on the team "Red Dragons"
	•	If it falls after Baggins, but before Dresden, they are on the team "Dark Wizards"
	•	If it falls after Dresden, but before Howl, they are on the team "Moving Castles"
	•	If it falls after Howl, but before Potter, they are on the team "Golden Snitches"
	•	If it falls after Potter, but before Vimes, they are on the team "Night Guards"
	•	If it falls after Vimes, they are on the team "Black Holes"
 */
package com.mr.foundation.flowcontrol;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author michaelrodriguez
 */
public class fieldDay {
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        
        // Declaring String types and Assigning names 
        String[] usersName; 
        
        String[] lastNames; 
        String[] firstNames;
        
        // Creating String arrays, since arrays are non-primitive
        // Im using the Reserved keyword new to create array objects and dedicating
        // memory space in the program. Inside the index is the amount of slots
        // in the array. 
        
        lastNames = new String[5];
        firstNames = new String[5];
        
        // I am setting values to the String Array lastNames. 
        lastNames[0] = "Baggins"; 
        lastNames[1] = "Dresden";
        lastNames[2] = "Howl";
        lastNames[3] = "Potter"; 
        lastNames[4] = "Vimes";
        
        // This is a shortcut of setting values just like above.
        // But instead we use the curly brackets to create the array. 
        // starting from 0-5 
        String[] teamNames = {"Red Dragons", "Dark Wizards", "Moving Castles", "Golden Snitches", "Night Guards", "Black Holes"};
        
        // User input for name
        
        System.out.println("Whats your last name?");
        String userName = userInput.next(); 
      
        // Testing what the lexicographic value and ordering of the String comparison 
        // between the user input userName and lastNames [0] - "Baggins"
        
        System.out.println(userName.compareToIgnoreCase(lastNames[0]));
        
        // I created a chained nest statements to filter parameters on which code 
        // will execute based on the specs in the exercise.
        // Using the compareTo method to drop down the if statements, determining
        // which code to execute and display team name. 
        
        if(userName.compareToIgnoreCase(lastNames[0])<0 && userName.compareToIgnoreCase(lastNames[1])<0){
            System.out.println("You are on the team " + teamNames[0]);
        }
        if((userName.compareToIgnoreCase(lastNames[1])>0) && userName.compareToIgnoreCase(lastNames[2])<0){
           System.out.println("You are on the team " + teamNames[1]);
        }
        if((userName.compareToIgnoreCase(lastNames[2])>0) && userName.compareToIgnoreCase(lastNames[3])>0){
           System.out.println("You are on the team " + teamNames[2]);
        }
        if((userName.compareToIgnoreCase(lastNames[3])>0) && userName.compareToIgnoreCase(lastNames[4])>0){
           System.out.println("You are on the team " + teamNames[3]);
        }
        if((userName.compareToIgnoreCase(lastNames[4])>0) && userName.compareToIgnoreCase(lastNames[4])>0){
           System.out.println("You are on the team " + teamNames[4]);
        }
        if((userName.compareToIgnoreCase(lastNames[4])>0) && userName.compareToIgnoreCase(lastNames[4])>0){
           System.out.println("You are on the team " + teamNames[4]);
        }
    }
}

        




//        
//        if(userName.compareTo(lastNames[1])){
//        System.out.println(userName);
        
        
        
//        for(int i = 0; i < lastNames.length; i++){
//            System.out.println(lastNames[i]);
//        }
//          for(int i = 0; i < firstNames.length; i++){
//            System.out.println(firstNames[i]);
//        }
//         System.out.println(lastNames[0].compareTo(lastNames[1]));
//         
//         if(lastNames[0].compareTo(lastNames[1])< 0){
//             
       

//        String[] teamNames = {"Red Dragons", "Dark Wizards", "Moving Castles", "Golden Snitches", "Night Guards", "Black Holes"};
//        
//        
//        System.out.println("What's your last name?");
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
//        int length; 
//        
//        System.out.println("What's Your Last Name?");
//        length = userInput.nextInt();
//     
//        String[] names = new String[length]; 
//        
//        for(int counter = 0; counter < length; counter++){
//            System.out.println("enter the name of friend" +(counter+1));
//            names[counter] = input.next()
//        }
//       
//        // Team Names
//        c
//        Arrays.sort(teamNames); 
      
         
//        
//        if(lastName.equalsIgnoreCase("Baggins")){
//            System.out.println("AHa!, You're on the team " + teamNames[1]);
//        }
//         if(lastName.equalsIgnoreCase("Dresden")){
//            System.out.println("AHa!, You're on the team " + teamNames[2]);
//         }
//         if(lastName.equalsIgnoreCase("Howl")){
//            System.out.println("AHa!, You're on the team " + teamNames[3]);
//         }
//         if(lastName.equalsIgnoreCase("Potter")){
//            System.out.println("AHa!, You're on the team " + teamNames[3]);
//         }
//         if(lastName.equalsIgnoreCase("Vimes")){
//            System.out.println("AHa!, You're on the team " + teamNames[4]);
//         }
//         if(lastName.equalsIgnoreCase("Dresden")){
//            System.out.println("AHa!, You're on the team " + teamNames[2]);
//         }
    
