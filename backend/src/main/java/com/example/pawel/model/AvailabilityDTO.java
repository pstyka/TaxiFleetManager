package com.example.pawel.model;

import com.example.pawel.entities.Shift;
import com.example.pawel.entities.User;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.UUID;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AvailabilityDTO {

    private UUID id;
    private UUID userId;
    @NotNull
    private Integer week;
    @NotNull
    private Shift monday;
    @NotNull
    private Shift tuesday;
    @NotNull
    private Shift wednesday;
    @NotNull
    private Shift thursday;
    @NotNull
    private Shift friday;
    @NotNull
    private Shift saturday;
    @NotNull
    private Shift sunday;
}
