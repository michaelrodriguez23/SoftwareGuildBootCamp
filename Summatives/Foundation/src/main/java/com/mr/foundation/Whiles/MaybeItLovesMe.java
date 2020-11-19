/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mr.foundation.Whiles;
import java.util.Random; 
/**
 *
 * @author michaelrodriguez
 */
public class MaybeItLovesMe {
    public static void main(String[] args) {
         Random petalGenerator = new Random();
         
         System.out.println("Well here goes nothing...");
         
        boolean lovesMe; 
        int counter = 0; 
        int petalNumber; 
        int max = 89;
        int min = 13;
        boolean isEven = true; 
        boolean isFalse = true; 
        
        
        petalNumber = petalGenerator.nextInt(max - min) + min;
    
         do{
        --petalNumber; 
        } while (petalNumber > 0); 
        
        
           while(petalNumber > 0 && isEven){
             petalNumber --; 
             isEven =!isEven;
             System.out.println("It loves me! "); 
             System.out.println(petalNumber);
            
             
         } while(petalNumber > 0 && !isEven){
            System.out.println("It loves me Not!");
            petalNumber --; 
             isEven = isEven;
         } while(petalNumber == 0 && isEven){ 
             System.out.println("yay, I think it really does love me, at least something does");
             break;
         } while(petalNumber == 0 && !isEven){ 
             System.out.println("Damn, this is a cold world, nothing loves me");
             break; 
         }
         System.out.println("Love is for the weak! I just killed a daisy for nothg");
         System.out.println("The number of petals :" + petalNumber);
         
//       do{  
//        System.out.println("It loves me Not!");
//        System.out.println("It loves me!");
//        counter ++; 
//       }
//        while(petalNumber%2 == 0 && counter < petalNumber);
//        System.out.println("Love is for the weak! I just killed a daisy for nothing");
//         System.out.println("The number of petals :" + petalNumber);
    }
}
