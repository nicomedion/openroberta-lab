package de.fhg.iais.roberta.syntax.action.karl;

import de.fhg.iais.roberta.syntax.sensor.ExternalSensor;
import de.fhg.iais.roberta.transformer.forClass.F2M;
import de.fhg.iais.roberta.transformer.forClass.NepoExpr;
import de.fhg.iais.roberta.util.ast.BlocklyProperties;
import de.fhg.iais.roberta.util.ast.ExternalSensorBean;

@NepoExpr(name = "VOLTAGE_SENSING", category = "SENSOR", blocklyNames = {"robSensors_potentiometerrange_getSample"},
    sampleValues = {@F2M(field = "POTENTIOMETER_VALUE", mode = "VALUE")})
public final class VoltageRangeSensor extends ExternalSensor {
    public VoltageRangeSensor(BlocklyProperties properties, ExternalSensorBean externalSensorBean) {
        super(properties, externalSensorBean);
        setReadOnly();
    }
}
