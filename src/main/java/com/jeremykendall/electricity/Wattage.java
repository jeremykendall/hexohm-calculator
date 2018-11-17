package com.jeremykendall.electricity;

import lombok.Value;

@Value(staticConstructor = "of")
public class Wattage {
    private Double watts;

    public boolean isGreaterThan(Wattage wattage) {
        return watts > wattage.getWatts();
    }
}
