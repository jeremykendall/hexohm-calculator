package com.jeremykendall.electricity;

import lombok.Value;

import java.math.BigDecimal;

@Value(staticConstructor = "of")
public class Resistance {
    private Double ohms;
}
