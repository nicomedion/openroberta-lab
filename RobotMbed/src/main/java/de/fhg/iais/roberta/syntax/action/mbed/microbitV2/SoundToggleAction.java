package de.fhg.iais.roberta.syntax.action.mbed.microbitV2;

import de.fhg.iais.roberta.syntax.action.Action;
import de.fhg.iais.roberta.transformer.forClass.NepoPhrase;
import de.fhg.iais.roberta.transformer.forField.NepoField;
import de.fhg.iais.roberta.util.ast.BlocklyProperties;

@NepoPhrase(name = "LED_MATRIX_TEXT_ACTION", category = "ACTOR", blocklyNames = {"actions_sound_toggle"})
public final class SoundToggleAction extends Action {

    @NepoField(name = "MODE")
    public final String mode;

    public SoundToggleAction(BlocklyProperties properties, String mode) {
        super(properties);
        this.mode = mode;
        setReadOnly();
    }
}
