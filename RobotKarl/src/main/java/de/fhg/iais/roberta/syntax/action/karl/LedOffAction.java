package de.fhg.iais.roberta.syntax.action.karl;

import de.fhg.iais.roberta.syntax.action.Action;
import de.fhg.iais.roberta.transformer.forClass.NepoPhrase;
import de.fhg.iais.roberta.util.ast.BlocklyProperties;

@NepoPhrase(category = "ACTOR", blocklyNames = {"actions_eyeLed_off_karl"}, name = "LED_OFF_ACTION")
public final class LedOffAction extends Action {
    public LedOffAction(BlocklyProperties properties) {
        super(properties);
        setReadOnly();
    }
}
