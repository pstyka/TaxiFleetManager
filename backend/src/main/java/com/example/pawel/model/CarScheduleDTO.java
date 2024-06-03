package com.example.pawel.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarScheduleDTO {
    private String registrationNumber;
    private String brand;
    private String model;
    private List<ScheduleDetailsDTO> scheduleDTOS;
}
