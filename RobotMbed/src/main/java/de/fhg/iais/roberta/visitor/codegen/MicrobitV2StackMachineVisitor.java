package de.fhg.iais.roberta.visitor.codegen;

import java.util.List;

import org.json.JSONObject;

import de.fhg.iais.roberta.components.ConfigurationAst;
import de.fhg.iais.roberta.syntax.Phrase;
import de.fhg.iais.roberta.syntax.action.mbed.microbitV2.PlayExpressionAction;
import de.fhg.iais.roberta.syntax.action.mbed.microbitV2.SoundToggleAction;
import de.fhg.iais.roberta.syntax.action.sound.SetVolumeAction;
import de.fhg.iais.roberta.syntax.sensor.mbed.microbitV2.LogoSetTouchMode;
import de.fhg.iais.roberta.syntax.sensor.mbed.microbitV2.LogoTouchSensor;
import de.fhg.iais.roberta.syntax.sensor.mbed.microbitV2.PinSetTouchMode;
import de.fhg.iais.roberta.util.basic.C;
import de.fhg.iais.roberta.util.dbc.Assert;
import de.fhg.iais.roberta.visitor.IMicrobitV2Visitor;

public class MicrobitV2StackMachineVisitor extends MbedStackMachineVisitor implements IMicrobitV2Visitor<Void> {

    public MicrobitV2StackMachineVisitor(ConfigurationAst configuration, List<List<Phrase>> phrases) {
        super(configuration, phrases);
        Assert.isTrue(!phrases.isEmpty());

    }

    @Override
    public Void visitPlayExpressionAction(PlayExpressionAction playExpressionAction) {
        return null;
    }

    @Override
    public Void visitSetVolumeAction(SetVolumeAction setVolumeAction) {
        return super.visitSetVolumeAction(setVolumeAction);
    }

    @Override
    public Void visitSoundToggleAction(SoundToggleAction soundToggleAction) {
        return null;
    }

    @Override
    public Void visitLogoTouchSensor(LogoTouchSensor logoTouchSensor) {
        String port = logoTouchSensor.getUserDefinedPort();
        String mode = logoTouchSensor.getMode();

        JSONObject o = makeNode(C.GET_SAMPLE).put(C.GET_SAMPLE, C.PIN + "LOGO").put(C.MODE, mode.toLowerCase());
        return add(o);
    }

    @Override
    public Void visitLogoSetTouchMode(LogoSetTouchMode logoSetTouchMode) {
        return null;
    }

    @Override
    public Void visitPinSetTouchMode(PinSetTouchMode pinSetTouchMode) {
        return null;
    }
}
