package de.fhg.iais.roberta.syntax.action.karl;

import de.fhg.iais.roberta.syntax.lang.expr.Expr;
import de.fhg.iais.roberta.syntax.sensor.Sensor;
import de.fhg.iais.roberta.transformer.forClass.NepoExpr;
import de.fhg.iais.roberta.transformer.forField.NepoValue;
import de.fhg.iais.roberta.typecheck.BlocklyType;
import de.fhg.iais.roberta.util.ast.BlocklyProperties;

@NepoExpr(name = "VOLTAGE_SENSING", category = "SENSOR", blocklyNames = {"robsensors_potentiometerrange_getsample_karl"})
public final class VoltageRangeSensor extends Sensor {
    @NepoValue(name = "RANGE1", type = BlocklyType.NUMBER)
    public final Expr minValue;
    @NepoValue(name = "RANGE2", type = BlocklyType.NUMBER)
    public final Expr maxValue;

    public VoltageRangeSensor(BlocklyProperties properties, Expr minValue, Expr maxValue) {
        super(properties);
        this.minValue = minValue;
        this.maxValue = maxValue;
        setReadOnly();
    }
}
