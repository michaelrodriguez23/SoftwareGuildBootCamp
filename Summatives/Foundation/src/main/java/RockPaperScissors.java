
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
        int computer = 0; 
        boolean keepGoing = true; 
        boolean play = true; 
        int counter = 0; 
        int rounds = 0 ;
        int tie = 0;
        int won = 0;
        int loss = 0;
        
        
        Scanner sc = new Scanner(System.in);
        Random randomizer = new Random(); 

        
        if(play){
            System.out.println("How many rounds would you like to play? 1-10 ");
            rounds = sc.nextInt();
            System.out.println("Choose Rock, Paper, or Scissor");
            computer = randomizer.nextInt(2)+1;
            userInput = sc.next();
            while(counter>rounds){
               // won 
                      if(player == 1 && computer == 3){
                      if (player == 2 && computer == 1){
                      if(player == 3 && computer == 2){
                        won++; 
                        counter--;
                        System.out.println("you win");
                             
                          //loss
                        } if (player == 1 && computer == 2){
                          if (player == 2 && computer == 3){
                          if (player == 3 && computer == 1){
                              loss++; 
                              counter--;
                              System.out.println("you loss");
                        } else {
                            tie++; 
                            counter--;
                            System.out.println("Its a tie");
                          }
            
            if(userInput.equalsIgnoreCase("rock")){ 
                   player = 1; 
            }else if(userInput.equalsIgnoreCase("paper")){
                       player = 2;
                       System.out.println(player);
            }else if(userInput.equalsIgnoreCase("scissor")){
                       player = 3; 
                       System.out.println(player);
            }else { player = 1; 
                     System.out.println("Invalid input, but ill let you ROCK for now");
            }
                         
                        
                    
                 }
            }
             
            
        }
                    }
                 }
                 }
            }
        }
    



    

