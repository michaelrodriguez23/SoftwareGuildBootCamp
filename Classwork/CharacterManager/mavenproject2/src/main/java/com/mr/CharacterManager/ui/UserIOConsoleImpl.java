/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mr.CharacterManager.ui;

import java.util.Scanner;

/**
 *
 * @author michaelrodriguez
 */
public class UserIOConsoleImpl implements UserIO       {
    

    @Override
    public void print(String message) {
        System.out.println(message);
    }

    @Override
    public String read(String message) {
        System.out.println(message);
        Scanner sc = new Scanner(System.in);
        String UserInput = sc.nextLine(); 
        return UserInput; 
    }
    public void hey(){
        
    }
}
