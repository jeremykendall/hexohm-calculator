package com.jeremykendall.hexohm

import com.jeremykendall.electricity.Resistance
import com.jeremykendall.electricity.Voltage
import com.jeremykendall.electricity.Wattage
import spock.lang.Specification
import spock.lang.Unroll

@Unroll
class HexohmSpec extends Specification {

    def "it should return correct voltage for each potentiometer setting"() {
        given:
        Hexohm hexohm = new Hexohm(Resistance.of(0.22), potentiometer)

        expect:
        hexohm.getVoltage() == Voltage.of(voltage)

        where:
        potentiometer | voltage
        0             | 3.27
        10            | 3.38
    }

    def "it should calculate wattage correctly"() {
        given:
        Hexohm hexohm = new Hexohm(Resistance.of(ohms), potentiometer)

        expect:
        hexohm.getWattage() == Wattage.of(wattage)

        where:
        potentiometer | ohms | wattage
        50            | 0.2  | 87
        100           | 0.2  | 180

        30            | 0.25 | 55

        0             | 0.3  | 36
        10            | 0.3  | 38
        20            | 0.3  | 42
        30            | 0.3  | 46
        40            | 0.3  | 51
        50            | 0.3  | 58
        60            | 0.3  | 65
        70            | 0.3  | 76
        80            | 0.3  | 88
        90            | 0.3  | 102
        100           | 0.3  | 120

        100           | 0.5  | 72
    }

    def "it should calculate wattage correctly when pot setting provided"() {
        given:
        Hexohm hexohm = new Hexohm(Resistance.of(ohms))

        expect:
        hexohm.getWattage(potentiometer) == Wattage.of(wattage)

        where:
        potentiometer | ohms | wattage
        50            | 0.2  | 87
        100           | 0.2  | 180

        30            | 0.25 | 55

        0             | 0.3  | 36
        10            | 0.3  | 38
        20            | 0.3  | 42
        30            | 0.3  | 46
        40            | 0.3  | 51
        50            | 0.3  | 58
        60            | 0.3  | 65
        70            | 0.3  | 76
        80            | 0.3  | 88
        90            | 0.3  | 102
        100           | 0.3  | 120

        100           | 0.5  | 72
    }

    def "wattage should never exceed 180 watts"() {
        given:
        def hexohm = new Hexohm(Resistance.of(0.1), 100)

        when:
        hexohm.potentiometer = 60

        then:
        hexohm.wattage == Wattage.of(180.0)
    }
}
