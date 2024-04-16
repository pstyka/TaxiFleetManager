package com.example.pawel.service;

import com.example.pawel.model.CarDTO;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CarService {
    List<CarDTO> getCars();
    Optional<CarDTO> getCarById(UUID carId);

    CarDTO saveNewCar(CarDTO carDTO);

    Optional<CarDTO> updateCarById(UUID carId, CarDTO carDTO);

    Boolean deleteById(UUID carId);

    Optional<CarDTO> patchCarById(UUID carId, CarDTO carDTO);
}
