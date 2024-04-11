package com.example.pawel.service;

import com.example.pawel.mappers.CarMapper;
import com.example.pawel.model.CarDTO;
import com.example.pawel.repository.CarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Primary
@RequiredArgsConstructor
public class CarServiceImpl implements CarService {
    private final CarRepository carRepository;
    private final CarMapper carMapper;
    @Override
    public List<CarDTO> getCars() {
        return carRepository.findAll()
                .stream()
                .map(carMapper::carToCarDTO)
                .collect(Collectors.toList());
    }
}
