package com.jeremykendall.electricity;

import java.math.BigDecimal;

public class OhmsLaw {

    public static Wattage getWattage(Voltage voltage, Resistance resistance, int scale) {
        BigDecimal watts = BigDecimal.valueOf(voltage.getVolts())
                .pow(2)
                .divide(BigDecimal.valueOf(resistance.getOhms()), scale, BigDecimal.ROUND_HALF_EVEN);

        return Wattage.of(watts.doubleValue());
    }
}
