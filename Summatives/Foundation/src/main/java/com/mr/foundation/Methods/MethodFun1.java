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
public class MethodFun1 {
    public static void main(String[] args) {
        int operand1 = 3; 
        int operand2 = 7; 
        
        int sum = add(32, 45); 
        System.out.println(sum);
        
        sum = add(operand1, operand2);
        System.out.println(sum);
        
        System.out.println(add(3, 4));
        
     
        
    }
    
    public static int add(int a, int b){
        return a + b; 
    }
}

