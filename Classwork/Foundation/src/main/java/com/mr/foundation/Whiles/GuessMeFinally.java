/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mr.foundation.Whiles;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author michaelrodriguez
 */
public class GuessMeFinally {
     public static void main(String[] args) {
       Scanner usersGuess = new Scanner(System.in);
       Random numberGenerator = new Random();
       
        int min = -100; 
        int max = 100;
        int answer = numberGenerator.nextInt(max - min) + min;
        int guess = 0; 
        
       
        System.out.println("I've chosen a number between -100 and 100. Betcha can't guess it! ");
        
        
        do {
             guess = usersGuess.nextInt();
             System.out.println("Too High, Guess again "  );
        } while(guess > answer); 
        
        do {
            guess = usersGuess.nextInt();
            System.out.println("Too low, Guess again :" );
        } while (guess < answer); 
        
        do {  
            System.out.println("FINALLLLY!!! About time,  You got it! ");
            break;
        } while ( guess == answer);
         
    }
}
    
        
     

//        while(guess > answer) { 
//               System.out.println("Too High, Guess again " + answer );
//               guess = usersGuess.nextInt();
//        
//        while (guess < answer){
//            guess = usersGuess.nextInt();
//            System.out.println("Too low, Guess again :" + answer);
//            
//        while (guess == answer){
//            System.out.println("FINALLLLY!!! About time,  You got it! ");
       


        

     
     