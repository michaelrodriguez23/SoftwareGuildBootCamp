/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mr.letsdoenums;

/**
 *
 * @author michaelrodriguez
 */
public class EnumPlay {
    enum Flavor {
        CHOCOLATE, VANILLA, STRAWBERRY;  
        
        // You Can have Methods in an enum. 
        public static void getVanilla(){
            System.out.println(Flavor.VANILLA);
          
            
        }
        
    }
    public static void main(String[] args) {
        Flavor flav = Flavor.STRAWBERRY; 
        
        if(flav == Flavor.CHOCOLATE){
            System.out.println("It's Chocolate");
        }else if(flav == flav.VANILLA){
            System.out.println("It's Vanilla");
        }else if(flav == Flavor.STRAWBERRY) {
            System.out.println("It's Strawberry");
        }
     Flavor.getVanilla();
     
    }
    
}
