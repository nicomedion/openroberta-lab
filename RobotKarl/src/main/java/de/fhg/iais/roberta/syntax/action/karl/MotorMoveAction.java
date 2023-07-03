package de.fhg.iais.roberta.syntax.action.karl;

import de.fhg.iais.roberta.syntax.action.Action;
import de.fhg.iais.roberta.transformer.forClass.NepoPhrase;
import de.fhg.iais.roberta.util.ast.BlocklyProperties;

@NepoPhrase(category = "ACTOR", blocklyNames = {"actions_motor_on_karl"}, name = "MOTOR_ON_ACTION")
public class MotorMoveAction extends Action {
    public MotorMoveAction(BlocklyProperties properties) {
        super(properties);
    }
}
