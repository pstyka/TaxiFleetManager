package com.example.pawel.repository;

import com.example.pawel.entities.Availability;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AvailabilityRepository extends JpaRepository<Availability, UUID>{
}
