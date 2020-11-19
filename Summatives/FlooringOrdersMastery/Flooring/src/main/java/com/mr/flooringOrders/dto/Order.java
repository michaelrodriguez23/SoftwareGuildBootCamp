/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mr.flooringOrders.dto;

import java.math.BigDecimal;

/**
 *
 * @author michaelrodriguez
 */
public class Order {

    private int orderId;
    private String customerName;
    private String state;
    private BigDecimal stateTaxes;
    private String productType;
    private Double area;
    private BigDecimal costPerSqFoot;
    private BigDecimal laborCostPerSqFoot;
    private BigDecimal materialCost;
    private BigDecimal laborCost;
    private BigDecimal tax;
   

  
    private BigDecimal total;

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public BigDecimal getStateTaxes() {
        return stateTaxes;
    }

    public void setStateTaxes(BigDecimal stateTaxes) {
        this.stateTaxes = stateTaxes;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public Double getArea() {
        return area;
    }

    public void setArea(Double area) {
        this.area = area;
    }

    public BigDecimal getCostPerSqFoot() {
        return costPerSqFoot;
    }

    public void setCostPerSqFoot(BigDecimal costPerSqFoot) {
        this.costPerSqFoot = costPerSqFoot;
    }

    public BigDecimal getLaborCostPerSqFoot() {
        return laborCostPerSqFoot;
    }

    public void setLaborCostPerSqFoot(BigDecimal laborCostPerSqFoot) {
        this.laborCostPerSqFoot = laborCostPerSqFoot;
    }

    public BigDecimal getMaterialCost() {
        return materialCost;
    }

    public void setMaterialCost(BigDecimal materialCost) {
        this.materialCost = materialCost;
    }

    public BigDecimal getLaborCost() {
        return laborCost;
    }

    public void setLaborCost(BigDecimal laborCost) {
        this.laborCost = laborCost;
    }

    public BigDecimal getTax() {
        return tax;
    }

    public void setTax(BigDecimal tax) {
        this.tax = tax;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

}
