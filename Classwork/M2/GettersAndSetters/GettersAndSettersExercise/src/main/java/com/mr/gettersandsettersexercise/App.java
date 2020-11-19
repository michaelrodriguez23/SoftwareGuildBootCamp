/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mr.gettersandsettersexercise;

/**
 *
 * @author michaelrodriguez
 */
public class App {
    public static void main(String[] args) {
        Movie movie1 = new Movie("The Avengers", "Joss Whedon", "PG-13");
        Movie movie2 = new Movie("Step Brothers", "Adam McKay", "R");
        
        movie1.setRating("PG-13");
        movie1.setTitle("DOGGGY");
//        G, PG, PG-13, R , NR 
        System.out.println(movie1.getTitle());
        System.out.println(movie1.getTitle());
        
    }
    
}
