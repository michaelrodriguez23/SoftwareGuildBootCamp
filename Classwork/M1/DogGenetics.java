/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m1;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author michaelrodriguez
 */
public class DogGenetics {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random randomizer = new Random();

        String dogsName;
        int min = 0;
        int max = 100;
        int percentage1 = 0;

        int bernard;
        int chihuahua;
        int asianPug;
        int commonCur;
        int kingDoberman;

        System.out.println("What is your dogs name? ");
        dogsName = sc.nextLine();

        System.out.println(dogsName + " Is the dogs name");

        bernard = randomizer.nextInt(min + max);
        max = max - bernard;
        System.out.println(bernard + "% St. Bernard");

        chihuahua = randomizer.nextInt(min + max);
        max = max - chihuahua;
        System.out.println(chihuahua + "% Chihuahua");

        asianPug = randomizer.nextInt(min + max);
        max = max - asianPug;
        System.out.println(asianPug + "% Dramatic RedNosed Asian Pug");

        commonCur = randomizer.nextInt(min + max);
        max = max - commonCur;
        System.out.println(commonCur + "% Common Cur");

        kingDoberman = max;
        max = max - kingDoberman;
        System.out.println(kingDoberman + "% King Doberman");

    }
}
