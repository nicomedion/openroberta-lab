package de.fhg.iais.roberta.syntax.action.karl;

import de.fhg.iais.roberta.syntax.action.Action;
import de.fhg.iais.roberta.transformer.forClass.NepoPhrase;
import de.fhg.iais.roberta.util.ast.BlocklyProperties;

@NepoPhrase(category = "ACTOR", blocklyNames = {"actions_button_interrupt_karl"}, name = "BUTTON_INTERRUPT_KARL_ACTION")
public final class ButtonInterruptKarlAction extends Action {
    public ButtonInterruptKarlAction(BlocklyProperties properties) {
        super(properties);
        this.setReadOnly();
    }
}
