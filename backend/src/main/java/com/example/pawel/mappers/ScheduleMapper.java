package com.example.pawel.mappers;

import com.example.pawel.entities.Car;
import com.example.pawel.entities.Schedule;
import com.example.pawel.entities.User;
import com.example.pawel.model.ScheduleDTO;
import com.example.pawel.repository.CarRepository;
import com.example.pawel.repository.UserRepository;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.UUID;

@Mapper
public interface ScheduleMapper {

    @Mapping(source = "userId", target = "user", qualifiedByName = "userIdToUser")
    @Mapping(source = "carId", target = "car", qualifiedByName = "carIdToCar")
    @Mapping(target = "id", ignore = true)
    Schedule scheduleDTOToSchedule(ScheduleDTO dto,
                        @Context UserRepository userRepository,
                        @Context CarRepository carRepository);
    @Named("userIdToUser")
    default User userIdToUser(UUID userId, @Context UserRepository userRepository) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("User not found with id: " + userId));
    }
    @Named("carIdToCar")
    default Car carIdToCar(UUID carId, @Context CarRepository carRepository) {
        return carRepository.findById(carId)
                .orElseThrow(() -> new IllegalArgumentException("Car not found with id: " + carId));
    }


}
