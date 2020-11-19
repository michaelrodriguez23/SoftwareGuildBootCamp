/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mr.vendingmachine.dto;

import java.math.BigDecimal;
import java.util.Objects;

/**
 *
 * @author michaelrodriguez
 */
public class Item {


    private String Id;
    private String Name;
    private BigDecimal Cost;
    private int Qty;
    
    public Item(String id){
        this.Id = id; 
    }

    public Item() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getId() {
        return Id;
    }

    public void setId(String Id) {
        this.Id = Id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public BigDecimal getCost() {
        return Cost;
    }

    public void setCost(BigDecimal Cost) {
        this.Cost = Cost;
    }

    public int getQty() {
        return Qty;
    }

    public void setQty(int Qty) {
        this.Qty = Qty;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.Id);
        hash = 97 * hash + Objects.hashCode(this.Name);
        hash = 97 * hash + Objects.hashCode(this.Cost);
        hash = 97 * hash + this.Qty;
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
        final Item other = (Item) obj;
        if (this.Qty != other.Qty) {
            return false;
        }
        if (!Objects.equals(this.Id, other.Id)) {
            return false;
        }
        if (!Objects.equals(this.Name, other.Name)) {
            return false;
        }
        if (!Objects.equals(this.Cost, other.Cost)) {
            return false;
        }
        return true;
    }
    



    
}
