/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mr.CharacterManager;

import com.mr.CharacterManager.controller.CharacterController;
import com.mr.CharacterManager.ui.CharacterView;
import com.mr.CharacterManager.ui.UserIO;
import com.mr.CharacterManager.ui.UserIOConsoleImpl;
import com.mr.CharacterManager.ui.UserIOITestmpl;

/**
 *
 * @author michaelrodriguez
 */
public class App {

    public static void main(String[] args) {
        UserIO io = new UserIOConsoleImpl();
        CharacterView view = new CharacterView(io);
        CharacterController myController = new CharacterController(view);
        myController.run();
    }
           
}
