package com.hours.calculator;

import com.hours.calculator.dto.RequestObj;
import com.hours.calculator.model.Cycle;
import com.hours.calculator.model.LoginTime;
import com.hours.calculator.model.WorkingHours;
import com.hours.calculator.service.HoursService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class HoursCalculatorApplicationTests {

    @Autowired
    private HoursService hoursService;

    @Test
    void testCalculateLogoutTime() {
        LoginTime loginTime = LoginTime.builder()
                .loginHour(10)
                .loginMin(0)
                .cycle(Cycle.AM)
                .build();
        WorkingHours hours = WorkingHours.builder()
                .hours(9)
                .mins(0)
                .build();
        RequestObj obj = RequestObj.builder()
                .workingHours(hours)
                .loginTime(loginTime)
                .build();

        hoursService.calculateLogoutTime(obj);
    }

}
