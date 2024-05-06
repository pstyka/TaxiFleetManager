package com.example.pawel.mappers;

import com.example.pawel.entities.Car;
import com.example.pawel.model.CarDTO;
import org.mapstruct.Mapper;

@Mapper
public interface CarMapper {
    public Car carDTOToCar(CarDTO carDTO);
    public CarDTO carToCarDTO(Car car);
    
}
