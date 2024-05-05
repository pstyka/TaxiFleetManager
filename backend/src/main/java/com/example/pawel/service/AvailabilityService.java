package com.example.pawel.service;

import com.example.pawel.model.AvailabilityDTO;

import java.util.List;

public interface AvailabilityService {


    List<AvailabilityDTO> getAvailability();

    AvailabilityDTO saveNewAvailability(AvailabilityDTO availabilityDTO);
}
