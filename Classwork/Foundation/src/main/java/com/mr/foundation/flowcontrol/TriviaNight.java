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
public class TriviaNight {
    public static void main(String[] args) {
        Scanner answerChecker = new Scanner(System.in);
        
        // Users guess input
        int answer;
      
        
        int counter = 0;
        
        // Assigning Strings to each of the questions
        // Question 1 choices
        
        String oneA = "Source Code";
        String oneB = "Assembly Language";
        String oneC = "C#"; 
        String oneD = "Machine Code";
        
        // Question 2 Choices
        
        String twoA = "Grace Hopper";
        String twoB = "Alan Turing";
        String twoC = "Charles Babbage"; 
        String twoD = "Larry Page";
        
        // Question 3 Choices
        
        String threeA = "Serenity";
        String threeB = "The Battlestar Galactica";
        String threeC = "The USS Enterprise"; 
        String threeD = "The Millennium Falcon";
        
        // The Trivia Program
        System.out.println("It's Trivia night");
 
        // Question 1
        System.out.println("First Question!");
        System.out.println("What is the Lowest Level of programming");
        
        //Choices
        System.out.println("1)" + oneA);
        System.out.println("2)" + oneB);
        System.out.println("3)" + oneC);
        System.out.println("4)" + oneD);
        
        // User's answer
        
        System.out.println("Please Enter a numerical value 1-4");
        answer = answerChecker.nextInt(); 
        
        if(4 == answer){
            System.out.println("Your Answer " + answer);
            System.out.println("Woah Sick dude! Thats Correct");
            counter++;
        } else {
            System.out.println("Your Answer " + answer);
            System.out.println("Shucks that was incorrect, the correct answer is " + oneD);
        }
        // Question 2
        System.out.println("Second Question!");
        System.out.println("Website Security CAPTCHA Forms Are Descended From the Work of?");
        
        //Choices
        System.out.println("1)" + twoA);
        System.out.println("2)" + twoB);
        System.out.println("3)" + twoC);
        System.out.println("4)" + twoD);
        // User's answer
        
        System.out.println("Please Enter a numerical value 1-4");
        answer = answerChecker.nextInt(); 
        
        if(2 == answer){
            System.out.println("Your Answer " + answer);
            System.out.println("Woah Sick dude! Thats Correct");
            counter++;
        } else {
            System.out.println("Your Answer " + answer);
            System.out.println("Shucks that was incorrect, the correct answer is " + twoB);
        }
         // Question 3
        System.out.println("Third Question!");
        System.out.println("Which of these Sci-Fi Ships Was Once Slated for a Full-Size Replica in Las Vegas??");
        
        //Choices
        System.out.println("1)" + threeA);
        System.out.println("2)" + threeB);
        System.out.println("3)" + threeC);
        System.out.println("4)" + threeD);
        // User's answer
        
        System.out.println("Please Enter a numerical value 1-4");
        answer = answerChecker.nextInt(); 
        
        if(3 == answer){
            System.out.println("Your Answer " + answer);
            System.out.println("Woah Sick dude! Thats Correct");
            counter++;
        } else {
            System.out.println("Your Answer " + answer);
            System.out.println("Shucks that was incorrect, the correct answer is " + threeC);
        }
        System.out.println("Correct # of Answers:" + counter);
        
    }
    
}
