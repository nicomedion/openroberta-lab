package de.fhg.iais.roberta.syntax.action.karl;

import de.fhg.iais.roberta.syntax.action.Action;
import de.fhg.iais.roberta.syntax.lang.expr.Expr;
import de.fhg.iais.roberta.transformer.forClass.NepoPhrase;
import de.fhg.iais.roberta.transformer.forField.NepoValue;
import de.fhg.iais.roberta.util.ast.BlocklyProperties;
import de.fhg.iais.roberta.util.syntax.BlocklyConstants;

@NepoPhrase(category = "ACTOR", blocklyNames = {"actions_eyeLed_on_karl"}, name = "LED_ON_ACTION")
public class LedOnAction extends Action {
    @NepoValue(name = BlocklyConstants.COLOUR)
    public final Expr colour;
    public LedOnAction(BlocklyProperties properties, Expr colour){
        super(properties);
        this.colour = colour;
    }
}
