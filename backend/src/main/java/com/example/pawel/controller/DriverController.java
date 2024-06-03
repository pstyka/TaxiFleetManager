package com.example.pawel.controller;

import com.example.pawel.model.UserDTO;
import com.example.pawel.service.DriverService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@Slf4j
@Tag(name="Driver")
public class DriverController {
    private static final String DRIVER_PATH = "/api/v1/driver";
    private static final String DRIVER_PATH_ID = DRIVER_PATH + "/{driverId}";
    private final DriverService driverService;

    @GetMapping(value = DRIVER_PATH)
    public List<UserDTO> getDrivers(@RequestParam(required = false) String firstName,
                                    @RequestParam(required = false) String lastName) {
        return driverService.getDrivers(firstName, lastName);
    }



    @GetMapping(value = DRIVER_PATH_ID)
    public UserDTO getDriverById(@PathVariable("driverId") UUID driverId){
        return driverService.getDriverById(driverId);
    }
    @PostMapping(value = DRIVER_PATH)
    public ResponseEntity addDriver(@Validated @RequestBody UserDTO userDTO){
        UserDTO savedDriver = driverService.saveNewDriver(userDTO);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Location",
                DRIVER_PATH + "/" + savedDriver.getId().toString());
        return null;
    }
    @PutMapping(value = DRIVER_PATH_ID)
    public ResponseEntity updateDriver(UUID driverId, UserDTO userDTO){
        return null;
    }
    @DeleteMapping(value = DRIVER_PATH_ID)
    public ResponseEntity deleteDriver(UUID driverId){
        return null;
    }
}
