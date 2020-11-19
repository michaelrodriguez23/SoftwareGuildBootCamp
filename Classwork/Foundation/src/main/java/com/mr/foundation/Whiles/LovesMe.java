/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mr.foundation.Whiles;

/**
 *
 * @author michaelrodriguez
 */
public class LovesMe {
    public static void main(String[] args) {
        System.out.println("Well here goes nothing...");
        boolean lovesMe = false; 
        int counter = 1; 
       do{
        System.out.println("It loves me Not!");
           System.out.println("It loves me!");
        counter ++; 
       }
        while(!lovesMe && counter < 17);
        System.out.println("Love is for the weak! I just killed a daisy for nothing");
        System.out.println("     __\n" +
"  __/  \\__\n" +
" /  \\__/  \\\n" +
" \\__/..\\__/\n" +
" /  \\__/  \\\n" +
" \\__/  \\__/\n" +
"    \\__/\n" +
"     ||\n" +
"     ||\n" +
"     ||\n" +
"  .'/.'\\.'.\n" +
"..'.'..'..'.'. ");
}
}
// I chose a do while loop because I wanted the code to at least execute once.
// Regardless of the condition. 