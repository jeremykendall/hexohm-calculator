package com.jeremykendall.hexohm

import com.jeremykendall.electricity.Amperage
import com.jeremykendall.electricity.Resistance
import com.jeremykendall.electricity.Wattage
import spock.lang.Specification
import spock.lang.Unroll

import static com.jeremykendall.hexohm.Hexohm.Potentiometer.EIGHTY
import static com.jeremykendall.hexohm.Hexohm.Potentiometer.FIFTY
import static com.jeremykendall.hexohm.Hexohm.Potentiometer.FORTY
import static com.jeremykendall.hexohm.Hexohm.Potentiometer.NINETY
import static com.jeremykendall.hexohm.Hexohm.Potentiometer.ONE_HUNDRED
import static com.jeremykendall.hexohm.Hexohm.Potentiometer.SEVENTY
import static com.jeremykendall.hexohm.Hexohm.Potentiometer.SIXTY
import static com.jeremykendall.hexohm.Hexohm.Potentiometer.TEN
import static com.jeremykendall.hexohm.Hexohm.Potentiometer.THIRTY
import static com.jeremykendall.hexohm.Hexohm.Potentiometer.TWENTY
import static com.jeremykendall.hexohm.Hexohm.Potentiometer.ZERO


@Unroll
class HexohmSpec extends Specification {

    def "it should calculate power output correctly"() {
        given:
        Hexohm hexohm = new Hexohm(Resistance.of(ohms), potentiometer)

        expect:
        hexohm.getPowerOutput() == Wattage.of(wattage)

        where:
        potentiometer | ohms | wattage
        FIFTY         | 0.2  | 86.53
        ONE_HUNDRED   | 0.2  | 180.0
        THIRTY        | 0.25 | 55.35
        ZERO          | 0.3  | 35.64
        TEN           | 0.3  | 38.08
        TWENTY        | 0.3  | 41.54
        THIRTY        | 0.3  | 46.13
        FORTY         | 0.3  | 50.7
        FIFTY         | 0.3  | 57.69
        SIXTY         | 0.3  | 65.12
        SEVENTY       | 0.3  | 76.48
        EIGHTY        | 0.3  | 88.07
        NINETY        | 0.3  | 102.31
        ONE_HUNDRED   | 0.3  | 120.0
        ONE_HUNDRED   | 0.5  | 72.0
    }

    def "it should calculate current draw correctly"() {
        given:
        Hexohm hexohm = new Hexohm(Resistance.of(ohms), potentiometer)

        expect:
        hexohm.getCurrent() == Amperage.of(amps)

        where:
        potentiometer | ohms | amps
        FIFTY         | 0.2  | 20.8
        ONE_HUNDRED   | 0.2  | 30.0
        THIRTY        | 0.25 | 14.88
        ZERO          | 0.3  | 10.9
        TEN           | 0.3  | 11.27
        TWENTY        | 0.3  | 11.77
        THIRTY        | 0.3  | 12.4
        FORTY         | 0.3  | 13.0
        FIFTY         | 0.3  | 13.87
        SIXTY         | 0.3  | 14.73
        SEVENTY       | 0.3  | 15.97
        EIGHTY        | 0.3  | 17.13
        NINETY        | 0.3  | 18.47
        ONE_HUNDRED   | 0.3  | 20.0
        ONE_HUNDRED   | 0.5  | 12.0
    }

    def "wattage should never exceed 180 watts"() {
        given:
        def hexohm = new Hexohm(Resistance.of(0.1), ONE_HUNDRED)

        when:
        Wattage wattage = hexohm.getPowerOutput()

        then:
        wattage == Wattage.of(180.0)
    }
}
