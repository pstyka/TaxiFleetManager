package com.example.pawel.controller;

import com.example.pawel.service.AvailabilityService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AvailabilityController {

    private static final String AVAILABILITY_PATH = "/api/v1/availability";
    private static final String AVAILABILITY_PATH_ID = AVAILABILITY_PATH + "/{availabilityId}";
    private final AvailabilityService availabilityService;

    @PostMapping(AVAILABILITY_PATH)
    public ResponseEntity postAvailability() {
        return null;
    }
    @GetMapping(AVAILABILITY_PATH)
    public ResponseEntity getAvailability() {
        return null;
    }
    @GetMapping(AVAILABILITY_PATH_ID)
    public ResponseEntity getAvailabilityById() {
        return null;
    }


}
