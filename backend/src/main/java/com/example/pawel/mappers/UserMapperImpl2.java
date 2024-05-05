package com.example.pawel.mappers;

import com.example.pawel.entities.User;
import com.example.pawel.model.UserDTO;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Primary
@Component
public class UserMapperImpl2 implements UserMapper {
    @Override
    public User userDTOToUser(UserDTO userDTO) {
        return null;
    }

    @Override
    public UserDTO userToUserDTO(User user) {
        if(user == null) {
            return null;
        }
        return UserDTO.builder()
                .id(user.getId())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .role(user.getRole())
                .build();
    }
}
