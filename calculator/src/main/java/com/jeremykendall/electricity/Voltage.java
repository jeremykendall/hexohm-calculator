package com.jeremykendall.electricity;

import lombok.ToString;
import lombok.Value;

@Value(staticConstructor = "of")
@ToString
public class Voltage {
    private Double volts;
}
