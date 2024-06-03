package com.example.pawel.repository;

import com.example.pawel.entities.Car;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface CarRepository extends JpaRepository<Car, UUID> {
    List<Car> findAllByBrandIsLikeIgnoreCase(String brand);

    List<Car> findAllByModelIsLikeIgnoreCase(String model);

    List<Car> findAllByRegistrationNumberIsLikeIgnoreCase(String registrationNumber);

    List<Car> findAllByBrandIsLikeIgnoreCaseAndModelIsLikeIgnoreCase(String brand, String model);

    List<Car> findAllByBrandIsLikeIgnoreCaseAndRegistrationNumberIsLikeIgnoreCase(String brand, String registrationNumber);

    List<Car> findAllByModelIsLikeIgnoreCaseAndRegistrationNumberIsLikeIgnoreCase(String model, String registrationNumber);

    List<Car> findAllByBrandIsLikeIgnoreCaseAndModelIsLikeIgnoreCaseAndRegistrationNumberIsLikeIgnoreCase(String brand, String model, String registrationNumber);
}
