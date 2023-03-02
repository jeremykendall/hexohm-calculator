package com.jeremykendall.hexohm;

import com.jeremykendall.electricity.Amperage;
import com.jeremykendall.electricity.Resistance;
import com.jeremykendall.electricity.Voltage;
import com.jeremykendall.electricity.Wattage;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

@ToString
final public class Hexohm {

    private static final Wattage MAX_WATTAGE = Wattage.of(180.0);

    @Getter
    @NonNull
    private final Resistance coilResistance;

    @Getter
    @NonNull
    private final Potentiometer potentiometer;

    private final double maxVoltage;

    public Hexohm(Resistance coilResistance, Potentiometer potentiometer) {
        this.coilResistance = coilResistance;
        this.potentiometer = potentiometer;
        this.maxVoltage = Math.sqrt(coilResistance.getOhms() * MAX_WATTAGE.getWatts());
    }

    public Wattage getPowerOutput() {
        return Wattage.calculate(getAttenuatedVoltage(potentiometer), coilResistance, 2);
    }

    public Amperage getCurrent() {
        return Amperage.calculate(getAttenuatedVoltage(potentiometer), coilResistance, 2);
    }

    private Voltage getAttenuatedVoltage(Potentiometer potentiometer) {
        return Voltage.of(Math.min(potentiometer.voltage, this.maxVoltage));
    }

    public enum Potentiometer {
        ZERO(0, 3.27),
        TEN(10, 3.38),
        TWENTY(20, 3.53),
        THIRTY(30, 3.72),
        FORTY(40, 3.9),
        FIFTY(50, 4.16),
        SIXTY(60, 4.42),
        SEVENTY(70, 4.79),
        EIGHTY(80, 5.14),
        NINETY(90, 5.54),
        ONE_HUNDRED(100, 6.0);

        private final int setting;

        private final double voltage;

        Potentiometer(int setting, double voltage) {
            this.setting = setting;
            this.voltage = voltage;
        }

        @Override
        public String toString() {
            return String.valueOf(setting);
        }
    }
}
