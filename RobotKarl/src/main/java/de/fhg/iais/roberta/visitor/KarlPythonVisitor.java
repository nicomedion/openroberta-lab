package de.fhg.iais.roberta.visitor;

import java.util.List;

import com.google.common.collect.ClassToInstanceMap;

import de.fhg.iais.roberta.bean.IProjectBean;
import de.fhg.iais.roberta.bean.UsedHardwareBean;
import de.fhg.iais.roberta.components.ConfigurationAst;
import de.fhg.iais.roberta.syntax.Phrase;

import de.fhg.iais.roberta.syntax.action.karl.LedOffAction;
import de.fhg.iais.roberta.syntax.action.karl.LedOnAction;
import de.fhg.iais.roberta.syntax.action.karl.LedToggleAction;
import de.fhg.iais.roberta.syntax.action.karl.PlayToneAction;
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
        String portName = keysSensor.getUserDefinedPort();
        ConfigurationComponent configurationComponent = this.configurationAst.getConfigurationComponent(portName);
        String port = configurationComponent.getProperty("PIN1");
        if ( port.equals("Knopf")) {
            this.src.add("hub.right_button.is_pressed()");
        }else{
            throw new DbcException("Invalid key sensor port: " + port);
        }
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
        this.sb.append("wait_for_seconds(");
        waitTimeStmt.time.accept(this);
        this.sb.append("/1000)");
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
        //TODO warum weiß used actor nicht das Random benutzt wird?
        if ( usedHardwareBean.isActorUsed(C.RANDOM) || usedHardwareBean.isActorUsed(C.RANDOM_DOUBLE) ) {
            this.src.add("import random").nlI();
        }
        //System.out.println("Used Actors");
        //System.out.println(usedHardwareBean.getUsedActors());
        /*if(usedHardwareBean.isSensorUsed(SC.KEY)){
            usedHardwareBean.getUsedSensors().stream().filter(usedActor -> usedActor.getType().equals("TOUCH")).forEach(sensor -> {
                if ( configurationAst.optConfigurationComponent(sensor.getPort()) != null ) {
                    nlIndent();
                    this.src.add("button").add(sensor.getPort()).add(" = Button('").add(getPortFromConfig(sensor.getPort())).add("')");
                }
            });
        }*/

        /*if(usedHardwareBean.isSensorUsed(SC.POTENTIOMETER)){
            usedHardwareBean.getUsedSensors().stream().filter(usedActor -> usedActor.getType().equals("TOUCH")).forEach(sensor -> {
                if ( configurationAst.optConfigurationComponent(sensor.getPort()) != null ) {
                    nlIndent();
                    this.src.add("poti").add(sensor.getPort()).add(" = Rotary('").add(getPortFromConfig(sensor.getPort())).add("')");
                }
            });
        }*/
        //TODO Motoren unterscheiden in Beine/Füße
        /*if ( usedHardwareBean.isActorUsed(SC.MOTOR) ) {
            usedHardwareBean.getUsedActors().stream().filter(usedActor -> usedActor.getType().equals("MOTOR")).forEach(motor -> {
                nlIndent();
                this.src.add("motor").add(motor.getPort()).add(" = Servo('").add(motor.getPort()).add("')");
            });
        }*/

        if ( usedHardwareBean.isActorUsed(SC.RGBLED) ) {
            usedHardwareBean.getUsedActors().stream().filter(usedActor -> usedActor.getType().equals("RGBLED")).forEach(motor -> {
                nlIndent();
                this.src.add("eye").add(motor.getPort()).add(" = LED('").add(motor.getPort()).add("')");
            });
        }

        if ( usedHardwareBean.isActorUsed(SC.BUZZER) ) {
            usedHardwareBean.getUsedActors().stream().filter(usedActor -> usedActor.getType().equals("BUZZER")).forEach(motor -> {
                nlIndent();
                this.src.add("mouth").add(motor.getPort()).add(" = Speaker('").add(motor.getPort()).add("')");
            });
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
