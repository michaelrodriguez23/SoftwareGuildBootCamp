/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StateCapitals;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author michaelrodriguez
 */

// I believe I need to create an object to return the 3 associated values with each capita
// returning the name, population, and square Mileage. 
// I need to put the object in the value part of the map .


// I need to write code that ask the user for minumum population
// then i need to display capitals that have population above limit
// perhaps using a for loop . 



public class StateCapitals2 {

    public static void main(String[] args) {
        View myView = new View();
        Scanner sc = new Scanner(System.in); 
        
        
        

        
        String name;
        int population;
        int sqMileage;
        String userInput; 
        
        
        System.out.println("Enter the lowest limit for capital city population: ");
        userInput = sc.nextLine(); 
       
        for
        // for loop to go through map to find numbers higher than input

        Map<String, String> stateMap = new HashMap<>();
        
        
        Capital newYork = new Capital("Albany ", 300, 23); 
        Capital alabama = new Capital ("Montgomery ", 200, 400);
        Capital arizona = new Capital ("Phoenix ",1200, 4200);
        Capital arkansas = new Capital ("Little Rock ", 2020, 4040);
        Capital california = new Capital ("Phoenix ", 200, 10);
        Capital denver = new Capital ("Colorado ", 200, 4599);
        Capital conecticut = new Capital ("Hartford ", 45060, 12); 
        Capital delaware = new Capital ("Dover", 2120, 420); 
    
    
      
       
        
        stateMap.put("New York", newYork.everthing);
        stateMap.put("Alabama", alabama.everthing);
        stateMap.put("Arizona", arizona.everthing);
        stateMap.put("Arkansas", arkansas.everthing);
        stateMap.put("Califonia", california.everthing);
        stateMap.put("Denver", denver.everthing);
        stateMap.put("Conecticut", conecticut.everthing);
        stateMap.put("Delaware", delaware.everthing);
        
        
        
        

    }

}
