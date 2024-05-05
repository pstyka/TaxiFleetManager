package com.example.pawel.service;

import com.example.pawel.mappers.CarMapper;
import com.example.pawel.model.CarDTO;
import com.example.pawel.repository.CarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicReference;
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

    @Override
    public Optional<CarDTO> getCarById(UUID carId) {
        return Optional.ofNullable(carMapper.carToCarDTO(carRepository
                .findById(carId).orElse(null)));
    }

    @Override
    public CarDTO saveNewCar(CarDTO carDTO) {
        return carMapper
                .carToCarDTO(carRepository
                        .save(carMapper
                                .carDTOToCar(carDTO)));
    }

    @Override
    public Optional<CarDTO> updateCarById(UUID carId, CarDTO carDTO) {
        AtomicReference<Optional<CarDTO>> atomicReference = new AtomicReference<>();
        carRepository.findById(carId).ifPresentOrElse(foundCar -> {
            foundCar.setBrand(carDTO.getBrand());
            foundCar.setModel(carDTO.getModel());
            foundCar.setColor(carDTO.getColor());
            foundCar.setRegistrationNumber(carDTO.getRegistrationNumber());
            foundCar.setProductionYear(carDTO.getProductionYear());
            foundCar.setMileage(carDTO.getMileage());
            foundCar.setWheelState(carDTO.getWheelState());
            foundCar.setImage(carDTO.getImage());
            atomicReference
                    .set(Optional.of(carMapper.carToCarDTO(carRepository.save(foundCar))));
        }, () -> {
            atomicReference.set(Optional.empty());
        });
        return atomicReference.get();
    }

    @Override
    public Boolean deleteById(UUID carId) {

        if(carRepository.existsById(carId)){
            carRepository.deleteById(carId);
            return true;
        }
        return false;
    }

    @Override
    public Optional<CarDTO> patchCarById(UUID carId, CarDTO carDTO) {
        AtomicReference<Optional<CarDTO>> atomicReference = new AtomicReference<>();
        carRepository.findById(carId).ifPresentOrElse(foundCar -> {
            if (carDTO.getBrand() != null){
                foundCar.setBrand(carDTO.getBrand());
            }
            if (carDTO.getModel() != null){
                foundCar.setModel(carDTO.getModel());
            }
            if (carDTO.getColor() != null){
                foundCar.setColor(carDTO.getColor());
            }
            if (carDTO.getRegistrationNumber() != null){
                foundCar.setRegistrationNumber(carDTO.getRegistrationNumber());
            }
            if (carDTO.getProductionYear() != null){
                foundCar.setProductionYear(carDTO.getProductionYear());
            }
            if (carDTO.getMileage() != null){
                foundCar.setMileage(carDTO.getMileage());
            }
            if (carDTO.getWheelState() != null){
                foundCar.setWheelState(carDTO.getWheelState());
            }
            if (carDTO.getImage() != null){
                foundCar.setImage(carDTO.getImage());
            }
            atomicReference.set(Optional.of(carMapper.carToCarDTO(carRepository.save(foundCar))));
        }, () -> {
            atomicReference.set(Optional.empty());
        });
        return atomicReference.get();
    }
}