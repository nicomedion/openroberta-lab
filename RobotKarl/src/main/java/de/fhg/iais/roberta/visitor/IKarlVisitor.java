package de.fhg.iais.roberta.visitor;

import de.fhg.iais.roberta.syntax.action.karl.LedOffAction;
import de.fhg.iais.roberta.syntax.action.karl.LedOnAction;
import de.fhg.iais.roberta.syntax.action.karl.LedToggleAction;
import de.fhg.iais.roberta.syntax.action.karl.PlayToneAction;
import de.fhg.iais.roberta.syntax.sensor.generic.KeysSensor;
import de.fhg.iais.roberta.syntax.sensor.generic.VoltageSensor;

public interface IKarlVisitor<V> extends IVisitor<V> {

    V visitKeysSensor(KeysSensor keysSensor);
    V visitVoltageSensor(VoltageSensor potentiometer);
    V visitLedOnAction(LedOnAction ledOnAction);
    V visitLedOffAction(LedOffAction ledOffAction);
    V visitPlayToneAction(PlayToneAction playToneAction);
    V visitLedToggleAction(LedToggleAction ledToggleAction);
    V visitVoltageNormalizedSensor(VoltageSensor potentiometer);
    /*
    V visitPlayNoteAction(PlayNoteAction playNoteAction);
    V visitMotorOnAction(MotorOnAction motorOnAction);
    V visitMotorStopAction(MotorStopAction motorStopAction);
    V visitLightSensor(LightSensor lightSensor);
    V visitLightAction(LightAction lightAction);
    V visitLightOffAction(LightOffAction lightOffAction);*/

    //V visitLightIntensityAction(LightAction lightAction);

}
