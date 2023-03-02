package com.jeremykendall.hexohm;

import com.jeremykendall.electricity.Amperage;
import com.jeremykendall.electricity.Resistance;
import com.jeremykendall.electricity.Wattage;
import lombok.Value;
import org.springframework.shell.table.AbsoluteWidthSizeConstraints;
import org.springframework.shell.table.BeanListTableModel;
import org.springframework.shell.table.BorderStyle;
import org.springframework.shell.table.CellMatchers;
import org.springframework.shell.table.SimpleHorizontalAligner;
import org.springframework.shell.table.Table;
import org.springframework.shell.table.TableBuilder;
import org.springframework.shell.table.TableModel;

import java.util.EnumSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;

class HexohmDataTable {

    static Table build(Resistance resistance) {
        LinkedHashMap<String, Object> headers = new LinkedHashMap<>();
        headers.put("potentiometer", "Setting");
        headers.put("amperage", "Amps");
        headers.put("wattage", "Watts");

        List<RowData> rowData = EnumSet.allOf(Hexohm.Potentiometer.class).stream()
                .map(potentiometer -> {
                    Hexohm hexohm = new Hexohm(resistance, potentiometer);
                    return new RowData(potentiometer, hexohm.getCurrent(), hexohm.getPowerOutput());
                })
                .collect(Collectors.toList());

        TableModel model = new BeanListTableModel<>(rowData, headers);

        TableBuilder tableBuilder = new TableBuilder(model)
                .addFullBorder(BorderStyle.oldschool);

        tableBuilder.on(CellMatchers.table()).addAligner(SimpleHorizontalAligner.right);
        tableBuilder.on(CellMatchers.row(0)).addAligner(SimpleHorizontalAligner.center);
        tableBuilder.on(CellMatchers.column(0)).addSizer(new AbsoluteWidthSizeConstraints(10));
        tableBuilder.on(CellMatchers.column(1)).addSizer(new AbsoluteWidthSizeConstraints(10));
        tableBuilder.on(CellMatchers.column(2)).addSizer(new AbsoluteWidthSizeConstraints(10));

        return tableBuilder.build();
    }

    @Value
    static class RowData {
        Hexohm.Potentiometer potentiometer;
        Amperage amperage;
        Wattage wattage;
    }
}
