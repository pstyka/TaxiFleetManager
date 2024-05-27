package com.example.pawel.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.List;
import java.util.UUID;

@Entity
@NoArgsConstructor
@Builder
@AllArgsConstructor
@Data
@Table(name = "car")
public class Car {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @JdbcTypeCode(SqlTypes.CHAR)
    @Column(length = 36, columnDefinition = "varchar(36)", updatable = false, nullable = false)

    private UUID id;
    @Column(name = "brand")
    private String brand;
    @Column(name = "model")
    private String model;
    @Column(name = "color")
    private String color;
    @Column(name = "registration_number")
    private String registrationNumber;
    @Column(name = "production_year")
    private String productionYear;
    @Column(name = "mileage")
    private Integer mileage;
    @Column(name = "wheel_state")
    @Enumerated(value = EnumType.STRING)
    private WheelState wheelState;
    @Column(name = "image_url")
    private String imageUrl;


    @OneToMany(mappedBy = "car", cascade = CascadeType.ALL)
    private List<Schedule> schedules;
    @OneToMany(mappedBy = "car", cascade = CascadeType.ALL)
    private List<DailyReport> dailyReports;
}
