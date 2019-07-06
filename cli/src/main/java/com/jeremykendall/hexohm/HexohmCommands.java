package com.jeremykendall.hexohm;

import com.jeremykendall.electricity.Resistance;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

@ShellComponent
public class HexohmCommands {

    @ShellMethod("Get HexOhm power output based on coil resistance for each potentiometer setting.")
    public String wattage(@ShellOption({"-r", "--resistance"}) Double resistance) {

        return HexohmDataTable.build(Resistance.of(resistance)).render(480);
    }
}
