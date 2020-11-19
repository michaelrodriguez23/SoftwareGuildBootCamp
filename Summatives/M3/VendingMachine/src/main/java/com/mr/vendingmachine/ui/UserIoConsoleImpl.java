/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mr.vendingmachine.ui;

import java.math.BigDecimal;
import java.util.Scanner;

/**
 *
 * @author michaelrodriguez
 */
public class UserIoConsoleImpl implements UserIo {

    Scanner sc = new Scanner(System.in);

    @Override
    public void print(String msg) {
        System.out.println(msg);
    }

    @Override
    public double readDouble(String prompt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public double readDouble(String prompt, double min, double max) {
        print(prompt);
        String userInput = sc.nextLine();
        return Double.parseDouble(userInput);
    }

    @Override
    public float readFloat(String prompt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public float readFloat(String prompt, float min, float max) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int readInt(String prompt) {
        print(prompt);
        String userInput = sc.nextLine();
        return Integer.parseInt(userInput);
    }

    @Override
    public int readInt(String prompt, int min, int max) {
        int answer = readInt(prompt);
        while (answer < min || answer > max) {
            print("Invalid Number");
            answer = readInt(prompt);

        }
        return answer;
    }

    @Override
    public long readLong(String prompt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public long readLong(String prompt, long min, long max) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String readString(String prompt) {
        print(prompt);
        String userInput = sc.nextLine();
        return (userInput);

    }
    public BigDecimal readBigDecimal(String prompt) { 
    print(prompt);
    String userInput = sc.nextLine();
    BigDecimal conversion = new BigDecimal(userInput);
    
    return conversion;
}
}
