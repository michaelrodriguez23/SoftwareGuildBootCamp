/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ListExamples;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author michaelrodriguez
 */
public class ListExamples {

    public static void main(String[] args) {
        List<String> stringList = new ArrayList<>();
        System.out.println("List size " + stringList.size());
        stringList.add("The first string <3");
        System.out.println("List size : " + stringList.size());
        stringList.add("The secound string");
        System.out.println("List Size " + stringList.size());
        stringList.remove(1);
        System.out.println("show list " + stringList.size());
        stringList.remove(0);
        System.out.println("show list " + stringList.size());
    }
}
