package de.fhg.iais.roberta.syntax.action.karl;

import de.fhg.iais.roberta.syntax.sensor.ExternalSensor;
import de.fhg.iais.roberta.transformer.forClass.F2M;
import de.fhg.iais.roberta.transformer.forClass.NepoExpr;
import de.fhg.iais.roberta.util.ast.BlocklyProperties;
import de.fhg.iais.roberta.util.ast.ExternalSensorBean;

@NepoExpr(name = "VOLTAGE_SENSING", category = "SENSOR", blocklyNames = {"robSensors_potentiometer_getSample_karl"},
    sampleValues = {@F2M(field = "POTENTIOMETER_VALUE", mode = "VALUE"), @F2M(field = "POTENTIOMETER_RANGE", mode = "RANGE")})
public final class VoltageKarlSensor extends ExternalSensor {
    public VoltageKarlSensor(BlocklyProperties properties, ExternalSensorBean externalSensorBean) {
        super(properties, externalSensorBean);
        setReadOnly();
    }
}
