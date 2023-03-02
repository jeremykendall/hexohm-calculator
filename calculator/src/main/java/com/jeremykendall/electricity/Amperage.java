package com.jeremykendall.electricity;

import lombok.Value;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Value(staticConstructor = "of")
public class Amperage {
    double amps;

    public static Amperage calculate(Voltage voltage, Resistance resistance, int scale) {
        // Voltage/Resistance
        double amps = BigDecimal.valueOf(voltage.getVolts())
                .divide(BigDecimal.valueOf(resistance.getOhms()), scale, RoundingMode.HALF_EVEN)
                .doubleValue();

        return Amperage.of(amps);
    }

    @Override
    public String toString() {
        return amps +  "A";
    }
}
