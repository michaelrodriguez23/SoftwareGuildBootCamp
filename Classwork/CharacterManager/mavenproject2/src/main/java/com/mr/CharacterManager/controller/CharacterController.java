/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mr.CharacterManager.controller;

import com.mr.CharacterManager.ui.CharacterView;

/**
 *
 * @author michaelrodriguez
 */
public class CharacterController {

    private CharacterView view;

    public CharacterController(CharacterView view) {
        this.view = view;
    }

    public void run() {
        view.displayMenu();
        
    }
}
