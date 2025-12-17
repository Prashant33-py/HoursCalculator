package com.hours.calculator.service;

import com.hours.calculator.dto.RequestObj;
import com.hours.calculator.model.Cycle;
import com.hours.calculator.model.LoginTime;
import com.hours.calculator.model.WorkingHours;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class HoursService {

    public ResponseEntity<String> calculateLogoutTime(RequestObj obj) {
        WorkingHours workingHours = obj.getWorkingHours();
        LoginTime loginTime = obj.getLoginTime();
        int logoutHours = loginTime.getLoginHour();
        int logoutMins = loginTime.getLoginMin();
        Cycle cycle = loginTime.getCycle();
        for  (int i = 0; i < workingHours.getMins(); i++){
            if (logoutMins == 60) {
                logoutMins = 0;
                logoutHours++;
            }
            logoutMins++;
        }
        for  (int i = 0; i <= workingHours.getHours(); i++){
            if (logoutHours > 12) {
                logoutHours = 0;
                cycle = Cycle.PM;
            }
            logoutHours++;
        }
        String formattedMin = (logoutMins < 10) ? "0" + logoutMins : String.valueOf(logoutMins);
        return ResponseEntity.ok().body("Logout Time is: " + logoutHours + ":" + formattedMin + " " + cycle);
    }

}
