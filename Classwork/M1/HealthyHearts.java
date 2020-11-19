package M1;


import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author michaelrodriguez
 */
public class HealthyHearts {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int age;
        int MaximumHeartRate;

        double min;
        double max;

        System.out.println("Whats Your age? ");
        age = Integer.parseInt(sc.next());

        MaximumHeartRate = 220 - age;
        System.out.println(MaximumHeartRate);

        min = MaximumHeartRate * .50;
        max = MaximumHeartRate * .85;
        System.out.println("Your maximum heart rate should be " + max + " beats per minute");
        System.out.println("Your target HR Zone is " + (int) Math.round(min) + "-"
                + (int) Math.round(max) + " beats per minute");

    }

}
