package de.fhg.iais.roberta.visitor.hardware.actor;

import de.fhg.iais.roberta.syntax.action.light.BrickLightOffAction;
import de.fhg.iais.roberta.syntax.action.light.BrickLightResetAction;
import de.fhg.iais.roberta.syntax.action.light.LightAction;
import de.fhg.iais.roberta.syntax.action.light.LightOffAction;
import de.fhg.iais.roberta.util.dbc.DbcException;
import de.fhg.iais.roberta.visitor.hardware.IHardwareVisitor;

public interface ILightVisitor<V> extends IHardwareVisitor<V> {

    default V visitLightAction(LightAction lightAction) {
        throw new DbcException("light action not implemented!");
    }

    default V visitBrickLightOffAction(BrickLightOffAction brickLightOffAction) {
        throw new DbcException("brick light off action not implemented!");
    }

    default V visitBrickLightResetAction(BrickLightResetAction brickLightResetAction) {
        throw new DbcException("brick light reset action not implemented!");
    }

    default V visitLightOffAction(LightOffAction lightOffAction) {
        throw new DbcException("light off action not implemented!");
    }
}