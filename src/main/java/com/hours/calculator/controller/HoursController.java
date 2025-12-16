package com.hours.calculator.controller;

import com.hours.calculator.dto.RequestObj;
import com.hours.calculator.model.LogoutTime;
import com.hours.calculator.service.HoursService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/hours")
public class HoursController {

    private final HoursService hoursService;

    public HoursController(HoursService service){
        this.hoursService = service;
    }

    @GetMapping("/{loginTime}")
    public ResponseEntity<LogoutTime> getLogoutTime(@RequestBody RequestObj obj){
        return hoursService.calculateLogoutTime(obj);
    }

}
