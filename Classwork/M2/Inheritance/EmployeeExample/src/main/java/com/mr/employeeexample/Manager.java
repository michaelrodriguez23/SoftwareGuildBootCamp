/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mr.employeeexample;

/**
 *
 * @author michaelrodriguez
 */
public class Manager extends Employee {
    Manager manager = new Manager(); 
    Employee employee = new Employee(); 
    
    
    @Override
   public void createYearlyObjectives(){
   manager.createYearlyObjectives();
   manager.quit();
   manager.quit();
   
   ;
   
   
   }
           
    public void hire() {
        // code to hire someone... 
    }
    public void fire(){
        // code to fire someone... 
    }
    
    public void givePerformanceReview() {
       // code to give performance review
    }
    
}
