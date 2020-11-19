package M1;


import java.util.Scanner;
import java.util.Random;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author michaelrodriguez
 */
public class RockPaperScissors {

    public static void main(String[] args) {
        int rock = 1;
        int paper = 2;
        int scissors = 3;
        String userInput;
        int player = 0;
        int computer;
        boolean keepGoing = true;
        boolean play = true;

        String playAgain;

        Scanner sc = new Scanner(System.in);
        Random randomizer = new Random();
        System.out.println("Welcome to our fantastic game! ");
        do {
            int tie = 0;
            int won = 0;
            int loss = 0;
            int counter = 0;
            int rounds = 0;
            System.out.println("How many rounds would you like to play? 1-10 ");
            rounds = Integer.parseInt(sc.next());
            if (play) {
                if (counter <= rounds) {

                    do {
                        System.out.println("Choose Rock, Paper, or Scissor");
                        userInput = sc.next();
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
                                System.out.println("Invalid input, but ill let you ROCK for now");
                                player = 3;
                                break;
                        }

                        if (player == 1 && computer == 3) {
                            won++;
                            counter++;
                            System.out.println("you win");

                        } else if (player == 2 && computer == 1) {
                            won++;
                            counter++;
                            System.out.println("you win");

                        } else if (player == 3 && computer == 2) {
                            won++;
                            counter++;
                            System.out.println("you win");

                        }
                        if (player == 1 && computer == 2) {
                            loss++;
                            counter++;
                            System.out.println("you loss");

                        } else if (player == 2 && computer == 3) {
                            loss++;
                            counter++;
                            System.out.println("you loss");

                        } else if (player == 3 && computer == 1) {
                            loss++;
                            counter++;
                            System.out.println("you loss");

                        } else {
                            tie++;
                            counter++;
                            System.out.println("Its a tie");

                        }

                    } while (counter < rounds);
                    System.out.println("Results: " + "\n Wins: " + won + "\n Losses: " + loss + "\n Ties: " + tie);
                    System.out.println("Do you Want to play again (Y/N) ?");
                    playAgain = sc.next();
                    if (playAgain.equalsIgnoreCase("Y")) {

                        play = true;

                    } else {
                        System.out.println("Thanks for playing! ");
                        play = false;
                    }

                }
            }
        } while (play);

    }
}
