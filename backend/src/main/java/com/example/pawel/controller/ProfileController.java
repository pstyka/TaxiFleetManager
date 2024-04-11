package com.example.pawel.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ProfileController {

    private static final String PROFILE_PATH = "/api/v1/profile";

    @GetMapping(value = PROFILE_PATH)
    public ResponseEntity getProfile() {
        return null;
    }
}
