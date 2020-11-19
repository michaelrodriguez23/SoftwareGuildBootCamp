/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StateCapitals;

/**
 *
 * @author michaelrodriguez
 */
public class Capital {
    
    private String name; 
    private int population;
    private int sqMileage;
    public String everthing; 
    
    public Capital(String name, int population, int sqMileage ){
        this.setName(name);
        this.population = population;
        this.sqMileage = sqMileage;
        this.everthing = name + " has a population of " + population + " people | " +  sqMileage + "  square miles" ;
        
        
        
        
        
    }
    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public double getSqMileage() {
        return sqMileage ;
    }

    public void setSqMileage(double sqMileage) {
        this.sqMileage = sqMileage;
    }
    
        
}
