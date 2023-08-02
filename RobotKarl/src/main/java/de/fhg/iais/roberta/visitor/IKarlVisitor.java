package de.fhg.iais.roberta.visitor;

import de.fhg.iais.roberta.syntax.action.karl.LedIntensityAction;
import de.fhg.iais.roberta.syntax.action.karl.LedOffAction;
import de.fhg.iais.roberta.syntax.action.karl.LedOnAction;
import de.fhg.iais.roberta.syntax.action.karl.LedToggleAction;
import de.fhg.iais.roberta.syntax.action.karl.MotorOnAction;
import de.fhg.iais.roberta.syntax.action.karl.MotorStopAction;
import de.fhg.iais.roberta.syntax.action.karl.VoltageRangeSensor;
import de.fhg.iais.roberta.syntax.action.sound.SetVolumeAction;
import de.fhg.iais.roberta.syntax.action.spike.PlayNoteAction;
import de.fhg.iais.roberta.syntax.sensor.generic.KeysSensor;
import de.fhg.iais.roberta.syntax.sensor.generic.VoltageSensor;

public interface IKarlVisitor<V> extends IVisitor<V> {

    V visitKeysSensor(KeysSensor keysSensor);
    V visitVoltageSensor(VoltageSensor potentiometer);
    V visitLedOnAction(LedOnAction ledOnAction);
    V visitLedOffAction(LedOffAction ledOffAction);
    V visitPlayNoteAction(PlayNoteAction playNoteAction);
    V visitLedToggleAction(LedToggleAction ledToggleAction);
    V visitVoltageRangeSensor(VoltageRangeSensor potentiometer);
    V visitSetVolumeAction(SetVolumeAction volume);
    V visitLedIntensityAction(LedIntensityAction intensity);
    V visitMotorStopAction(MotorStopAction motorStopAction);
    V visitMotorOnAction(MotorOnAction motorOnAction);
    /*
    V visitPlayNoteAction(PlayNoteAction playNoteAction);
    V visitMotorOnAction(MotorOnAction motorOnAction);
    V visitMotorStopAction(MotorStopAction motorStopAction);
    V visitLightSensor(LightSensor lightSensor);
    V visitLightAction(LightAction lightAction);
    V visitLightOffAction(LightOffAction lightOffAction);*/

    //V visitLightIntensityAction(LightAction lightAction);

}
