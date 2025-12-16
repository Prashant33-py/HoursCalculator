package com.hours.calculator.model;

import lombok.*;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class WorkingHours {

    private int hours;
    private int mins;

}
