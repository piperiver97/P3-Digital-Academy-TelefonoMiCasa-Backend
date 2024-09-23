package com.factoriaf5.telefono_micasa.models;

import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "property_type", discriminatorType = DiscriminatorType.STRING)
public class Property {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private double price;
    private String description;
    private String  address;
    private double area;
    private String action;

    public Property(){}

    public Property(Long id, double price, String description, String address, double area, String action) {
        this.id = id;
        this.price = price;
        this.description = description;
        this.address = address;
        this.area = area;
        this.action = action;
    }


    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }


    public double getPrice() {
        return price;
    }


    public void setPrice(double price) {
        this.price = price;
    }


    public String getDescription() {
        return description;
    }


    public void setDescription(String description) {
        this.description = description;
    }


    public String getAddress() {
        return address;
    }


    public void setAddress(String address) {
        this.address = address;
    }


    public double getArea() {
        return area;
    }


    public void setArea(double area) {
        this.area = area;
    }


    public String getAction() {
        return action;
    }


    public void setAction(String action) {
        this.action = action;
    }
    
    
    
}
