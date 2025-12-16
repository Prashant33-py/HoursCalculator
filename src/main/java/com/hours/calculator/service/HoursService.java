package com.hours.calculator.service;

import com.hours.calculator.dto.RequestObj;
import com.hours.calculator.model.Cycle;
import com.hours.calculator.model.LoginTime;
import com.hours.calculator.model.LogoutTime;
import com.hours.calculator.model.WorkingHours;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class HoursService {

    public ResponseEntity<LogoutTime> calculateLogoutTime(RequestObj obj) {
        System.out.println(obj);

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

        System.out.println(logoutHours+ ":" +logoutMins+" "+cycle);

        return ResponseEntity.ok().body(LogoutTime.builder().logoutHour(logoutHours).logoutMin(logoutMins).cycle(cycle).build());
    }

}
