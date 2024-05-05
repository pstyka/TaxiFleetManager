package com.example.pawel.mappers;

import com.example.pawel.entities.Availability;
import com.example.pawel.entities.User;
import com.example.pawel.model.AvailabilityDTO;
import com.example.pawel.repository.UserRepository;
import org.mapstruct.*;

import java.util.UUID;

@Mapper(componentModel = "spring")
public interface AvailabilityMapper {

    @Mapping(source = "userId", target = "user", qualifiedByName = "userIdToUser")
    Availability availabilityDTOToAvailability(AvailabilityDTO availabilityDTO, @Context UserRepository userRepository);

    @Mapping(source = "user.id", target = "userId")
    AvailabilityDTO availabilityToAvailabilityDTO(Availability availability);

    @Named("userIdToUser")
    default User userIdToUser(UUID userId, @Context UserRepository userRepository) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("User with id " + userId + " not found"));
    }
}
