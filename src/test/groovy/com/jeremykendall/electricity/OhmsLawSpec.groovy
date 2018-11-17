package com.jeremykendall.electricity

import spock.lang.Specification
import spock.lang.Unroll

@Unroll
class OhmsLawSpec extends Specification {
    def "it should calculate wattage"() {
        expect:
        OhmsLaw.getWattage(Voltage.of(voltage), Resistance.of(resistance), 2) == Wattage.of(wattage)

        where:
        voltage | resistance | wattage
        4.2     | 0.2        | 88.2
        4.2     | 0.11       | 160.36
        3.72    | 0.3        | 46.13
    }
}
