package ListExamples;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author michaelrodriguez
 */
public class ListExample2 {

    public static void main(String[] args) {

        List<String> stringList = new ArrayList<>();

        // add a String object to our list
        stringList.add("My First String");

        // add another String object to our list
        stringList.add("My Secound String");

        // add another String object to our list
        stringList.add("My Third String");

        // add another String object to our list
        stringList.add("My Fourth  String");

        // ask the list how big it is
        System.out.println("List Size : " + stringList.size());

        // for each currentString in the stringList pull it out and 
        // do something in the for loop 
        for (String currentString : stringList) {
            System.out.println(currentString);
        }
        // We are instantiating the iterator, and creating an object 
        // which is determined by the stringList.iterator method 
        Iterator<String> iterator = stringList.iterator(); 
        
        // we are asking if the iterator has anyhthing left, if so
        // like the advance for loop we assign currentString to the string that
        // is on the loop, and it will continue to loop until there is nothing left
        // on the iterator.has next. 
        
        while(iterator.hasNext()){ 
            String currentString = iterator.next(); 
            System.out.println(currentString);
        }
    }
}
