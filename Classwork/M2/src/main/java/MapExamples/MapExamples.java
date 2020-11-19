/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MapExamples;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author michaelrodriguez
 */
public class MapExamples {

    public static void main(String[] args) {
        Map<String, Integer> populations = new HashMap<>();

        populations.put("USA", 2);

        populations.put("CANADA", 3);

        populations.put("UNITED KINGDOM", 5);

        populations.put("JAPAN", 3);

        System.out.println("Map Size is: " + populations.size());

        Integer usaPopulation = populations.get("USA");
        
        System.out.println(usaPopulation);
        populations.put("USA", 7); 
        
        usaPopulation = populations.get("USA");
        System.out.println(usaPopulation); 
        
        Set<String> keys = populations.keySet();
        
       // We declare a variable on the left side of the colon , and on
       // on the right hand side we put in the collection we want to grab 
       // out of. 
       // Grab one by one 
       
        for(String currentKey : keys){
            Integer currentPopulation = populations.get(currentKey); 
            System.out.println("The Population of " + currentKey + " is " + currentPopulation);
        }

        Collection<Integer> populationValues = populations.values(); 
        
        for(Integer currentPopulation: populationValues){ 
            System.out.println("Current Population : " + currentPopulation);
        }
         
   }

}
