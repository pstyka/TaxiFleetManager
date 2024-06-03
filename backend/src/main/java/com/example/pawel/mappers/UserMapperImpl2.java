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
        if(userDTO == null) {
            return null;
        }
        return User.builder()
                .id(userDTO.getId())
                .firstName(userDTO.getFirstName())
                .lastName(userDTO.getLastName())
                .phoneNumber(userDTO.getPhoneNumber())
                .role(userDTO.getRole())
                .imgUrl(userDTO.getImgUrl())
                .build();

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
                .phoneNumber(user.getPhoneNumber())
                .role(user.getRole())
                .imgUrl(user.getImgUrl())
                .build();
    }
}
