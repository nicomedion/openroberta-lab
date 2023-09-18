package de.fhg.iais.roberta.syntax.action.karl;

import de.fhg.iais.roberta.syntax.action.Action;
import de.fhg.iais.roberta.transformer.forClass.NepoPhrase;
import de.fhg.iais.roberta.util.ast.BlocklyProperties;

@NepoPhrase(category = "ACTOR", blocklyNames = {"actions_button_wait_karl"}, name = "BUTTON_WAIT_ACTION")
public final class ButtonWaitAction extends Action {
    public ButtonWaitAction(BlocklyProperties properties) {
        super(properties);
        this.setReadOnly();
    }
}
