package com.example.pawel.controller;

import com.example.pawel.entities.Schedule;
import com.example.pawel.model.CarScheduleDTO;
import com.example.pawel.model.ScheduleDTO;
import com.example.pawel.service.CarScheduleService;
import com.example.pawel.service.ScheduleService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
@Tag(name="Schedule")
public class ScheduleController {

    private final ScheduleService scheduleService;
    private final CarScheduleService carScheduleService;

    private final String SCHEDULE_PATH = "/api/v1/schedule";

    @GetMapping(SCHEDULE_PATH)
    public List<CarScheduleDTO> getSchedule() {
        return carScheduleService.getAllCarSchedules();

    }

    @PostMapping(SCHEDULE_PATH)
    public ResponseEntity addToSchedule(@Validated @RequestBody ScheduleDTO scheduleDTO){
        Schedule savedSchedule = scheduleService.saveNewSchedule(scheduleDTO);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Location",
                SCHEDULE_PATH + "/" + savedSchedule.getId().toString());
        return new ResponseEntity(headers, HttpStatus.CREATED);
    }

}
