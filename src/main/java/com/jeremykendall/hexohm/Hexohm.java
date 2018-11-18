package com.jeremykendall.hexohm;

import com.jeremykendall.electricity.OhmsLaw;
import com.jeremykendall.electricity.Resistance;
import com.jeremykendall.electricity.Voltage;
import com.jeremykendall.electricity.Wattage;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.LinkedHashMap;
import java.util.Map;

@RequiredArgsConstructor
public class Hexohm {

    private static final Map<Integer, Voltage> OUTPUT_VOLTAGE = new LinkedHashMap<Integer, Voltage>() {{
        put(0, Voltage.of(3.27));
        put(10, Voltage.of(3.38));
        put(20, Voltage.of(3.53));
        put(30, Voltage.of(3.72));
        put(40, Voltage.of(3.9));
        put(50, Voltage.of(4.16));
        put(60, Voltage.of(4.42));
        put(70, Voltage.of(4.79));
        put(80, Voltage.of(5.14));
        put(90, Voltage.of(5.54));
        put(100, Voltage.of(6.0));
    }};

    private static final Wattage MAX_WATTAGE = Wattage.of(180.0);

    private static final int SCALE = 0;

    @NonNull
    @Getter
    private final Resistance ohms;

    public Wattage getWattage(int potentiometer) {

        validatePotentiometer(potentiometer);

        Wattage wattage = OhmsLaw.getWattage(getVoltage(potentiometer), ohms, SCALE);

        return wattage.isGreaterThan(MAX_WATTAGE) ? MAX_WATTAGE: wattage;
    }

    private void validatePotentiometer(int potentiometer) {
        if (!OUTPUT_VOLTAGE.containsKey(potentiometer)) {
            throw new IllegalArgumentException("potentiometer setting must be one of " +
                    OUTPUT_VOLTAGE.keySet().toString());
        }
    }

    private Voltage getVoltage(int potentiometer) {
        return OUTPUT_VOLTAGE.get(potentiometer);
    }
}
