/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mr.foundation.basics;
import java.util.Scanner;

/**
 *
 * @author michaelrodriguez
 */
public class MiniMadLibs {
    public static void main(String[] args) {
        Scanner inputReader = new Scanner(System.in);
        
       //1
        String noun;
        noun = inputReader.nextLine();
        
       //2
        String adjective;
        adjective = inputReader.nextLine();
        
       //3
        String noun2;
        noun2 = inputReader.nextLine();
        
       //4
        double num1;
        num1 = inputReader.nextDouble();
        
       //5
        String adjective2;
        adjective2 = inputReader.nextLine();
        
       //6
        String nounPlural1; 
        nounPlural1 = inputReader.nextLine();
        
       //7
        String nounPlural2;
        nounPlural2 = inputReader.nextLine();
        
       //8
        String nounPlural3;
        nounPlural3 = inputReader.nextLine();
        
       //9 
        String verbInfinitive; 
        verbInfinitive  = inputReader.nextLine();
        
      //10 
        String pastParticipleOfVerb;
        
        pastParticipleOfVerb = inputReader.nextLine();
        
        
        System.out.println("*** LETS PLAY MADLIBS");
        System.out.println("Read & Enjoy...");
        
        System.out.println(noun + " : " + adjective + " frontier. " + " These are the voyages of the starship " + noun2 + "Its " +
                num1 + " -year mission: to explore strange" + adjective2 + nounPlural1 + ", to seek out" + adjective2 + nounPlural2 +
        "and" + adjective2 + nounPlural3 + ", to boldy" + verbInfinitive + "where no one has " + pastParticipleOfVerb + " before." );
        
      
    }
    
}
