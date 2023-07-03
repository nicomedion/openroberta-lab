package de.fhg.iais.roberta.syntax.action.karl;

import de.fhg.iais.roberta.syntax.action.Action;
import de.fhg.iais.roberta.transformer.forClass.NepoPhrase;
import de.fhg.iais.roberta.util.ast.BlocklyProperties;

@NepoPhrase(category = "ACTOR", blocklyNames = {"actions_motor_stop_karl"}, name = "MOTOR_STOP_ACTION")
public class MotorStopAction extends Action {
    public MotorStopAction(BlocklyProperties properties) {
        super(properties);
    }
}
