package com.hours.calculator.dto;

import com.hours.calculator.model.LoginTime;
import com.hours.calculator.model.WorkingHours;
import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class RequestObj {
    private LoginTime loginTime;
    private WorkingHours workingHours;

}
