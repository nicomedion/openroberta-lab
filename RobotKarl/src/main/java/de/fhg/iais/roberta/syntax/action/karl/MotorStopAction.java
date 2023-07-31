package de.fhg.iais.roberta.syntax.action.karl;

import de.fhg.iais.roberta.syntax.action.Action;
import de.fhg.iais.roberta.transformer.forClass.NepoPhrase;
import de.fhg.iais.roberta.transformer.forField.NepoField;
import de.fhg.iais.roberta.util.ast.BlocklyProperties;

@NepoPhrase(category = "ACTOR", blocklyNames = {"actions_motor_stop_karl"}, name = "MOTOR_STOP_ACTION")
public final class MotorStopAction extends Action {
    @NepoField(name = "ACTORPORT")
    public final String port;
    @NepoField(name = "CONTROL")
    public final String control;
    public MotorStopAction(BlocklyProperties properties, String port, String control) {
        super(properties);
        this.port = port;
        this.control = control;
    }
}
