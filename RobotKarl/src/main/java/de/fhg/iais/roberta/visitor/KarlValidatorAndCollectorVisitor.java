package de.fhg.iais.roberta.visitor;

import com.google.common.collect.ClassToInstanceMap;

import de.fhg.iais.roberta.bean.IProjectBean;
import de.fhg.iais.roberta.components.ConfigurationAst;
import de.fhg.iais.roberta.components.UsedActor;
import de.fhg.iais.roberta.syntax.action.karl.LedIntensityAction;
import de.fhg.iais.roberta.syntax.action.karl.LedOffAction;
import de.fhg.iais.roberta.syntax.action.karl.LedOnAction;
import de.fhg.iais.roberta.syntax.action.karl.LedToggleAction;
import de.fhg.iais.roberta.syntax.action.karl.MotorOnAction;
import de.fhg.iais.roberta.syntax.action.karl.MotorStopAction;
import de.fhg.iais.roberta.syntax.action.karl.VoltageRangeSensor;
import de.fhg.iais.roberta.syntax.action.sound.SetVolumeAction;
import de.fhg.iais.roberta.syntax.action.spike.PlayNoteAction;
import de.fhg.iais.roberta.syntax.action.spike.PlayToneAction;
import de.fhg.iais.roberta.syntax.lang.functions.MathRandomFloatFunct;
import de.fhg.iais.roberta.syntax.lang.functions.MathRandomIntFunct;
import de.fhg.iais.roberta.syntax.sensor.generic.KeysSensor;
import de.fhg.iais.roberta.syntax.sensor.generic.TimerReset;
import de.fhg.iais.roberta.syntax.sensor.generic.TimerSensor;
import de.fhg.iais.roberta.syntax.sensor.generic.VoltageSensor;
import de.fhg.iais.roberta.util.basic.C;
import de.fhg.iais.roberta.util.syntax.SC;
import de.fhg.iais.roberta.visitor.validate.CommonNepoValidatorAndCollectorVisitor;

public class KarlValidatorAndCollectorVisitor extends CommonNepoValidatorAndCollectorVisitor implements IKarlVisitor<Void> {

    public KarlValidatorAndCollectorVisitor(ConfigurationAst robotConfiguration, ClassToInstanceMap<IProjectBean.IBuilder> beanBuilders){
        super(robotConfiguration, beanBuilders);

    }

    @Override
    public Void visitMathRandomFloatFunct(MathRandomFloatFunct mathRandomFloatFunct) {
        //TODO find out why this and random int never get called
        usedHardwareBuilder.addUsedActor(new UsedActor(null, C.RANDOM_DOUBLE));
        return null;
    }

    @Override
    public Void visitMathRandomIntFunct(MathRandomIntFunct mathRandomIntFunct) {
        super.visitMathRandomIntFunct(mathRandomIntFunct);
        usedHardwareBuilder.addUsedActor(new UsedActor(null, C.RANDOM));
        return null;
    }


    @Override
    public Void visitKeysSensor(KeysSensor keysSensor) {
        usedHardwareBuilder.addUsedActor(new UsedActor("", SC.KEY));
        return null;
    }

    @Override
    public Void visitTimerSensor(TimerSensor timerSensor) {
        return null;
    }

    @Override
    public Void visitTimerReset(TimerReset timerReset) {
        return null;
    }

    @Override
    public Void visitVoltageSensor(VoltageSensor potentiometer) {
        usedHardwareBuilder.addUsedActor(new UsedActor("", SC.POTENTIOMETER));
        return null;
    }

    @Override
    public Void visitLedOnAction(LedOnAction ledOnAction) {
        usedHardwareBuilder.addUsedActor(new UsedActor("", SC.RGBLED));
        return null;
    }

    @Override
    public Void visitLedOffAction(LedOffAction ledOffAction) {
        //checkActorPort(ledOffAction);

        usedHardwareBuilder.addUsedActor(new UsedActor("", SC.RGBLED));
        return null;
    }

    @Override
    public Void visitLedToggleAction(LedToggleAction ledToggleAction) {
        usedHardwareBuilder.addUsedActor(new UsedActor("", SC.RGBLED));
        return null;
    }

    @Override
    public Void visitVoltageRangeSensor(VoltageRangeSensor potentiometer) {
        usedHardwareBuilder.addUsedActor(new UsedActor("", SC.POTENTIOMETER));
        return null;
    }

    @Override
    public Void visitLedIntensityAction(LedIntensityAction intensity) {
        return null;
    }

    @Override
    public Void visitMotorStopAction(MotorStopAction motorStopAction) {
        usedHardwareBuilder.addUsedActor(new UsedActor("", SC.SERVOMOTOR));
        return null;
    }

    @Override
    public Void visitMotorOnAction(MotorOnAction motorOnAction) {
        usedHardwareBuilder.addUsedActor(new UsedActor("", SC.SERVOMOTOR));
        return null;
    }


    @Override
    public Void visitPlayNoteAction(PlayNoteAction playNoteAction) {
        usedHardwareBuilder.addUsedActor(new UsedActor("", SC.BUZZER));
        return null;
    }

    @Override
    public Void visitPlayToneAction(PlayToneAction playToneAction) {
        usedHardwareBuilder.addUsedActor(new UsedActor("", SC.BUZZER));
        return null;
    }


}
