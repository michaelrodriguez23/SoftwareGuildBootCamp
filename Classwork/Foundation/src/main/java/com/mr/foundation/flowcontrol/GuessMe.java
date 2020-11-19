/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mr.foundation.flowcontrol;

import java.util.Random;
import java.util.Scanner;


/**
 *
 * @author michaelrodriguez
 */
public class GuessMe {
    public static void main(String[] args) {
    Scanner inputReader = new Scanner(System.in);
       
    int answer = 22;
    int guess;  
    
    Scanner guessReader = new Scanner(System.in);
    
        System.out.println("Welcome To The number Guessing game");
        System.out.println("I've Chosen a number. Betcha can't guess it!");
        
        // Reading users guess input
        guess = guessReader.nextInt();
        
        //Printing Guess
        System.out.println(guess + " is your guess");
       
        
    if (guess == answer){
        System.out.println("Wow are you reading my mind? That was correct");
    }
    if(guess > answer){
        System.out.println("Ha, nice try - too low! I chose " + answer ); 
    }
    if(guess < answer){
        System.out.println("Ha, nice try - too high! I chose " + answer ); 
    }
  }   
}

    