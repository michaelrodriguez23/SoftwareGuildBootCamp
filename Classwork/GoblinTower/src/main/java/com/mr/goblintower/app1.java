/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mr.goblintower;

import com.mr.goblintower.models.Hero;
import com.mr.goblintower.view.View;
import java.util.Scanner;
import java.util.Random;

/**
 *
 * @author michaelrodriguez
 */
public class app1 {

    public static void main(String[] args) {
        Game myGame = new Game();
        Dice myDice = new Dice();
        View myView = new View();
        myGame.run();
        

        int startingBet;
        int rolls;
        int highestWon;
        int rollsHighestWin;
        int gameMoney;
        int diceOne;
        int diceTwo;
        int sumOfDice;
        
        myView.print("How many dollars do you have to bet? ");
        myView.readInt(message);
    }
}
