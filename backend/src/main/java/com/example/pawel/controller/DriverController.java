package com.example.pawel.controller;

import com.example.pawel.model.DriverDTO;
import com.example.pawel.service.DriverService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@Slf4j
public class DriverController {

    private static final String DRIVER_PATH = "/api/v1/driver";
    private static final String DRIVER_PATH_ID = DRIVER_PATH + "/{driverId}";
    private final DriverService driverService;

    @GetMapping(value = DRIVER_PATH)
    public List<DriverDTO> getDrivers(){
        return driverService.getDrivers();
    }
    @GetMapping(value = DRIVER_PATH_ID)
    public DriverDTO getDriverById(UUID driverId){
        return null;
    }
    @PostMapping(value = DRIVER_PATH)
    public ResponseEntity addDriver(DriverDTO driverDTO){
        return null;
    }
    @PutMapping(value = DRIVER_PATH_ID)
    public ResponseEntity updateDriver(UUID driverId, DriverDTO driverDTO){
        return null;
    }
    @DeleteMapping(value = DRIVER_PATH_ID)
    public ResponseEntity deleteDriver(UUID driverId){
        return null;
    }

}
