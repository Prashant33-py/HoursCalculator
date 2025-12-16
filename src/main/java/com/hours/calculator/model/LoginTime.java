package com.hours.calculator.model;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class LoginTime {

    private int loginHour;
    private int loginMin;
    private Cycle cycle;
}
