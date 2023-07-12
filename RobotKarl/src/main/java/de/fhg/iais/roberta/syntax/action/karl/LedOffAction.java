package de.fhg.iais.roberta.syntax.action.karl;

import de.fhg.iais.roberta.blockly.generated.Hide;
import de.fhg.iais.roberta.syntax.action.Action;
import de.fhg.iais.roberta.transformer.forClass.NepoPhrase;
import de.fhg.iais.roberta.transformer.forField.NepoHide;
import de.fhg.iais.roberta.util.ast.BlocklyProperties;

@NepoPhrase(category = "ACTOR", blocklyNames = {"actions_eyeLed_off_karl"}, name = "LED_OFF_ACTION")
public final class LedOffAction extends Action {
    @NepoHide
    public final Hide eye;
    public LedOffAction(BlocklyProperties properties, Hide eye) {
        super(properties);
        this.eye = eye;
        //TODO where does the it get the eye from?
        //this.eye = eye;
        setReadOnly();
    }
}
