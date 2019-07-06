package com.jeremykendall.hexohm

import com.jeremykendall.electricity.Resistance
import com.jeremykendall.electricity.Wattage
import spock.lang.Specification
import spock.lang.Unroll

@Unroll
class HexohmSpec extends Specification {

    def "it should calculate power output correctly"() {
        given:
        Hexohm hexohm = new Hexohm(Resistance.of(ohms))

        expect:
        hexohm.getPowerOutput(potentiometerSetting) == Wattage.of(wattage)

        where:
        potentiometerSetting | ohms | wattage
        50                   | 0.2  | 87
        100                  | 0.2  | 180

        30                   | 0.25 | 55

        0                    | 0.3  | 36
        10                   | 0.3  | 38
        20                   | 0.3  | 42
        30                   | 0.3  | 46
        40                   | 0.3  | 51
        50                   | 0.3  | 58
        60                   | 0.3  | 65
        70                   | 0.3  | 76
        80                   | 0.3  | 88
        90                   | 0.3  | 102
        100                  | 0.3  | 120

        100                  | 0.5  | 72
    }

    def "wattage should never exceed 180 watts"() {
        given:
        def hexohm = new Hexohm(Resistance.of(0.1))

        when:
        Wattage wattage = hexohm.getPowerOutput(60)

        then:
        wattage == Wattage.of(180.0)
    }

    def "should throw exception if potentiometer setting isn't 0 - 100 (counted by 10s)"() {
        given:
        Hexohm hexohm = new Hexohm(Resistance.of(0.22))

        when:
        hexohm.getPowerOutput(25)

        then:
        IllegalArgumentException e = thrown()
        e.getMessage() == "potentiometerSetting setting must be one of [0, 10, 20, 30, 40, 50, 60, 70, 80, 90, 100]"
    }
}
