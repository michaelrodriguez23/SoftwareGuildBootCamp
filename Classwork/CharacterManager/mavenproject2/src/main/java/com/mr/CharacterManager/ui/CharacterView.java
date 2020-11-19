/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mr.CharacterManager.ui;

/**
 *
 * @author michaelrodriguez
 */
public class CharacterView {

    private UserIO io;

    public CharacterView(UserIO io) {
        this.io = io;
    }

    public void displayMenu() {
        io.print("Welcome to character Manager .o0o0o0o0");
    }

}
