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
public class YourLifeInMovies {
    public static void main(String[] args) {
        
        String  name; 
        int year; 
        String answerDisplay;  
        Scanner inputReader = new Scanner(System.in);
      
     
        System.out.println("Hey, Let's play a game! What's your name?");
        name = inputReader.nextLine();
        
        System.out.println(" Hey " + name + " What Year were you born? " );
        year = inputReader.nextInt();   
        
        switch (year) {
            case 1995: case 1996: case 1997: case 1998: case 1999: case 2000: case 2001:
            case 2002: case 2003: case 2004: case 2005: 
                answerDisplay = " Pixar's 'Up' came out half a decade ago.";
                System.out.println(answerDisplay);
//                break;
            case 1985: case 1986: case 1987: case 1988: case 1989: case 1990: case 1991:
            case 1992: case 1993: case 1994: 
                answerDisplay = " The first Harry Potter came out over 15 years ago.";
                System.out.println("answerDisplay");
            case 1975: case 1976: case 1977: case 1978: case 1979: case 1980: case 1981:
            case 1982: case 1983: case 1984: 
                answerDisplay = "Space Jam came out not last decade, but the one before THAT.";
                System.out.println(answerDisplay);
//                break;
            case 1965: case 1966: case 1967: case 1968: case 1969: case 1970: case 1971:
            case 1972: case 1973: case 1974: 
                answerDisplay = "the original Jurassic Park release is closer to the date of the first lunar landing than it is to today.";
                System.out.println(answerDisplay);
//                break; 
            case 1955: case 1956: case 1957: case 1958: case 1959: case 1960: case 1961:
            case 1962: case 1963: case 1964: 
                answerDisplay = " MASH TV series has been around for almost half a century!";
                System.out.println(answerDisplay);
                break; 
            default: 
                answerDisplay = "Invalid day";
                System.out.println(answerDisplay);
                
            
            
            }       
        }
        
        
        
        
    }
    
