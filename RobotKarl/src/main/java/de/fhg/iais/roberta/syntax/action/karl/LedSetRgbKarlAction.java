package de.fhg.iais.roberta.syntax.action.karl;

import de.fhg.iais.roberta.syntax.action.Action;
import de.fhg.iais.roberta.syntax.lang.expr.Expr;
import de.fhg.iais.roberta.transformer.forClass.NepoPhrase;
import de.fhg.iais.roberta.transformer.forField.NepoField;
import de.fhg.iais.roberta.transformer.forField.NepoValue;
import de.fhg.iais.roberta.typecheck.BlocklyType;
import de.fhg.iais.roberta.util.ast.BlocklyProperties;

@NepoPhrase(category = "ACTOR", blocklyNames = {"actions_eyeLed_set_rgb_karl"}, name = "LED_SET_RGB_ACTION")
public final class LedSetRgbKarlAction extends Action {
    @NepoField(name = "ACTORPORT")
    public final String eye;
    @NepoValue(name = "COLOUR_RED", type = BlocklyType.NUMBER_INT)
    public final Expr colour_red;
    @NepoValue(name = "COLOUR_GREEN", type = BlocklyType.NUMBER_INT)
    public final Expr colour_green;
    @NepoValue(name = "COLOUR_BLUE", type = BlocklyType.NUMBER_INT)
    public final Expr colour_blue;
    public LedSetRgbKarlAction(BlocklyProperties properties, String eye, Expr colourRed, Expr colourGreen, Expr colourBlue) {
        super(properties);
        this.eye = eye;
        this.colour_red = colourRed;
        this.colour_green = colourGreen;
        this.colour_blue = colourBlue;
        this.setReadOnly();
    }
}
