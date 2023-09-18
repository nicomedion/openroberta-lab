package de.fhg.iais.roberta.visitor;

import de.fhg.iais.roberta.syntax.action.karl.ButtonWaitAction;
import de.fhg.iais.roberta.syntax.action.karl.LedIntensityAction;
import de.fhg.iais.roberta.syntax.action.karl.LedOffAction;
import de.fhg.iais.roberta.syntax.action.karl.LedOnAction;
import de.fhg.iais.roberta.syntax.action.karl.LedSetRgbKarlAction;
import de.fhg.iais.roberta.syntax.action.karl.LedToggleAction;
import de.fhg.iais.roberta.syntax.action.karl.MotorOnAction;
import de.fhg.iais.roberta.syntax.action.karl.MotorStopAction;
import de.fhg.iais.roberta.syntax.action.karl.PlayNoteKarlAction;
import de.fhg.iais.roberta.syntax.action.karl.VoltageRangeSensor;
import de.fhg.iais.roberta.syntax.action.spike.PlayNoteAction;
import de.fhg.iais.roberta.syntax.action.spike.PlayToneAction;
import de.fhg.iais.roberta.syntax.configuration.Button;
import de.fhg.iais.roberta.syntax.sensor.generic.KeysSensor;
import de.fhg.iais.roberta.syntax.sensor.generic.VoltageSensor;

public interface IKarlVisitor<V> extends IVisitor<V> {

    V visitKeysSensor(KeysSensor keysSensor);
    V visitVoltageSensor(VoltageSensor potentiometer);
    V visitLedOnAction(LedOnAction ledOnAction);
    V visitLedSetRgbKarlAction(LedSetRgbKarlAction ledSetRgbAction);
    V visitLedOffAction(LedOffAction ledOffAction);
    V visitPlayNoteKarlAction(PlayNoteKarlAction playNoteAction);
    V visitPlayToneAction(PlayToneAction playToneAction);
    V visitLedToggleAction(LedToggleAction ledToggleAction);
    V visitVoltageRangeSensor(VoltageRangeSensor potentiometer);
    V visitLedIntensityAction(LedIntensityAction intensity);
    V visitMotorStopAction(MotorStopAction motorStopAction);
    V visitMotorOnAction(MotorOnAction motorOnAction);
    V visitButtonWaitAction(ButtonWaitAction buttonWaitAction);

}
