package com.example.pawel.controller;

import com.example.pawel.entities.Car;
import com.example.pawel.model.CarDTO;
import com.example.pawel.service.CarService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@Slf4j
public class CarController {
    private static final String CAR_PATH = "/api/v1/car";
    private static final String CAR_PATH_ID = CAR_PATH + "/{carId}";
    private final CarService carService;

    @GetMapping(value = CAR_PATH)
    public List<CarDTO> getCars(){
        return carService.getCars();
    }

    @GetMapping(value = CAR_PATH_ID)
    public CarDTO getCarById(UUID carId){
        return null;
    }
    @PostMapping(value = CAR_PATH)
    public ResponseEntity  addCar(@Validated @RequestBody CarDTO carDTO){
        return null;
    }
    @PutMapping(value = CAR_PATH_ID)
    public ResponseEntity updateCar(UUID carId, CarDTO carDTO){
        return null;
    }
    @DeleteMapping(value = CAR_PATH_ID)
    public ResponseEntity deleteCar(UUID carId){
        return null;
    }
}
