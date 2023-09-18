package de.fhg.iais.roberta.syntax.action.karl;

import de.fhg.iais.roberta.syntax.action.Action;
import de.fhg.iais.roberta.transformer.forClass.NepoPhrase;
import de.fhg.iais.roberta.util.ast.BlocklyProperties;

@NepoPhrase(category = "ACTOR", blocklyNames = {"actions_test_karl"}, name = "TEST_KARL_ACTION")
public final class TestKarlAction extends Action {
    public TestKarlAction(BlocklyProperties properties) {
        super(properties);
        this.setReadOnly();
    }
}
