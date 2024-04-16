package com.example.pawel.mappers;

import com.example.pawel.entities.User;
import com.example.pawel.model.UserDTO;
import org.mapstruct.Mapper;

import java.sql.Driver;

@Mapper
public interface UserMapper {
     public User userDTOToUser(UserDTO userDTO);
     public UserDTO userToUserDTO(User user);}
