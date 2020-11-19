/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mr.dvdlibrary.dto;

import java.util.Objects;

/**
 *
 * @author michaelrodriguez
 */
public class Dvd {

    // these Are the DVD data Transfer Objects Properties. 
    private String title;

    public String getTitle() {
        return title;
    }
    private String releaseDate;
    private String mpaaRating;
    private String directorsName;
    private String studio;
    private String userCustomNote;

    // Notice that this isn't a getter/setter. 
    public Dvd(String title) {
        this.title = title;

    }

    public String getDvd(String title) {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDirectorsName() {
        return directorsName;
    }

    public void setDirectorsName(String directorsName) {
        this.directorsName = directorsName;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getMpaaRating() {
        return mpaaRating;
    }

    public void setMpaaRating(String mpaaRating) {
        this.mpaaRating = mpaaRating;
    }

    public String getStudio() {
        return studio;
    }

    public void setStudio(String studio) {
        this.studio = studio;
    }

    public String getUserCustomNote() {
        return userCustomNote;
    }

    public void setUserCustomNote(String userCustomNote) {
        this.userCustomNote = userCustomNote;
    }
    
    // the equals method is available on the class object. 
    // this allows us to define which of the fields is equals to one 
    // and other. 
    // It's import when doing equals and hashcode , is that is expected that
    // two objects that are equal to each other have EQUAL hashcode. 
    

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 17 * hash + Objects.hashCode(this.title);
        hash = 17 * hash + Objects.hashCode(this.releaseDate);
        hash = 17 * hash + Objects.hashCode(this.mpaaRating);
        hash = 17 * hash + Objects.hashCode(this.directorsName);
        hash = 17 * hash + Objects.hashCode(this.studio);
        hash = 17 * hash + Objects.hashCode(this.userCustomNote);
        return hash;
    }

    @Override
    // if the object that we are passing in is equal to the object
    // return true. 
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        } // if the object that is passed in is equal is null 
          // clearly we are not equal , because the original object shouldnt be nukk
        if (obj == null) {
            return false;
        } // if the class for my object, vs the object that got pass in 
        // clearly we return false. 
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Dvd other = (Dvd) obj;
        if (!Objects.equals(this.title, other.title)) {
            return false;
        }
        if (!Objects.equals(this.releaseDate, other.releaseDate)) {
            return false;
        }
        if (!Objects.equals(this.mpaaRating, other.mpaaRating)) {
            return false;
        }
        if (!Objects.equals(this.directorsName, other.directorsName)) {
            return false;
        }
        if (!Objects.equals(this.studio, other.studio)) {
            return false;
        }
        if (!Objects.equals(this.userCustomNote, other.userCustomNote)) {
            return false;
        }
        return true;
    }
    
    

}
