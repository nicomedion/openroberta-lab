package de.fhg.iais.roberta.syntax.action.karl;

import de.fhg.iais.roberta.blockly.generated.Hide;
import de.fhg.iais.roberta.syntax.action.Action;
import de.fhg.iais.roberta.transformer.forClass.NepoPhrase;
import de.fhg.iais.roberta.transformer.forField.NepoField;
import de.fhg.iais.roberta.transformer.forField.NepoHide;
import de.fhg.iais.roberta.util.ast.BlocklyProperties;

@NepoPhrase(category = "ACTOR", blocklyNames = {"actions_eyeLed_toggle_karl"}, name = "LED_TOGGLE_ACTION")
public final class LedToggleAction extends Action {
    @NepoField(name = "ACTORPORT")
    public final String eye;
    public LedToggleAction(BlocklyProperties properties, String eye) {
        super(properties);
        this.eye = eye;
        setReadOnly();
    }
}
