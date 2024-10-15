package com.factoriaf5.telefono_micasa.models;

import jakarta.persistence.*;
@Entity
@Table(name = "appointments")
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String phone;

    @Column(nullable = false)
    private String timeSlot;

    @ManyToOne  
    @JoinColumn(name = "property_id", nullable = false)  
    private Property property;

    @Column(nullable = false) 
    private Long userId;

    public Appointment() {
    }

    public Appointment(String name, String phone, String timeSlot, Property property, Long userId) {
        this.name = name;
        this.phone = phone;
        this.timeSlot = timeSlot;
        this.property = property;
        this.userId = userId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getTimeSlot() {
        return timeSlot;
    }

    public void setTimeSlot(String timeSlot) {
        this.timeSlot = timeSlot;
    }

    public Property getProperty() {
        return property;
    }

    public void setProperty(Property property) {
        this.property = property;
    }
    
}
