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
public class BirthStones {
    public static void main(String[] args) {
        int number = 0; 
        String invalid = "Dude WTH?! Enter a number between 1-12.\\n Silly Goose"; 
        Scanner monthScanner = new Scanner(System.in);
        
        
        System.out.println("What's your birth month in numerical value 1-12");
        number = monthScanner.nextInt();
        
        if(1 == number){
            System.out.println("Your birth month is January, and your stone is Garnet");
        }if(2 == number){
            System.out.println("Your birth month is February, and your stone is Amethyst");
        }if(3 == number){
            System.out.println("Your birth month is March, and your stone is Aquamarine");
        }if(4 == number){
            System.out.println("Your birth month is April, and your stone is Diamond");
        }if(5 == number){
            System.out.println("Your birth month is May, and your stone is Emerald");
        }if(6 == number){
            System.out.println("Your birth month is June, and your stone is Pearl");
        }if(7 == number){
            System.out.println("Your birth month is July, and your stone is Ruby");
        }if(8 == number){
            System.out.println("Your birth month is August, and your stone is Peridot");
        }if(9 == number){
            System.out.println("Your birth month is September, and your stone is Saphire");
        }if(10 == number){
            System.out.println("Your birth 13month is October, and your stone is Opal");
        }if(11 == number){
            System.out.println("Your birth month is November, and your stone is Topaz"); 
        }if(12 == number){
            System.out.println("Your birth month is December, and your stone is Turqouise");    
        }else {
            System.out.println(invalid);
        }    
    }
}
        