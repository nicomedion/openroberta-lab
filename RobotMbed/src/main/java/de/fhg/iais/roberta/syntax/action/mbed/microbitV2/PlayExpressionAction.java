package de.fhg.iais.roberta.syntax.action.mbed.microbitV2;

import de.fhg.iais.roberta.syntax.action.Action;
import de.fhg.iais.roberta.transformer.forClass.NepoPhrase;
import de.fhg.iais.roberta.transformer.forField.NepoField;
import de.fhg.iais.roberta.util.ast.BlocklyProperties;

@NepoPhrase(name = "PLAY_EXPRESSION_ACTION", category = "ACTOR", blocklyNames = {"actions_play_expression"})
public final class PlayExpressionAction extends Action {

    @NepoField(name = "SOUND")
    public final String expression;

    public PlayExpressionAction(BlocklyProperties properties, String expression) {
        super(properties);
        this.expression = expression;
        setReadOnly();
    }
}
