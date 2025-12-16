package com.hours.calculator.model;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class LogoutTime {

    private int logoutHour;
    private int logoutMin;
    private Cycle cycle;
}
