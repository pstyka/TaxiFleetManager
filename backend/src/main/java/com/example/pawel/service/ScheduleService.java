package com.example.pawel.service;

import com.example.pawel.entities.Schedule;
import com.example.pawel.model.ScheduleDTO;

import java.util.List;

public interface ScheduleService {
    List<ScheduleDTO> getSchedule();

    Schedule saveNewSchedule(ScheduleDTO scheduleDTO);
}
