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

    @ManyToOne  // Indicates a many-to-one relationship
    @JoinColumn(name = "property_id", nullable = false)  // Specifies the foreign key column
    private Property property;

    public Appointment() {
    }

    public Appointment(String name, String phone, String timeSlot, Property property) {
        this.name = name;
        this.phone = phone;
        this.timeSlot = timeSlot;
        this.property = property;
    }

    // Getters and Setters

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
