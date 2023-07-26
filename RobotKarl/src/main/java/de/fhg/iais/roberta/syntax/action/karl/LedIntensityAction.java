package de.fhg.iais.roberta.syntax.action.karl;

import de.fhg.iais.roberta.blockly.generated.Hide;
import de.fhg.iais.roberta.syntax.action.Action;
import de.fhg.iais.roberta.syntax.lang.expr.Expr;
import de.fhg.iais.roberta.transformer.forClass.NepoPhrase;
import de.fhg.iais.roberta.transformer.forField.NepoHide;
import de.fhg.iais.roberta.transformer.forField.NepoValue;
import de.fhg.iais.roberta.typecheck.BlocklyType;
import de.fhg.iais.roberta.util.ast.BlocklyProperties;
import de.fhg.iais.roberta.util.syntax.BlocklyConstants;

@NepoPhrase(category = "ACTOR", blocklyNames = {"actions_eyeLed_intensity_karl"}, name = "LED_INTENSITY_ACTION")

public final class LedIntensityAction extends Action {
    @NepoHide
    public final Hide eye;
    @NepoValue(name = BlocklyConstants.INTENSITY, type = BlocklyType.NUMBER_INT)
    public final Expr intensity;
    public LedIntensityAction(BlocklyProperties properties, Hide eye, Expr intensity) {
        super(properties);
        this.eye = eye;
        this.intensity = intensity;
    }
}
