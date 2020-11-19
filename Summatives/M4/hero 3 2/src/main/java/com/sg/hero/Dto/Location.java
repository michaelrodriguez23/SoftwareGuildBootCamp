/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.hero.Dto;

import java.util.Objects;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author alanc
 */
public class Location {

//    locationId INT PRIMARY KEY AUTO_INCREMENT,
//    locationDescription VARCHAR(30) NOT NULL,
//    street VARCHAR(30) NOT NULL,
//    city VARCHAR(20) NOT NULL,
//    state CHAR(2) NOT NULL,
//    zip CHAR(5) NOT NULL,
//    lattitude decimal(10,8) NOT NULL,
//    longitude decimal(11,8) NOT NULL
    private int LocationId;

    @NotBlank(message = "Description must not be empty.")
    @Size(max = 30, message = "Description must be less than 30 characters.")
    private String LocationDescription;

    @NotNull(message = "Lattitude must not be empty.")
    @Digits(integer = 2, fraction = 8, message = "Lattitude too short or too long")
    @DecimalMin(value = "-90", message = "Lattutude Too Short")
    @DecimalMax(value = "90", message = "Lattutude Too Long")
    private Double Lattitude;

    @NotNull(message = "Longitude must not be empty.")
    @Digits(integer = 2, fraction = 8, message = "Longitude too short or too long")
    @DecimalMin(value = "-180", message = "Longitude Too Short")
    @DecimalMax(value = "180", message = "Longitude Too Long")
    private Double Longitude;

    @NotBlank(message = "Street must not be empty.")
    @Size(max = 30, message = "Street must be less than 30 characters.")
    private String Street;

    @NotBlank(message = "City must not be empty.")
    @Size(max = 20, message = "City must be less than 20 characters.")
    private String City;

    @NotBlank(message = "State must not be empty.")
    @Size(max = 20, message = "State must be less than 2 characters.")
    private String State;
    
    @NotBlank(message = "Zip must not be empty.")
    @Size(max = 20, message = "Zip must be less than 5 characters.")
    private String Zip;

    public int getLocationId() {
        return LocationId;
    }

    public void setLocationId(int LocationId) {
        this.LocationId = LocationId;
    }

    public String getLocationDescription() {
        return LocationDescription;
    }

    public void setLocationDescription(String LocationDescription) {
        this.LocationDescription = LocationDescription;
    }

    public Double getLattitude() {
        return Lattitude;
    }

    public void setLattitude(Double Lattitude) {
        this.Lattitude = Lattitude;
    }

    public Double getLongitude() {
        return Longitude;
    }

    public void setLongitude(Double Longitude) {
        this.Longitude = Longitude;
    }

    public String getStreet() {
        return Street;
    }

    public void setStreet(String Street) {
        this.Street = Street;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String City) {
        this.City = City;
    }

    public String getState() {
        return State;
    }

    public void setState(String State) {
        this.State = State;
    }

    public String getZip() {
        return Zip;
    }

    public void setZip(String Zip) {
        this.Zip = Zip;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 43 * hash + this.LocationId;
        hash = 43 * hash + Objects.hashCode(this.LocationDescription);
        hash = 43 * hash + Objects.hashCode(this.Lattitude);
        hash = 43 * hash + Objects.hashCode(this.Longitude);
        hash = 43 * hash + Objects.hashCode(this.Street);
        hash = 43 * hash + Objects.hashCode(this.City);
        hash = 43 * hash + Objects.hashCode(this.State);
        hash = 43 * hash + Objects.hashCode(this.Zip);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Location other = (Location) obj;
        if (this.LocationId != other.LocationId) {
            return false;
        }
        if (!Objects.equals(this.LocationDescription, other.LocationDescription)) {
            return false;
        }
        if (!Objects.equals(this.Street, other.Street)) {
            return false;
        }
        if (!Objects.equals(this.City, other.City)) {
            return false;
        }
        if (!Objects.equals(this.State, other.State)) {
            return false;
        }
        if (!Objects.equals(this.Zip, other.Zip)) {
            return false;
        }
        if (!Objects.equals(this.Lattitude, other.Lattitude)) {
            return false;
        }
        if (!Objects.equals(this.Longitude, other.Longitude)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Location{" + "LocationId=" + LocationId + ", LocationDescription=" + LocationDescription + ", Lattitude=" + Lattitude + ", Longitude=" + Longitude + ", Street=" + Street + ", City=" + City + ", State=" + State + ", Zip=" + Zip + '}';
    }



}
