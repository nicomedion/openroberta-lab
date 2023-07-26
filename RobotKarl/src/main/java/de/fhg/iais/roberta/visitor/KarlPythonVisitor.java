package de.fhg.iais.roberta.visitor;

import java.util.List;

import com.google.common.collect.ClassToInstanceMap;

import de.fhg.iais.roberta.bean.IProjectBean;
import de.fhg.iais.roberta.bean.UsedHardwareBean;
import de.fhg.iais.roberta.components.ConfigurationAst;
import de.fhg.iais.roberta.syntax.Phrase;

import de.fhg.iais.roberta.syntax.action.karl.LedIntensityAction;
import de.fhg.iais.roberta.syntax.action.karl.LedOffAction;
import de.fhg.iais.roberta.syntax.action.karl.LedOnAction;
import de.fhg.iais.roberta.syntax.action.karl.LedToggleAction;
import de.fhg.iais.roberta.syntax.action.karl.PlayToneAction;
import de.fhg.iais.roberta.syntax.action.karl.VoltageRangeSensor;
import de.fhg.iais.roberta.syntax.action.sound.SetVolumeAction;
import de.fhg.iais.roberta.syntax.configuration.ConfigurationComponent;
import de.fhg.iais.roberta.syntax.lang.blocksequence.MainTask;
import de.fhg.iais.roberta.syntax.lang.stmt.StmtList;
import de.fhg.iais.roberta.syntax.lang.stmt.WaitStmt;
import de.fhg.iais.roberta.syntax.lang.stmt.WaitTimeStmt;
import de.fhg.iais.roberta.syntax.sensor.generic.KeysSensor;
import de.fhg.iais.roberta.syntax.sensor.generic.TimerReset;
import de.fhg.iais.roberta.syntax.sensor.generic.TimerSensor;
import de.fhg.iais.roberta.syntax.sensor.generic.VoltageSensor;
import de.fhg.iais.roberta.util.basic.C;
import de.fhg.iais.roberta.util.dbc.DbcException;
import de.fhg.iais.roberta.util.syntax.SC;
import de.fhg.iais.roberta.visitor.lang.codegen.prog.AbstractPythonVisitor;

//TODO clean up/remove everything from spike that i do not need
public class KarlPythonVisitor extends AbstractPythonVisitor implements IKarlVisitor<Void> {

    private final ConfigurationAst configurationAst;

    /**
     * initialize the Python code generator visitor.
     *
     * @param programPhrases to generate the code from
     * @param beans
     */
    public KarlPythonVisitor(
        List<List<Phrase>> programPhrases,
        ClassToInstanceMap<IProjectBean> beans,
        ConfigurationAst configurationAst) {
        super(programPhrases, beans);
        this.configurationAst = configurationAst;
    }

    @Override
    public Void visitKeysSensor(KeysSensor keysSensor) {
        //Pressed, hasBeenPressed or wait?
        this.src.add("button.pressed()");
        return null;
    }

    @Override
    public Void visitVoltageSensor(VoltageSensor potentiometer) {
        this.src.add("rotary.value()");
        return null;
    }

    @Override
    public Void visitVoltageRangeSensor(VoltageRangeSensor potentiometer) {
        this.src.add("rotary.range(0, 1)");
        return null;
    }

    @Override
    public Void visitSetVolumeAction(SetVolumeAction volume) {
        //TODO delete this block
        this.src.add("");
        return null;
    }

    @Override
    public Void visitLedIntensityAction(LedIntensityAction intensity) {
        String eye = intensity.eye.getValue();
        switch ( eye ){
            case "LinkesAuge":
                this.src.add("left_eye.intensity()");
                break;
            case "RechtesAuge":
                this.src.add("right_eye.intensity(");
                intensity.intensity.accept(this);
                this.sb.append(")");
                break;
            default:
                throw new DbcException("Invalid eye selected: " + eye);
        }
        return null;
    }

    @Override
    public Void visitLedOnAction(LedOnAction ledOnAction) {
        String eye = ledOnAction.eye.getValue();
        //TODO how to set the color correctly
        //ledOnAction.colour.accept(this);
        switch ( eye ){
            case "LinkesAuge":
                this.src.add("left_eye.on()");
                break;
            case "RechtesAuge":
                this.src.add("right_eye.on()");
                break;
            default:
                throw new DbcException("Invalid eye selected: " + eye);
        }
        return null;
    }

    @Override
    public Void visitLedOffAction(LedOffAction ledOffAction) {
        switch ( ledOffAction.eye.getValue() ){
            case "LinkesAuge":
                this.src.add("left_eye.off()");
                break;
            case "RechtesAuge":
                this.src.add("right_eye.off()");
                break;
            default:
                throw new DbcException("Invalid eye selected: " + ledOffAction.eye.getValue());
        }

        return null;
    }

    @Override
    public Void visitLedToggleAction(LedToggleAction ledToggleAction) {
        //TODO find out why only right eye works
        switch ( ledToggleAction.eye.getValue() ){
            case "LinkesAuge":
                this.src.add("left_eye.toggle()");
                break;
            case "RechtesAuge":
                this.src.add("right_eye.toggle()");
                break;
            default:
                throw new DbcException("Invalid eye selected: " + ledToggleAction.eye.getValue());
        }

        return null;
    }

    @Override
    public Void visitPlayToneAction(PlayToneAction playToneAction) {
        return null;
    }


    @Override
    public Void visitMainTask(MainTask mainTask) {
        this.sb.append("def main():");
        incrIndentation();
        if ( !this.usedGlobalVarInFunctions.isEmpty() ) {
            nlIndent();
            this.sb.append("global ").append(String.join(", ", this.usedGlobalVarInFunctions));
        } else {
            addPassIfProgramIsEmpty();
        }

        return null;
    }

    @Override
    protected void generateProgramSuffix(boolean withWrapping) {
        decrIndentation();
        nlIndent();
        //TODO ask if try catch is necessary for us
        super.generateProgramSuffix(withWrapping);

    }

    @Override
    public Void visitTimerReset(TimerReset timerReset) {
        this.src.add("timer.reset()");
        return null;
    }

    @Override
    public Void visitTimerSensor(TimerSensor timerSensor) {
        this.src.add("timer.now() * 1000");
        return null;
    }


    @Override
    public Void visitWaitStmt(WaitStmt waitStmt) {
        this.sb.append("while True:");
        incrIndentation();
        visitStmtList(waitStmt.statements);
        decrIndentation();
        return null;
    }

    @Override
    public Void visitWaitTimeStmt(WaitTimeStmt waitTimeStmt) {
        this.sb.append("time.sleep_ms(");
        waitTimeStmt.time.accept(this);
        this.sb.append(")");
        return null;
    }

    @Override
    protected void generateProgramPrefix(boolean withWrapping) {
        if ( !withWrapping ) {
            return;
        }
        UsedHardwareBean usedHardwareBean = this.getBean(UsedHardwareBean.class);
        this.src.add("from karl.v3 import *").nlI();
        this.src.add("import math").nlI();
        this.src.add("import time").nlI();
        //TODO warum weiß used actor nicht das Random benutzt wird?
        if ( usedHardwareBean.isActorUsed(C.RANDOM) || usedHardwareBean.isActorUsed(C.RANDOM_DOUBLE) ) {
            this.src.add("import random").nlI();
        }

        if ( !usedHardwareBean.getUsedActors().isEmpty() && !usedHardwareBean.getUsedSensors().isEmpty() ) {
            nlIndent();
        }


    }




    private String getPortFromConfig(String name) {
        ConfigurationComponent block = configurationAst.getConfigurationComponent(name);
        return block.getComponentProperties().get("PORT");
    }
}
