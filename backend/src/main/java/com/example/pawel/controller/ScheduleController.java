package com.example.pawel.controller;

import com.example.pawel.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ScheduleController {

    private final ScheduleService scheduleService;

    private final String SCHEDULE_PATH = "/api/v1/schedule";

    @GetMapping(SCHEDULE_PATH)
    public ResponseEntity getSchedule() {
        return ResponseEntity.ok(scheduleService.getSchedule());
    }

}
