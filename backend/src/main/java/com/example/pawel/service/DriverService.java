package com.example.pawel.service;

import com.example.pawel.model.UserDTO;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface DriverService {
    List<UserDTO> getDrivers();
    
    UserDTO getDriverById(UUID driverId);

    UserDTO saveNewDriver(UserDTO userDTO);

    Optional<UserDTO> patchDriver(UUID driverId, UserDTO userDTO);
}
