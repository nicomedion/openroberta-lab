package de.fhg.iais.roberta.syntax.action.karl;

import de.fhg.iais.roberta.syntax.action.Action;
import de.fhg.iais.roberta.transformer.forClass.NepoPhrase;
import de.fhg.iais.roberta.transformer.forField.NepoField;
import de.fhg.iais.roberta.util.ast.BlocklyProperties;
import de.fhg.iais.roberta.util.syntax.BlocklyConstants;

@NepoPhrase(category = "ACTOR", blocklyNames = {"actions_eyeLed_off_karl"}, name = "LED_OFF_ACTION")
public final class LedOffAction extends Action {
    @NepoField(name = BlocklyConstants.ACTORPORT)
    public final String eye;
    public LedOffAction(BlocklyProperties properties, String eye) {
        super(properties);
        //TODO where does the it get the eye from?
        this.eye = eye;
        setReadOnly();
    }
}
