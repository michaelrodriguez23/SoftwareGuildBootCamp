/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m1;

/**
 *
 * @author michaelrodriguez
 */
public class SummativeSums {

    public static void main(String[] args) {
        System.out.println(sum());

    }

    public static String sum() {
        int sumOne = 0;
        int sumTwo = 0;
        int sumThree = 0;

        int[] arrayOne = {1, 90, -33, -55, 67, -16, 28, -55, 15};
        int[] arrayTwo = {999, -60, -77, 14, 160, 301};
        int[] arrayThree = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100, 110, 120, 130,
            140, 150, 160, 170, 180, 190, 200, -99};

        for (int i = 0; i < arrayOne.length; i++) {
            sumOne += arrayOne[i];
            

        }
        for (int i = 0; i < arrayTwo.length; i++) {
            sumTwo += arrayTwo[i];
        }

        for (int i = 0; i < arrayThree.length; i++) {
            sumThree += arrayThree[i];
        } return sumOne +"\n"+ sumTwo +" \n" + sumThree;  
   }
    
}

