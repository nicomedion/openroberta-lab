package de.fhg.iais.openroberta.visitor;

import java.util.List;

import com.google.common.collect.ClassToInstanceMap;

import de.fhg.iais.roberta.bean.IProjectBean;
import de.fhg.iais.roberta.bean.UsedHardwareBean;
import de.fhg.iais.roberta.components.ConfigurationAst;
import de.fhg.iais.roberta.syntax.Phrase;
import de.fhg.iais.roberta.syntax.configuration.ConfigurationComponent;
import de.fhg.iais.roberta.syntax.lang.blocksequence.MainTask;
import de.fhg.iais.roberta.syntax.lang.stmt.WaitStmt;
import de.fhg.iais.roberta.syntax.lang.stmt.WaitTimeStmt;
import de.fhg.iais.roberta.syntax.sensor.generic.TimerReset;
import de.fhg.iais.roberta.syntax.sensor.generic.TimerSensor;
import de.fhg.iais.roberta.util.basic.C;
import de.fhg.iais.roberta.util.syntax.SC;
import de.fhg.iais.roberta.visitor.lang.codegen.prog.AbstractPythonVisitor;

public class KarlPythonVisitor extends AbstractPythonVisitor implements IKarlVisitor<Void> {

    private final ConfigurationAst configurationAst;

    /**
     * initialize the Python code generator visitor.
     *
     * @param programPhrases to generate the code from
     * @param beans
     */
    protected KarlPythonVisitor(
        List<List<Phrase>> programPhrases, ClassToInstanceMap<IProjectBean> beans, ConfigurationAst configurationAst) {
        super(programPhrases, beans);
        this.configurationAst = configurationAst;
    }

    @Override
    public Void visitMainTask(MainTask mainTask) {
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
    public Void visitWaitStmt(WaitStmt waitStmt) {
        return null;
    }

    @Override
    public Void visitWaitTimeStmt(WaitTimeStmt waitTimeStmt) {
        return null;
    }

    @Override
    protected void generateProgramPrefix(boolean withWrapping) {
        if ( !withWrapping ) {
            return;
        }
        UsedHardwareBean usedHardwareBean = this.getBean(UsedHardwareBean.class);
        this.src.add("import karl.v3").nlI();
        this.src.add("import math").nlI();
        if ( usedHardwareBean.isActorUsed(C.RANDOM) || usedHardwareBean.isActorUsed(C.RANDOM_DOUBLE) ) {
            this.src.add("import random").nlI();
        }
        //this.src.add("from spike.control import wait_for_seconds, wait_until");
        if ( usedHardwareBean.isSensorUsed(SC.TIMER) ) {
            this.src.add(", Timer");
        }
        if ( !usedHardwareBean.getUsedActors().isEmpty() && !usedHardwareBean.getUsedSensors().isEmpty() ) {
            nlIndent();
        }
        if ( usedHardwareBean.isActorUsed(SC.DIFFERENTIALDRIVE) ) {
            ConfigurationComponent diffDrive = this.configurationAst.optConfigurationComponentByType("DIFFERENTIALDRIVE");
            String leftPort = diffDrive.getComponentProperties().get("MOTOR_L");
            String rightPort = diffDrive.getComponentProperties().get("MOTOR_R");
            nlIndent();
            this.src.add("TRACKWIDTH = ").add(diffDrive.getComponentProperties().get("BRICK_TRACK_WIDTH")).nlI();
            this.src.add("diff_drive = spike.MotorPair('").add(leftPort).add("', '").add(rightPort).add("')").nlI();
            this.src.add("diff_drive.set_motor_rotation(").add(diffDrive.getComponentProperties().get("BRICK_WHEEL_DIAMETER")).add(" * math.pi, 'cm')");
        }
        if ( usedHardwareBean.isActorUsed(SC.MOTOR) ) {
            usedHardwareBean.getUsedActors().stream().filter(usedActor -> usedActor.getType().equals("MOTOR")).forEach(motor -> {
                nlIndent();
                this.src.add("motor").add(motor.getPort()).add(" = spike.Motor('").add(motor.getPort()).add("')");
            });
        }
        if ( usedHardwareBean.isSensorUsed(SC.TOUCH) ) {
            usedHardwareBean.getUsedSensors().stream().filter(usedActor -> usedActor.getType().equals("TOUCH")).forEach(sensor -> {
                if ( configurationAst.optConfigurationComponent(sensor.getPort()) != null ) {
                    nlIndent();
                    this.src.add("touch_sensor_").add(sensor.getPort()).add(" = spike.ForceSensor('").add(getPortFromConfig(sensor.getPort())).add("')");
                }
            });
        }
        if ( usedHardwareBean.isSensorUsed(SC.ULTRASONIC) ) {
            usedHardwareBean.getUsedSensors().stream().filter(usedActor -> usedActor.getType().equals("ULTRASONIC")).forEach(sensor -> {
                if ( configurationAst.optConfigurationComponent(sensor.getPort()) != null ) {
                    nlIndent();
                    this.src.add("ultrasonic_sensor_").add(sensor.getPort()).add(" = spike.DistanceSensor('").add(getPortFromConfig(sensor.getPort())).add("')");
                }
            });
        }
        if ( usedHardwareBean.isSensorUsed(SC.COLOR) ) {
            usedHardwareBean.getUsedSensors().stream().filter(usedActor -> usedActor.getType().equals("COLOR")).forEach(sensor -> {
                if ( configurationAst.optConfigurationComponent(sensor.getPort()) != null ) {
                    nlIndent();
                    this.src.add("color_sensor_").add(sensor.getPort()).add(" = spike.ColorSensor('").add(getPortFromConfig(sensor.getPort())).add("')");
                }
            });
        }
        if ( usedHardwareBean.isActorUsed("DISPLAY") ) {
            nlIndent();
            this.src.add("import hub as _hub").nlI();
            this.src.add("display = _hub.display").nlI();
            this.src.add("Image = _hub.Image");
        }
        if ( usedHardwareBean.isSensorUsed(SC.TIMER) ) {
            nlIndent();
            this.src.add("timer = Timer()");
        }
        if ( usedHardwareBean.isActorUsed("HUB") ) {
            nlIndent();
            this.src.add("hub = spike.PrimeHub()");
        }
    }

    private String getPortFromConfig(String name) {
        ConfigurationComponent block = configurationAst.getConfigurationComponent(name);
        return block.getComponentProperties().get("PORT");
    }
}
