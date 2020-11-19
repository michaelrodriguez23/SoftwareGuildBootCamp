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
public class app {

    public static void main(String[] args) {
        Calculator myCalc = new Calculator();
        System.out.println(myCalc.add(5, 5));

        System.out.println(myCalc.minus(10, 5));
        System.out.println(myCalc.div(10, 2));
        System.out.println(myCalc.product(10, 2));
        View myView = new View();

        int a;
        int b;
        boolean keepRunning = true;

        while (keepRunning) {
            String userInput = myView.read("1.add\n2.subtract\n3.divide\n4.multiply\n5.exit ");
            switch (userInput) {
                case "1":

                    a = myView.readInt("Enter a number");
                    b = myView.readInt("Enter another number");
                    int sum = myCalc.add(a, b);
                    myView.print("result: " + sum);
                    break;

                case "2":
                    a = myView.readInt("Enter a number");
                    b = myView.readInt("Enter another number");
                    int remainder = myCalc.minus(a, b);
                    myView.print("result: " + remainder);
                    break;
                case "3":
                    a = myView.readInt("Enter a number");
                    b = myView.readInt("Enter another number");
                    int result = myCalc.div(a, b);
                    myView.print("result: " + result);
                    break;
                case "4":
                    a = myView.readInt("Enter a number");
                    b = myView.readInt("Enter another number");
                    int product = myCalc.product(a, b);
                    myView.print("result: " + product);
                    break;
                case "5":
                    myView.print("THANK YOU SOOOOOOOo0oo0o0o0o MUCH! <3");
                    keepRunning = false;
                    break;
                default:
                    myView.print("Unsupported Operation . </3");
                    break;
            }
        }
    }

}
