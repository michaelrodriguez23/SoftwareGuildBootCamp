/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mr.foundation.Random;
import java.util.Random;
import java.util.Scanner;
/**
 *
 * @author michaelrodriguez
 */
public class GuessMeMore {
    public static void main(String[] args) {
        int min = -100; 
        int max = 100;
        int guess;
        int answer;
        
        Random numberGenerator = new Random();
        Scanner usersGuess = new Scanner(System.in);
        answer = numberGenerator.nextInt(max - min) + min;
        
        
        
        
        
        
        System.out.println("I've chosen a number between -100 and 100. Betcha can't guess it! ");
        guess = usersGuess.nextInt();
        if(guess == answer){
            System.out.println("Wow that was impressive! You got it! ");
        }if(guess > answer)
            System.out.println("Too High, My number was : " + answer );
        if(guess < answer){
            System.out.println("Too low, my number was :" + answer);
        }else{
            System.out.println("You are a failure");
        }
    }
}

