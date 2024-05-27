package com.example.pawel.model;

import com.example.pawel.entities.WheelState;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarDTO {

    private UUID id;
    @NotNull
    private String brand;
    @NotNull
    private String model;
    @NotNull
    private String color;
    @NotNull
    private String registrationNumber;
    @NotNull
    private String productionYear;
    @NotNull
    private Integer mileage;
    @NotNull
    private WheelState wheelState;
    private String imageUrl;

}
