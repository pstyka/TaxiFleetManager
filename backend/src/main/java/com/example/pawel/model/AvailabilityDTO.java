package com.example.pawel.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AvailabilityDTO {
    private UUID id;
    private UUID userId;
    private Integer week;
    private List<DayAvailabilityDTO> days;

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class DayAvailabilityDTO {
        private String day;
        private String shift;
        private LocalDate date;
    }
}
