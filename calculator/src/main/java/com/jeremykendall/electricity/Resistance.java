package com.jeremykendall.electricity;

import lombok.Value;

@Value(staticConstructor = "of")
public class Resistance {
    double ohms;
    @Override
    public String toString() {
        return ohms + "Ω";
    }
}
