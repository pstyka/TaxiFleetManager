package com.example.pawel.mappers;

import com.example.pawel.entities.Schedule;
import com.example.pawel.entities.User;
import com.example.pawel.model.ScheduleDTO;
import com.example.pawel.model.ScheduleDetailsDTO;
import com.example.pawel.repository.UserRepository;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.UUID;

@Mapper
public interface ScheduleDetailsMapper {

    @Mapping(target = "firstName", expression = "java(userIdToFirstName(schedule.getUser().getId(), userRepository))")
    @Mapping(target = "lastName", expression = "java(userIdToLastName(schedule.getUser().getId(), userRepository))")
    ScheduleDetailsDTO scheduleToScheduleDetailsDTO(Schedule schedule, @Context UserRepository userRepository);

    default String userIdToFirstName(UUID userId, UserRepository userRepository) {
        User user = userRepository.findById(userId).orElse(null);
        return user != null ? user.getFirstName() : "Unknown User";
    }

    default String userIdToLastName(UUID userId, UserRepository userRepository) {
        return userRepository.findById(userId)
                .map(User::getLastName)
                .orElse("Unknown User");
    }
}
