/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mr.foundation.Methods;

/**
 *
 * @author michaelrodriguez
 */

// method is just a named method code, that can be called. 
public class MethodFun {
    public static void main(String[] args) {
        doIt(); 
        doIt();
        doIt();
        
    }
    // for right now were going to use the static keyword.
    // we are calling from our main method which is static 
    // we need to always put a return type
    public static void doIt() {
        System.out.println("Hello");
    }
    
}
// * Remember that printing to the console & returning are two different things
//