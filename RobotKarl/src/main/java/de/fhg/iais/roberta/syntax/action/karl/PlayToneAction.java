package de.fhg.iais.roberta.syntax.action.karl;

import de.fhg.iais.roberta.syntax.action.Action;
import de.fhg.iais.roberta.syntax.lang.expr.Expr;
import de.fhg.iais.roberta.transformer.forClass.NepoPhrase;
import de.fhg.iais.roberta.transformer.forField.NepoValue;
import de.fhg.iais.roberta.typecheck.BlocklyType;
import de.fhg.iais.roberta.util.ast.BlocklyProperties;
import de.fhg.iais.roberta.util.syntax.BlocklyConstants;

@NepoPhrase(category = "ACTOR", blocklyNames = {"actions_play_tone_karl"}, name = "TONE_ACTION")
public class PlayToneAction extends Action {
    @NepoValue(name = BlocklyConstants.FREQUENCY, type = BlocklyType.NUMBER_INT)
    public final Expr frequency;
    @NepoValue(name = BlocklyConstants.DURATION, type = BlocklyType.NUMBER_INT)
    public final Expr duration;
    public PlayToneAction(BlocklyProperties properties, Expr frequency, Expr duration) {
        super(properties);
        this.frequency = frequency;
        this.duration = duration;
        setReadOnly();
    }
}
