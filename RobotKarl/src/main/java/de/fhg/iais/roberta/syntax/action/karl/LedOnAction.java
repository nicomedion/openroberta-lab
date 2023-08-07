package de.fhg.iais.roberta.syntax.action.karl;

import de.fhg.iais.roberta.blockly.generated.Hide;
import de.fhg.iais.roberta.syntax.action.Action;
import de.fhg.iais.roberta.syntax.lang.expr.Expr;
import de.fhg.iais.roberta.transformer.forClass.NepoPhrase;
import de.fhg.iais.roberta.transformer.forField.NepoField;
import de.fhg.iais.roberta.transformer.forField.NepoHide;
import de.fhg.iais.roberta.transformer.forField.NepoValue;
import de.fhg.iais.roberta.util.ast.BlocklyProperties;
import de.fhg.iais.roberta.util.syntax.BlocklyConstants;

@NepoPhrase(category = "ACTOR", blocklyNames = {"actions_eyeLed_on_karl"}, name = "LED_ON_ACTION")
public final class LedOnAction extends Action {
    @NepoField(name = "ACTORPORT")
    public final String eye;
    @NepoValue(name = BlocklyConstants.COLOUR)
    public final Expr colour;
    public LedOnAction(BlocklyProperties properties, String eye, Expr colour){
        super(properties);
        this.eye = eye;
        this.colour = colour;
        setReadOnly();
    }
}
