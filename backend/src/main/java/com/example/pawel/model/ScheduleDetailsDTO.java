package com.example.pawel.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ScheduleDetailsDTO {
    private String firstName;
    private String lastName;
    private String day;
    private String date;
    private String shift;
}
