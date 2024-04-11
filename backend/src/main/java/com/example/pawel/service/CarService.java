package com.example.pawel.service;

import com.example.pawel.entities.Car;
import com.example.pawel.model.CarDTO;

import java.util.List;

public interface CarService {
    List<CarDTO> getCars();
}
