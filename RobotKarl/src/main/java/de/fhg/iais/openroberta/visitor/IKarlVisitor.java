package de.fhg.iais.openroberta.visitor;

import de.fhg.iais.roberta.syntax.action.spike.PlayNoteAction;
import de.fhg.iais.roberta.syntax.action.spike.PlayToneAction;
import de.fhg.iais.roberta.syntax.sensor.generic.KeysSensor;
import de.fhg.iais.roberta.visitor.IVisitor;

public interface IKarlVisitor<V> extends IVisitor<V> {

    V visitKeysSensor(KeysSensor keysSensor);
    V visitPlayToneAction(PlayToneAction playToneAction);
    V visitPlayNoteAction(PlayNoteAction playNoteAction);

}
