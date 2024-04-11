package com.example.pawel.mappers;

import com.example.pawel.entities.Car;
import com.example.pawel.model.CarDTO;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Primary
@Component
public class CarMapperImpl2 implements CarMapper {
    @Override
    public Car carDTOToCar(CarDTO carDTO) {
        return null;
    }

    @Override
    public CarDTO carToCarDTO(Car car) {
        if (car == null) {
            return null;
        }

        return CarDTO.builder()
                .id(car.getId())
                .brand(car.getBrand())
                .model(car.getModel())
                .color(car.getColor())
                .registrationNumber(car.getRegistrationNumber())
                .productionYear(car.getProductionYear())
                .mileage(car.getMileage())
                .wheelState(car.getWheelState())
                .image(car.getImage())
                .build();
    }
}
