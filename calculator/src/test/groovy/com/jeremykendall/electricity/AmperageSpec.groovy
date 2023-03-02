package com.jeremykendall.electricity

import spock.lang.Specification

class AmperageSpec extends Specification {
    def "should calculate current"() {
        expect:
        amps == Amperage.calculate(voltage, resistance, 2)

        where:
        voltage          | resistance          | amps
        Voltage.of(3.38) | Resistance.of(0.2)  | Amperage.of(16.9)
        Voltage.of(3.53) | Resistance.of(0.32) | Amperage.of(11.03)
        Voltage.of(4.16) | Resistance.of(0.54) | Amperage.of(7.7)
        Voltage.of(6.0)  | Resistance.of(0.13) | Amperage.of(46.15)
    }
}
