package com.example.pawel.controller;

import com.example.pawel.config.JwtService;
import com.example.pawel.model.AvailabilityDTO;
import com.example.pawel.service.AvailabilityService;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class AvailabilityController {

    private static final String AVAILABILITY_PATH = "/api/v1/availability";
    private static final String AVAILABILITY_PATH_ID = AVAILABILITY_PATH + "/{availabilityId}";
    private final AvailabilityService availabilityService;
    private final JwtService jwtService;

    @PostMapping("/api/v1/availability")
    public ResponseEntity<AvailabilityDTO> postAvailability(
            @RequestHeader("Authorization") String authHeader,
            @Valid @RequestBody AvailabilityDTO availabilityDTO) {
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }

        String token = authHeader.substring(7);
        try {
            UUID userId = jwtService.getUserIdFromToken(token);
            availabilityDTO.setUserId(userId);
            AvailabilityDTO savedAvailability = availabilityService.saveNewAvailability(availabilityDTO);
            HttpHeaders headers = new HttpHeaders();
            headers.add("Location", "/api/v1/availability/" + savedAvailability.getId());
            return new ResponseEntity<>(savedAvailability, headers, HttpStatus.CREATED);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
    @GetMapping(AVAILABILITY_PATH)
    public List<AvailabilityDTO> getAvailability() {
        return availabilityService.getAvailability();
    }



}
