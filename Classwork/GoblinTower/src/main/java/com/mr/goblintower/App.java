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
public class App {

    public static void main(String[] args) {
        View myView = new View();

        Random r = new Random();
        Hero myHero = new Hero();
        boolean keepPlaying = false;

        do {
            myHero.setName(myView.read("What is your name? "));
            myView.print("Your hero name is: " + myHero.getName());
            myView.print(myHero.getCurrentHP() + "/" + myHero.getMaxHP());

            while (myHero.getCurrentHP() > 0) {
                // Play the game
                for (int i = 0; i < 10; i++) {
                    myHero.setSteps(myHero.getSteps() + 1);

                    if (r.nextInt(100) <= myHero.getLevel() + 9) {
                        myView.print("You've encounter a goblin");
                        myHero.setCurrentHP(myHero.getCurrentHP() - 2);
                        if (myHero.getCurrentHP() <= 0) {
                            break;
                        }
                        myHero.setGold(myHero.getGold() + 3);
                    }
                }
                if (myHero.getCurrentHP() > 0 && myHero.getSteps() % 10 == 0) {
                    myView.print("You've cleared " + (myHero.getLevel() - 1));
                }
            }
            myView.print("You have Died!");
            myView.print("You've reached floor " + myHero.getLevel());
            myView.print("You've taken " + myHero.getSteps() + "steps");
            if (myView.read(" Would you like to play again? ").equalsIgnoreCase("Y")) {
                myHero = new Hero(myHero.getPotions(), myHero.getGold());
                keepPlaying = true; 
            } else keepPlaying = false;            

        } while (keepPlaying == true);
    }

}
