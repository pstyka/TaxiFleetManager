package com.example.pawel.mappers;

import com.example.pawel.entities.Availability;
import com.example.pawel.entities.User;
import com.example.pawel.model.AvailabilityDTO;
import com.example.pawel.repository.UserRepository;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Mapper(componentModel = "spring")
public abstract class AvailabilityMapper {

    @Autowired
    private UserRepository userRepository;

    @Mapping(source = "user.id", target = "userId")
    public abstract AvailabilityDTO availabilityToAvailabilityDTO(Availability availability);

    @Mapping(source = "userId", target = "user", qualifiedByName = "userFromId")
    public abstract Availability availabilityDTOToAvailability(AvailabilityDTO availabilityDTO);

    @Named("userFromId")
    protected User userFromId(UUID userId) {
        return userRepository.findById(userId).orElse(null);
    }
}
