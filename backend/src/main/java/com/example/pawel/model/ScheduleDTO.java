package com.example.pawel.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.UUID;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ScheduleDTO {
    private UUID userId;
    private UUID carId;
    private Date date;
    private String day;
    private String shift;
}
