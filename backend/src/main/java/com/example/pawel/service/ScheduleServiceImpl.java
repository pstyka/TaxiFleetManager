package com.example.pawel.service;

import com.example.pawel.entities.Schedule;
import com.example.pawel.mappers.ScheduleMapper;
import com.example.pawel.model.ScheduleDTO;
import com.example.pawel.repository.CarRepository;
import com.example.pawel.repository.ScheduleRepository;
import com.example.pawel.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ScheduleServiceImpl implements ScheduleService {

    private final ScheduleRepository scheduleRepository;
    private final UserRepository userRepository;
    private final CarRepository carRepository;
    private final ScheduleMapper scheduleMapper;
    @Override
    public List<ScheduleDTO> getSchedule() {
        return null;
    }



    public Schedule saveNewSchedule(ScheduleDTO dto) {
        Schedule schedule = scheduleMapper.scheduleDTOToSchedule(dto, userRepository, carRepository);
        return scheduleRepository.save(schedule);
    }
}
