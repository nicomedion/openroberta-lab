package de.fhg.iais.roberta.visitor;

import de.fhg.iais.roberta.syntax.sensor.generic.KeysSensor;
import de.fhg.iais.roberta.syntax.sensor.generic.VoltageSensor;

public interface IKarlVisitor<V> extends IVisitor<V> {

    V visitKeysSensor(KeysSensor keysSensor);
    V visitVoltageSensor(VoltageSensor potentiometer);
    /*V visitPlayToneAction(PlayToneAction playToneAction);
    V visitPlayNoteAction(PlayNoteAction playNoteAction);
    V visitMotorOnAction(MotorOnAction motorOnAction);
    V visitMotorStopAction(MotorStopAction motorStopAction);
    V visitLedOnAction(LedOnAction ledOnAction);
    V visitLedOffAction(LedOffAction ledOffAction);
    V visitLightSensor(LightSensor lightSensor);
    V visitLightAction(LightAction lightAction);
    V visitLightOffAction(LightOffAction lightOffAction);*/
    //V visitLightToggleAction(LightAction lightAction);
    //V visitLightIntensityAction(LightAction lightAction);

}
