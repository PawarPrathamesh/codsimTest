package com.example.carproject.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String carName;
    private String carModel;
    private String carVariant;
    private String carImagePath;
    public void setCarImagePath(String fileName) {
        
    }

    // Constructors, getters, and setters
}
