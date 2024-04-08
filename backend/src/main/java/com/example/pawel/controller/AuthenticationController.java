package com.example.pawel.controller;

import com.example.pawel.auth.AuthenticationResponse;
import com.example.pawel.entities.User;
import com.example.pawel.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AuthenticationController {

    private static final String AUTH_PATH = "/api/v1/auth";
    private final AuthenticationService authenticationService;

    @PostMapping(AUTH_PATH + "/register")
    public ResponseEntity<AuthenticationResponse> register(
            @RequestBody User request) {
        return ResponseEntity.ok(authenticationService.register(request));
    }
    @PostMapping(AUTH_PATH + "/login")
    public ResponseEntity<AuthenticationResponse> login(
            @RequestBody User request) {
        return ResponseEntity.ok(authenticationService.authenticate(request));
    }

}
