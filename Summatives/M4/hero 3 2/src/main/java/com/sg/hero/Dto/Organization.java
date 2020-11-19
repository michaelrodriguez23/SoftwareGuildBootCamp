/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.hero.Dto;

import java.util.List;
import java.util.Objects;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author alanc
 */
public class Organization {

    // whenever we have a composition of a list of heroes ->
    // we need a helper method to get heroesForOrganization 
    // The associate method are used when we need get all of objects. If we do get all organizations the associate methods will loop through,
    // 
    // ASSOCIATE -> LOOPS THROUGH OBJECTS 
    private int OrganizationId;
    @NotBlank(message = "Name must not be empty.")
    @Size(max = 30, message = "Name must be less than 30 characters.")
    private String Name;
    @NotBlank(message = "Description must not be empty.")
    @Size(max = 100, message = "Description must be less than 100 characters.")
    private String Descriptions;
    @NotBlank(message = "Street name must not be empty.")
    @Size(max = 30, message = "Street must be less than 30 characters.")
    private String Street;
    @NotBlank(message = "City name must not be empty.")
    @Size(max = 20, message = "City must be less than 20 characters.")
    private String City;
    @NotBlank(message = "State name must not be empty.")
    @Size(max = 2, message = "State must be 2 characters.")
    private String State;
    @NotBlank(message = "Zip name must not be empty.")
    @Size(max = 5, message = "Zip must be 5 characters.")
    private String Zip;
    
    private String MemberType;
    @NotNull(message = " HEROES CANT BE NULL")
    private List<Hero> heroes;

    public List<Hero> getHeroes() {
        return heroes;
    }

    public void setHeroes(List<Hero> heroes) {
        this.heroes = heroes;
    }

    public int getOrganizationId() {
        return OrganizationId;
    }

    public void setOrganizationId(int OrganizationId) {
        this.OrganizationId = OrganizationId;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getDescriptions() {
        return Descriptions;
    }

    public void setDescriptions(String Descriptions) {
        this.Descriptions = Descriptions;
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

    public String getMemberType() {
        return MemberType;
    }

    public void setMemberType(String MemberType) {
        this.MemberType = MemberType;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 47 * hash + this.OrganizationId;
        hash = 47 * hash + Objects.hashCode(this.Name);
        hash = 47 * hash + Objects.hashCode(this.Descriptions);
        hash = 47 * hash + Objects.hashCode(this.Street);
        hash = 47 * hash + Objects.hashCode(this.City);
        hash = 47 * hash + Objects.hashCode(this.State);
        hash = 47 * hash + Objects.hashCode(this.Zip);
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
        final Organization other = (Organization) obj;
        if (this.OrganizationId != other.OrganizationId) {
            return false;
        }
        if (!Objects.equals(this.Name, other.Name)) {
            return false;
        }
        if (!Objects.equals(this.Descriptions, other.Descriptions)) {
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
        return true;
    }

}
