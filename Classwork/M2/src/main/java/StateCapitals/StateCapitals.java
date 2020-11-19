/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StateCapitals;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author michaelrodriguez
 */
public class StateCapitals {

    public static void main(String[] args) {
        Map<String, String> stateMap = new HashMap<>();

        stateMap.put("New York", "Albany");
        stateMap.put("Alabama", "Montgomery");
        stateMap.put("Arizona", "Phoenix");
        stateMap.put("Arkansas", "Little Rock");
        stateMap.put("Califonia", "Sacramento");
        stateMap.put("Denver", "Colorado");
        stateMap.put("Connecticut", "Hartford");
        stateMap.put("Delaware", "Dover");
        

      

      
        
        System.out.println("States :");
        
        for (String currentState : stateMap.keySet()) {
            System.out.println(currentState);
        }
        
        
        
        System.out.println("\nCapitals : ");

        for (String currentCapital : stateMap.values()) {
            System.out.println(currentCapital);
            
        }
        
        System.out.println("\nSTATE/CAPITAL");
        
        Set<String> state = stateMap.keySet();
        
        for(String currentState : state) {
            String currentCapital = stateMap.get(currentState);
            System.out.println( currentState + " / " +  currentCapital);
        }
       
    }

}
