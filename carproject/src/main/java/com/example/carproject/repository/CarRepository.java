package com.example.carproject.repository;

import com.example.carproject.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, Long> {

    void save(Car car);
    
}
