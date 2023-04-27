package de.fhg.iais.roberta.syntax.lang.functions;

import de.fhg.iais.roberta.syntax.lang.expr.Expr;
import de.fhg.iais.roberta.transformer.forClass.NepoExpr;
import de.fhg.iais.roberta.transformer.forField.NepoValue;
import de.fhg.iais.roberta.typecheck.BlocklyType;
import de.fhg.iais.roberta.util.ast.BlocklyProperties;

@NepoExpr(category = "FUNCTION", blocklyNames = {"math_change", "robMath_change"}, name = "MATH_CHANGE_FUNCTION", blocklyType = BlocklyType.NUMBER)
public final class MathChangeFunct extends Function {

    @NepoValue(name = "VAR", type = BlocklyType.STRING)
    public final Expr var;

    @NepoValue(name = "DELTA", type = BlocklyType.NUMBER_INT)
    public final Expr delta;

    public MathChangeFunct(BlocklyProperties properties, Expr var, Expr delta) {
        super(properties);
        this.var = var;
        this.delta = delta;
        setReadOnly();
    }
}
