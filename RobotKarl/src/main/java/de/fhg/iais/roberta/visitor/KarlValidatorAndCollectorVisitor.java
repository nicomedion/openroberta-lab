package de.fhg.iais.roberta.visitor;

import com.google.common.collect.ClassToInstanceMap;

import de.fhg.iais.roberta.bean.IProjectBean;
import de.fhg.iais.roberta.components.ConfigurationAst;
import de.fhg.iais.roberta.components.UsedActor;
import de.fhg.iais.roberta.syntax.Phrase;
import de.fhg.iais.roberta.syntax.action.karl.LedOffAction;
import de.fhg.iais.roberta.syntax.action.karl.LedOnAction;
import de.fhg.iais.roberta.syntax.action.karl.PlayToneAction;
import de.fhg.iais.roberta.syntax.sensor.generic.KeysSensor;
import de.fhg.iais.roberta.syntax.sensor.generic.TimerReset;
import de.fhg.iais.roberta.syntax.sensor.generic.TimerSensor;
import de.fhg.iais.roberta.syntax.sensor.generic.VoltageSensor;
import de.fhg.iais.roberta.visitor.validate.CommonNepoValidatorAndCollectorVisitor;

public class KarlValidatorAndCollectorVisitor extends CommonNepoValidatorAndCollectorVisitor implements IKarlVisitor<Void> {

    public KarlValidatorAndCollectorVisitor(ConfigurationAst robotConfiguration, ClassToInstanceMap<IProjectBean.IBuilder> beanBuilders){
        super(robotConfiguration, beanBuilders);

    }



    @Override
    public Void visitKeysSensor(KeysSensor keysSensor) {
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
        return null;
    }

    @Override
    public Void visitLedOnAction(LedOnAction ledOnAction) {
        return null;
    }

    @Override
    public Void visitLedOffAction(LedOffAction ledOffAction) {
        //checkActorPort(ledOffAction);

        usedHardwareBuilder.addUsedActor(new UsedActor("", "HUB"));
        return null;
    }

    @Override
    public Void visitPlayToneAction(PlayToneAction playToneAction) {
        return null;
    }
}
