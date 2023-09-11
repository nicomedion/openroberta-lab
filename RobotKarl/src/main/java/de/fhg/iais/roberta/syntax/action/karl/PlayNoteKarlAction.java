package de.fhg.iais.roberta.syntax.action.karl;

import de.fhg.iais.roberta.syntax.action.Action;
import de.fhg.iais.roberta.transformer.forClass.NepoPhrase;
import de.fhg.iais.roberta.transformer.forField.NepoField;
import de.fhg.iais.roberta.util.ast.BlocklyProperties;

@NepoPhrase(
    category = "ACTOR",
    blocklyNames = {"actions_play_note_karl"},
    name = "PLAY_NOTE_ACTION"
)
public final class PlayNoteKarlAction extends Action {
    @NepoField(name = "DURATION", value = "1000")
    public final String duration;
    @NepoField(name = "FREQUENCY", value = "261.626")
    public final String frequency;
    public PlayNoteKarlAction(BlocklyProperties properties, String duration, String frequency) {
        super(properties);
        this.duration = duration;
        this.frequency = frequency;
        this.setReadOnly();
    }
}
