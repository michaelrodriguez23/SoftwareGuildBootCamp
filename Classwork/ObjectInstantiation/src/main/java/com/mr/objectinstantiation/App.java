/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mr.objectinstantiation;

/**
 *
 * @author michaelrodriguez
 */
public class App {

    public static void main(String[] args) {

        int sum = Adder.add(5, 4);

        System.out.println(sum);

        int minusSum = Subtracter.minus(30, 20);
        System.out.println(minusSum);
        
        int multiplierSum = Multiply.multiplier(10, 20);
        System.out.println(multiplierSum);
        
        int divisionSum = Division.divide(20, 3);
        System.out.println(divisionSum);
    }

   

    }

