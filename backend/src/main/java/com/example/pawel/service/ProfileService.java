package com.example.pawel.service;

import com.example.pawel.mappers.UserMapper;
import com.example.pawel.model.UserDTO;
import com.example.pawel.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProfileService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserDTO getProfile() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        return userMapper
                .userToUserDTO(userRepository
                        .findByUsername(username)
                        .orElse(null));
    }
}
