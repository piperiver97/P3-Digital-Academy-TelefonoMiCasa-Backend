package com.factoriaf5.telefono_micasa.dtos;

public class PropertyDTO {
    private String type; // 'house', 'flat', 'garage', 'storageroom'
    private Double price;

    // Atributos comunes
    private String address;   // Cambiado de 'zone' a 'address'
    private String description;

    // Atributos específicos para 'house' y 'flat'
    private Integer room;      // Cambiado de 'numberOfRooms' a 'room'
    private Integer bathroom;  // Cambiado de 'numberOfBathrooms' a 'bathroom'
    private Integer floors;
    private Double area;       // Cambiado de 'squareMeters' a 'area'

    // Solo para 'flat'
    private Boolean hasElevator;  // Cambiado de 'elevator' a 'hasElevator'

    // Getters y setters

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getRoom() {
        return room;
    }

    public void setRoom(Integer room) {
        this.room = room;
    }

    public Integer getBathroom() {
        return bathroom;
    }

    public void setBathroom(Integer bathroom) {
        this.bathroom = bathroom;
    }

    public Integer getFloors() {
        return floors;
    }

    public void setFloors(Integer floors) {
        this.floors = floors;
    }

    public Double getArea() {
        return area;
    }

    public void setArea(Double area) {
        this.area = area;
    }

    public Boolean getHasElevator() {
        return hasElevator;
    }

    public void setHasElevator(Boolean hasElevator) {
        this.hasElevator = hasElevator;
    }
}

