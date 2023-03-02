package com.jeremykendall.electricity;

import lombok.Value;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Value(staticConstructor = "of")
public class Wattage {
    double watts;

    public static Wattage calculate(Voltage voltage, Resistance resistance, int scale) {
        // Voltage^2/Resistance
        BigDecimal bigDecimal = BigDecimal.valueOf(voltage.getVolts())
                .pow(2)
                .divide(BigDecimal.valueOf(resistance.getOhms()), scale, RoundingMode.HALF_EVEN);

        return Wattage.of(bigDecimal.doubleValue());
    }

    @Override
    public String toString() {
        return watts + "W";
    }
}
