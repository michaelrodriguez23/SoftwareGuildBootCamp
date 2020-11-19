/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mr.foundation.basics;
import java.util.Scanner;

/**
 *
 * @author michaelrodriguez
 */
public class MiniMadLibs2 {
    public static void main(String[] args) {
        Scanner inputReader = new Scanner(System.in);
        
       //1
        String noun;
        System.out.println("Feed me a noun");
        noun = inputReader.nextLine();
        
       //2
        String adjective;
        System.out.println("Feed me an adjective");
        adjective = inputReader.nextLine();
        
       //3
        String noun2;
        System.out.println("Feed me a noun");
        noun2 = inputReader.nextLine();
        
       //4
        double num1;
        System.out.println("Feed me a number");
        num1 = inputReader.nextDouble();
        
       //5
        String adjective2;
        System.out.println("Feed me an adjective");
        adjective2 = inputReader.nextLine();
        
       //6
        String nounPlural1; 
        System.out.println("Feed me a  plural noun");
        nounPlural1 = inputReader.nextLine();
        
       //7
        String nounPlural2;
        System.out.println("Feed me another plural noun");
        nounPlural2 = inputReader.nextLine();
        
       //8
        String nounPlural3;
        System.out.println("Feed me another plural noun");
        nounPlural3 = inputReader.nextLine();
        
       //9 
        String verbInfinitive; 
        System.out.println("Feed me an infinitive verb");
        verbInfinitive  = inputReader.nextLine();
        
      //10 
        String pastParticipleOfVerb;
        System.out.println("Feed me a past participle of the same verb");
        pastParticipleOfVerb = inputReader.nextLine();
        
        
        System.out.println("*** LETS PLAY MADLIBS");
        System.out.println("Read & Enjoy...");
         System.out.println("                        _    |     _\n" +
"                         ~,   \\  ,~\n" +
"                          \\  |  |   ,^,\n" +
"                 __ ,--,__|-----.__// |\n" +
"                /  '   '          /|#_| \n" +
"               ,-~-/~~\\               \\\n" +
"              /__ __   \\               \\\n" +
"             ;~__\"_ ~; |    ___        |\n" +
"     ____   / / /  | | | ,-'   '-,     \\\n" +
" .--'    ~-{  \\/  /  | |/         \\     \\\n" +
"/  _  ,-,   \\_/~-~  /  |           |    |\n" +
"| | \\ \\  \\   \\~~--~~   / }         \\    |\n" +
"\\  \\_| ~-/    |-____--~             |   |\n" +
" ~\\_          /              __     |   |\n" +
"    ~-+---.__/                |     |   |\n" +
"   /                        _/      |   |\n" +
"  |                  __ ___/        |   |\n" +
"  \\____/\\_______----\\  V  \\        /    |\n" +
"        |            \\  \\  \\      /    /|\n" +
"        |            |  !  |    ,-,_  / |\n" +
"        /             \\___/   _|.   ~-,  )\n" +
"       |                     /       _| |\n" +
"       |   ,-.              |        |   \\\n" +
"       |    o               \\_/ / /  |   |\n" +
"       |                      ~Y_/ _/    |\n" +
"       \\                       |~~      /\n" +
"         ~-_                   /     _-~\n" +
"            ~~----,________,-~~ _--~~\n" +
"                 /    /   /    / \n" +
"                |    |   |    |\n" +
"                \\     \\   \\    \\\n" +
"         _,-----_\\  _,----_\\    \\\n" +
"        /          /             \\\n" +
"    ###|          |               |#####\n" +
"   ####\\          \\              /#######\n" +
"    ####################################    \n" +
"        ######    #########     ####");
        
        System.out.println(noun + "  :  " + adjective + " frontier. " + " These are the voyages of the starship " + noun2 + " Its " +
                num1 + " -year mission: to explore strange " + adjective2 + nounPlural1 + ", to seek out" + adjective2 + nounPlural2 +
        " and " + adjective2 + nounPlural3 + ", to boldy" + verbInfinitive + " where no one has " + pastParticipleOfVerb + " before." );
       
        
      
    }
    
}
