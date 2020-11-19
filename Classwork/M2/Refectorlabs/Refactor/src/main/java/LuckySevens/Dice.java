/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LuckySevens;

import java.util.Random;

/**
 *
 * @author michaelrodriguez
 */
public class Dice {

    private int roll1;
    private int roll2;
    private int sum;
    Random rng = new Random();

    public int diceRoll() {
        
        roll1 = rng.nextInt(6 - 1) + 1;
        roll2 = rng.nextInt(6 - 1) + 1;
        sum = roll1 + roll2;
        return sum;
    }

}
