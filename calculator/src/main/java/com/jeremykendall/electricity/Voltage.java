package com.jeremykendall.electricity;

import lombok.Value;

@Value(staticConstructor = "of")
public class Voltage {
    double volts;

    @Override
    public String toString() {
        return volts + "V";
    }
}
