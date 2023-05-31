package de.fhg.iais.openroberta.visitor;

import de.fhg.iais.roberta.syntax.action.light.LightAction;
import de.fhg.iais.roberta.syntax.action.light.LightOffAction;
import de.fhg.iais.roberta.syntax.action.motor.MotorOnAction;
import de.fhg.iais.roberta.syntax.action.spike.LedOffAction;
import de.fhg.iais.roberta.syntax.action.spike.LedOnAction;
import de.fhg.iais.roberta.syntax.action.spike.MotorStopAction;
import de.fhg.iais.roberta.syntax.action.spike.PlayNoteAction;
import de.fhg.iais.roberta.syntax.action.spike.PlayToneAction;
import de.fhg.iais.roberta.syntax.sensor.generic.KeysSensor;
import de.fhg.iais.roberta.syntax.sensor.generic.LightSensor;
import de.fhg.iais.roberta.syntax.sensor.generic.VoltageSensor;
import de.fhg.iais.roberta.visitor.IVisitor;

public interface IKarlVisitor<V> extends IVisitor<V> {

    V visitKeysSensor(KeysSensor keysSensor);
    V visitVoltageSensor(VoltageSensor potentiometer);
    V visitPlayToneAction(PlayToneAction playToneAction);
    V visitPlayNoteAction(PlayNoteAction playNoteAction);
    V visitMotorOnAction(MotorOnAction motorOnAction);
    V visitMotorStopAction(MotorStopAction motorStopAction);
    V visitLedOnAction(LedOnAction ledOnAction);
    V visitLedOffAction(LedOffAction ledOffAction);
    V visitLightSensor(LightSensor lightSensor);
    V visitLightAction(LightAction lightAction);
    V visitLightOffAction(LightOffAction lightOffAction);
    //V visitLightToggleAction(LightAction lightAction);
    //V visitLightIntensityAction(LightAction lightAction);

}
