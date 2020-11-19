/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tsg.helloworld;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author michaelrodriguez
 */
public class LuckySeven {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        do {            
            int roll1 = 0;
            int roll2 = 0;
            int sum = 0;
            int startingBet = 0;
            int remainingBet = 0;
            int totalRolls = 0;
            int highestEarned = 0;
            Random rng = new Random();
            
            System.out.println("Enter Starting Bet:");
            startingBet = Integer.parseInt(sc.nextLine());
            highestEarned = startingBet;
            remainingBet = startingBet;
            
            while (remainingBet > 0) {
                roll1 = rng.nextInt(6 - 1) + 1;
                roll2 = rng.nextInt(6 - 1) + 1;
                sum = roll1 + roll2;
                totalRolls++;
                if (sum == 7) {
                    if (remainingBet > highestEarned) {
                        remainingBet+=10;
                        highestEarned = remainingBet;
                    }
                } else {
                    //remainingBet= remainingBet- 4;
                    remainingBet -= 4;
                }
            }
            System.out.println("Starting Bet:" + startingBet);
            System.out.println("Highest Earned:" + highestEarned);
            System.out.println("Total Rolled:" + totalRolls);
            System.out.println("Do You want to play Again");
        } while("Y".equals(sc.nextLine()));
    }
    
}
     
