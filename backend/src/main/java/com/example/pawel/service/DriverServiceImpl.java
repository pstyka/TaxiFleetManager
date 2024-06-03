package com.example.pawel.service;

import com.example.pawel.mappers.UserMapper;
import com.example.pawel.model.UserDTO;
import com.example.pawel.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DriverServiceImpl implements DriverService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;


    public List<UserDTO> getDrivers(String firstName, String lastName) {
        if (firstName != null && lastName != null) {
            return userRepository.findAllByFirstNameIsLikeIgnoreCaseAndLastNameIsLikeIgnoreCase(firstName, lastName).stream()
                    .map(userMapper::userToUserDTO)
                    .collect(Collectors.toList());
        } else if (firstName != null) {
            return userRepository.findAllByFirstNameIsLikeIgnoreCase(firstName).stream()
                    .map(userMapper::userToUserDTO)
                    .collect(Collectors.toList());
        } else if (lastName != null) {
            return userRepository.findAllByLastNameIsLikeIgnoreCase(lastName).stream()
                    .map(userMapper::userToUserDTO)
                    .collect(Collectors.toList());
        } else {
            return userRepository.findAll().stream()
                    .map(userMapper::userToUserDTO)
                    .collect(Collectors.toList());
        }
    }

    @Override
    public UserDTO getDriverById(UUID driverId) {
        return userMapper
                .userToUserDTO(userRepository
                        .findById(driverId).
                        orElse(null));
    }

    @Override
    public UserDTO saveNewDriver(UserDTO userDTO) {
        return userMapper.userToUserDTO(userRepository
                .save(userMapper.userDTOToUser(userDTO)));
    }

    @Override
    public Optional<UserDTO> patchDriver(UUID driverId, UserDTO userDTO) {
        AtomicReference<Optional<UserDTO>> atomicReference = new AtomicReference<>();
        userRepository.findById(driverId).ifPresentOrElse(foundUser -> {
            if(userDTO.getFirstName() != null){
                foundUser.setFirstName(userDTO.getFirstName());
            }
            if(userDTO.getLastName() != null){
                foundUser.setLastName(userDTO.getLastName());
            }
            if(userDTO.getRole() != null){
                foundUser.setRole(userDTO.getRole());
            }
            atomicReference.set(Optional.of(userMapper.userToUserDTO(userRepository.save(foundUser))));
        }, () -> {
            atomicReference.set(Optional.empty());
        });
        return atomicReference.get();
    }


}
