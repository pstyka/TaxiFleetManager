package com.example.pawel.controller;

import com.example.pawel.auth.AuthenticationRequest;
import com.example.pawel.auth.AuthenticationResponse;
import com.example.pawel.auth.RegistrationRequest;
import com.example.pawel.entities.User;
import com.example.pawel.service.AuthenticationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
public class AuthenticationController {

    private final String AUTH_PATH = "/api/v1/auth";
    private final AuthenticationService authenticationService;

    @PostMapping(AUTH_PATH + "/register")
    public ResponseEntity<?> register(
            @RequestBody @Valid RegistrationRequest request){
        return ResponseEntity.ok(authenticationService.register(request));
    }
    @PostMapping(AUTH_PATH + "/login")
    public ResponseEntity<AuthenticationResponse> login(
            @RequestBody AuthenticationRequest request) {
        return ResponseEntity.ok(authenticationService.authenticate(request));
    }

}
