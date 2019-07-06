package com.jeremykendall.electricity;

import lombok.ToString;
import lombok.Value;

@Value(staticConstructor = "of")
@ToString
public class Wattage {
    private Double watts;

    public boolean isGreaterThan(Wattage wattage) {
        return watts > wattage.getWatts();
    }
}
