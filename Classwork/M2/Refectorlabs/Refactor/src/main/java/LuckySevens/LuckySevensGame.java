/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LuckySevens;

import java.util.Random;
import java.util.Scanner;



/**
 *
 * @author michaelrodriguez
 */
public class LuckySevensGame {

    public static void run() {
        Scanner sc = new Scanner(System.in);
        View view = new View();
        Random rng = new Random();
        Dice diceRoll = new Dice();
        Player player = new Player();
        do {

            int roll1 = 0;
            int roll2 = 0;
            int sum = 0;

             player.SetRemainingBet(2);
//              System.out.println(player.getRemaingBet());
//            int remainingBet = player.GetRemaingBet();
//            int totalRolls = player.GetTotalRolls();
//            int highestEarned = player.GetHighestEarned();
            
            System.out.println(player.GetRemaingBet() + "Test for remaining bet");
            System.out.println(player.GetStartingBet() + " test");

//            player.SetStartingBet();= view.readInt("What is your starting bet?");
//            player.GetHighestEarned() = player.SetStartingBet();
//            player.GetStartingBet() = startingBet;
//
//            System.out.println(player.GetRemaingBet() + "Test for remaining bet");
//            while (remainingBet > 0) {
//                sum = diceRoll.diceRoll();
//                totalRolls++;
//
//                if (sum == 7) {
//                    if (remainingBet > highestEarned) {
//                        remainingBet += 10;
//                        highestEarned = remainingBet;
//                    }
//                } else {
//
//                    remainingBet -= 4;
//                }
//            }
//            view.print("Starting Bet:" + startingBet);
//            view.print("Highest Earned:" + highestEarned);
//            view.print("Total Rolled:" + totalRolls);
//            view.print("Do You want to play Again");
        } while ("Y".equals(sc.nextLine()));
    }
}
