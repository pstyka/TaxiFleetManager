package com.example.pawel.service;

import com.example.pawel.model.AvailabilityDTO;
import com.example.pawel.repository.AvailabilityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
@RequiredArgsConstructor
public class AvailabilityServiceImpl implements AvailabilityService {

    private final AvailabilityRepository availabilityRepository;
    @Override
    public AvailabilityDTO saveAvailability() {
        return null;
    }

    @Override
    public void getAvailability() {

    }
}
