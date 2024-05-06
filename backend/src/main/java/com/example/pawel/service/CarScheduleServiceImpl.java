package com.example.pawel.service;

import com.example.pawel.entities.Car;
import com.example.pawel.mappers.CarScheduleMapper;
import com.example.pawel.mappers.ScheduleDetailsMapper;
import com.example.pawel.model.CarScheduleDTO;
import com.example.pawel.model.ScheduleDetailsDTO;
import com.example.pawel.repository.CarRepository;
import com.example.pawel.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CarScheduleServiceImpl implements CarScheduleService {
    private final CarRepository carRepository;
    private final UserRepository userRepository;
    private final CarScheduleMapper carScheduleMapper;
    private final ScheduleDetailsMapper scheduleDetailsMapper;

    public List<CarScheduleDTO> getAllCarSchedules() {
        return carRepository.findAll().stream()
                .map(car -> {
                    List<ScheduleDetailsDTO> scheduleDetailsDTOs = car.getSchedules().stream()
                            .map(schedule -> scheduleDetailsMapper.scheduleToScheduleDetailsDTO(schedule, userRepository))
                            .collect(Collectors.toList());
                    return new CarScheduleDTO(car.getRegistrationNumber(), car.getBrand(), car.getModel(), scheduleDetailsDTOs);
                })
                .collect(Collectors.toList());
    }
}
