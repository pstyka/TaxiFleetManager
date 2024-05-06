package com.example.pawel.controller;

import com.example.pawel.entities.User;
import com.example.pawel.model.UserDTO;
import com.example.pawel.service.ProfileService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
public class ProfileController {

    private static final String PROFILE_PATH = "/api/v1/profile";
    private final ProfileService profileService;

    @GetMapping(value = PROFILE_PATH)
    public ResponseEntity<UserDTO> getProfile() {

        UserDTO userProfile = profileService.getProfile();

        return ResponseEntity.ok(userProfile);
    }
}
