/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mr.foundation.Whiles;
import java.util.Scanner;

/**
 *
 * @author michaelrodriguez
 */
public class DoOrDoNot {
    public static void main(String[] args) {
        
    Scanner input = new Scanner(System.in);
        System.out.println("Should I do it? (y/n) ");
        boolean doIt;
  // if y is pressed the doIt boolean value will be true
  // if n is pressed the doIt boolean value will be false
  
    if (input.next().equals("y")){
        doIt = true; // DO IT!!
    }else { 
        doIt = false; //DONT YOU DARE!
    }
    // initializing the iDidIt to be a boolean type & false.
    boolean iDidIt = false;
    
    // execute iDidit to be true only while  doIt is true/ equal to "y" 
//    while(doIt){
//        iDidIt = true;
//        break;
//    }
//    
    do { 
        iDidIt = true; 
        break; 
    } while (doIt); 
  
    // if doIt and iDidIt are both true 
    // print "I did that"
    if (doIt && iDidIt){ 
        System.out.println("I did it!");
    // if the the conditional above is false. 
    // check if !doIt = false  it negates the doIt 
    // check if iDidIt = true
    // execute code if both statements are true
    } else if (!doIt && iDidIt) { 
        System.out.println("I Know you said not to ... but I totally did anyways.");
    // if none of the conditions above are true, execute the else code.
    } else { 
        System.out.println("Don't look at me, I didnt do anything!");
    }
}
    
}
// when I changed to do/while loop and just wrote a while loop for the same condition , 
// the code executes that same with the do/while. It says "I did it"
// but when i said not to, it executed the else code. Printing "Don't look at me" 
// It is because the do loop will execute at least once compared to while loop will
// only execute the condition if its met. 