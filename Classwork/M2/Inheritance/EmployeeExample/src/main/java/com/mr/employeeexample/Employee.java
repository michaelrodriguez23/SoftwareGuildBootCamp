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
public class Employee {
    protected String firstName;
    protected String lastName;
    
    public void doWork() { 
        //Code to do work...
    }
    public void quit(){
    
    }
    public void createYearlyObjectives() {
        // code to create yearly objectives...
    }
    
    public String getFirstName() {
        return firstName; 
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    
    public String getLastName() { 
        return lastName; 
    }
    public void setLastName(String lastName){
        this.lastName = lastName; 
    }
}
