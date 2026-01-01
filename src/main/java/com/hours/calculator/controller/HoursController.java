package com.hours.calculator.controller;

import com.hours.calculator.dto.RequestObj;
import com.hours.calculator.service.HoursService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/hours")
@CrossOrigin(origins = "http://localhost:5173")
public class HoursController {

    private final HoursService hoursService;

    public HoursController(HoursService service){
        this.hoursService = service;
    }

    @PostMapping
    public ResponseEntity<Map<String, String>> getLogoutTime(@RequestBody RequestObj obj){
        return hoursService.calculateLogoutTime(obj);
    }

}
