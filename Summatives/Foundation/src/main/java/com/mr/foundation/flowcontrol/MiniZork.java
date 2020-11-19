/*
 Have you ever read those Choose Your Own Adventure books? Or played Zork? (It was like a CYOA, but even MORE awesome!) Well - I got really excited about it, and knowing ifs, thought this would be a GREAT time to write my own!
Except I only got a part of the way through it when I got writer's block. Can you help me finish it?? It doesn't need a lot of work just ... a few more choice branches.
Note: Write out the rest of the story with nested if/elses. It needs to have at least two choices for each branch, at least 3 choices down. (Basically, ask for user input at least 3 times each time someone plays, and those 3 times should have 2 choices each!) Follow the template given so far, and don't worry too much about bad user input.

 */
package com.mr.foundation.flowcontrol;
import java.util.Scanner; 
/**
 *
 * @author michaelrodriguez
 */
public class MiniZork {
    public static void main(String[] args) {
        
        Scanner userInput = new Scanner(System.in);
        
        System.out.println("You are standing in an open field west of a white house,");
        System.out.println("With a boarded front door.");
        System.out.println("There is a small mailbox here");
        System.out.println("Go to the house, or open the mailbox? ");
        
        String action = userInput.nextLine(); 
        if(action.equals("Go to the house")){
            System.out.println("the door is locked");
        }
        
         if(action.equals("open the mailbox")){
            System.out.println("You open the mailbox. ");
            System.out.println("It's really dark in there.");
            System.out.println("Look inside or stick your hand in?");
            action = userInput.nextLine(); 
        
            if(action.equals("look inside")) { 
                System.out.println("You peer inside the mailbox");
                System.out.println("It's really very dark. So .... very dark");
                System.out.println("Run away or keep looking? ");
                action = userInput.nextLine(); 
                
                if (action.equals("keep looking")) {
                    System.out.println("Turns out, hanging out around dark places isn't a good idea.");
                    System.out.println("You've been eaten by a grue.");
                } else if (action.equals("run away")) {
                    System.out.println("You run away screaming across the fields - looking very foolish.");
                    System.out.println("But you alive. Possibly a wise choice.");
                } 
                if(action.equals("stick your hand in")){
                    System.out.println("You got mail! ");
                    System.out.println("Do you care to open it? ");
                    
                    if(action.equals("yes")){
                        System.out.println("The mail was filled with body eating snails. ");
                        System.out.println("Your Dead!");
                    }
                    if(action.equals("no")){
                                System.out.println("Phhheww that was close. ");
                                System.out.println("The mail was infested with killer snaills");   
                    } 
                }
            }
        }
    }
}    

    
