package com.example.carproject.controller;

import com.example.carproject.model.Car;
import com.example.carproject.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Controller
public class CarController {
    @Autowired
    private CarRepository carRepository;

    @GetMapping("/")
    public String showCarForm(Model model) {
        model.addAttribute("car", new Car());
        return "carForm";
    }

    @PostMapping("/saveCar")
    public String saveCar(Car car, @RequestParam("carImage") MultipartFile carImage) throws IOException {
        if (!carImage.isEmpty()) {
            String imageUploadPath = "C:\\Car";
            String fileName = carImage.getOriginalFilename();
            File imageFile = new File(imageUploadPath + fileName);
            carImage.transferTo(imageFile);
            car.setCarImagePath(fileName);
        }

        carRepository.save(car);
        return "redirect:/";
    }

    @GetMapping("/cars")
    public String showAllCars(Model model) {
        model.addAttribute("cars", carRepository.findAll());
        return "carForm";
    }
}
