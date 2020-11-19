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
public class Movie {

    private String title;
    private String director;
    private String rating;
// a constructor is similar to a method thats called when an instance
// of an object is created. Constructor does have a return type,
// Unlike methods, constructor are not considered members of a class
// A constructor is called automatically when a new instance of an object is created.    

    public Movie(String title, String director, String rating) {
        this.setTitle(title); 
        this.director = director;
        this.rating = rating;
        
    }

    public void setRating(String rating) {

        if (rating.equals("G") || rating.equals("PG-13") || rating.equals("R") || rating.equals("NR")) {
            this.rating = rating;
        } else {
            this.rating = "NR";
        }

    }

    public void setTitle(String title) {
        this.title = title;
   
    }
    public void setDirector(String director) {
        this.director = director;
    }
    public String getRating(String rating){
        return rating;
       
    }
    public String getDirector(){
        return director;
    }
    public String getTitle(){
        return title;
    }
    public String getRating(){
        return rating;
    }
}
