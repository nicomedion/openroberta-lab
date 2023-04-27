package de.fhg.iais.roberta.syntax.lang.functions;

import de.fhg.iais.roberta.syntax.lang.expr.Expr;
import de.fhg.iais.roberta.transformer.forClass.NepoPhrase;
import de.fhg.iais.roberta.transformer.forField.NepoValue;
import de.fhg.iais.roberta.typecheck.BlocklyType;
import de.fhg.iais.roberta.util.ast.BlocklyProperties;

@NepoPhrase(category = "FUNCTION", blocklyNames = {"robText_append"}, name = "TEXT_APPEND_FUNCTION")
public final class TextAppendFunct extends Function {

    @NepoValue(name = "VAR", type = BlocklyType.STRING)
    public final Expr var;

    @NepoValue(name = "TEXT", type = BlocklyType.STRING)
    public final Expr text;

    public TextAppendFunct(BlocklyProperties properties, Expr var, Expr text) {
        super(properties);
        this.var = var;
        this.text = text;
        setReadOnly();
    }
}
