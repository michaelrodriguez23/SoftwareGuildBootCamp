/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RefactorRockPaperScissors;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author michaelrodriguez
 */
public class RPSGame {

    public void run() {
        View view = new View();

        int rock = 1;
        int paper = 2;
        int scissors = 3;
        String userInput;
        boolean keepGoing = true;
        boolean play = true;

        String playAgain;

        Scanner sc = new Scanner(System.in);
        Random randomizer = new Random();

        view.print("Welcome to our fantastic game! ");
        do {
            int tie = 0;
            int won = 0;
            int loss = 0;
            int counter = 0;
            int rounds = 0;
            int player = 0;
            int computer;
            rounds = view.readInt("How many rounds would you like to play? 1-10 ");
//            rounds = Integer.parseInt(sc.next());
            if (play) {
                if (counter < rounds) {

                    do {
                        userInput = view.read("Choose Rock, Paper, or Scissor");
//                        userInput = sc.next();
                        computer = randomizer.nextInt(3) + 1;

                        switch (userInput) {
                            case "rock":
                                player = 1;
                                break;
                            case "paper":
                                player = 2;
                                break;
                            case "scissor":
                                player = 3;
                                break;
                            default:
                                view.print("Invalid input, but ill let you ROCK for now");
                                player = 3;
                                break;
                        }

                        if (player == 1 && computer == 3) {
                            won++;
                            counter++;
                            view.print("you win");

                        } else if (player == 2 && computer == 1) {
                            won++;
                            counter++;
                            view.print("you win");

                        } else if (player == 3 && computer == 2) {
                            won++;
                            counter++;
                            view.print("you win");

                        }
                        if (player == 1 && computer == 2) {
                            loss++;
                            counter++;
                            view.print("you loss");

                        } else if (player == 2 && computer == 3) {
                            loss++;
                            counter++;
                            view.print("you loss");

                        } else if (player == 3 && computer == 1) {
                            loss++;
                            counter++;
                            view.print("you loss");

                        } else if (player == computer) {
                            tie++;
                            counter++;
                            view.print("Its a tie");

                        }

                    } while (counter < rounds);
                    view.print("Results: " + "\n Wins: " + won + "\n Losses: " + loss + "\n Ties: " + tie);
                    view.print("Do you Want to play again (Y/N) ?");
                    playAgain = sc.next();
                    if (playAgain.equalsIgnoreCase("Y")) {

                        play = true;

                    } else {
                        view.print("Thanks for playing! ");
                        play = false;
                    }

                }
            }
        } while (play);

    }
}
