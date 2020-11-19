/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mr.simplecalculator;

/**
 *
 * @author michaelrodriguez
 */
public class Calculator {
    
    /**
     *  Hey Future Developers this method allows you to add two integers & returns sum
     * @param a this is the first operator
     * @param b this is the second operator
     * @return returns sum of a + b 
     */
    
    public int add(int a, int b){ 
        return a + b;
    }
    /**
     * This method allows you to subtract int a from int b
     * @param a first operator
     * @param b second operator
     * @return returns the remainder of a & b . 
     */
    public int minus(int a , int b) {
        return a - b; 
    }
    /**
     *  This will divide a & b into whole numbers remainder
     * @param a the number your dividing 
     * @param b the dividing number 
     * @return returns the whole remainder of a divided by b . 
     */
    public int div(int a , int b) { 
        return a / b; 
    }
    /**
     * This finds the total whole of a + b. 
     * @param a a is the number multiplying with 
     * @param b is the other number being multiplied
     * @return returns the product of the two int
     */
    public int product(int a, int b) { 
        return a * b; 
    }
}
