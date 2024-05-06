package com.example.pawel.mappers;

import com.example.pawel.entities.Car;
import com.example.pawel.entities.Schedule;
import com.example.pawel.model.CarScheduleDTO;
import com.example.pawel.model.ScheduleDTO;
import com.example.pawel.model.ScheduleDetailsDTO;
import org.mapstruct.Context;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface CarScheduleMapper {
    default CarScheduleDTO carToCarScheduleDTO(Car car, @Context List<Schedule> schedules) {
        CarScheduleDTO dto = new CarScheduleDTO();
        dto.setRegistrationNumber(car.getRegistrationNumber());
        dto.setBrand(car.getBrand());
        dto.setModel(car.getModel());
        dto.setScheduleDTOS(convertSchedulesToSchedulesDTO(schedules));
        return dto;
    }
    List<ScheduleDetailsDTO> convertSchedulesToSchedulesDTO(List<Schedule> schedules);
}
