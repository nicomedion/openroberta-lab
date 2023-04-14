package de.fhg.iais.roberta.visitor.codegen;

import java.util.List;

import de.fhg.iais.roberta.components.ConfigurationAst;
import de.fhg.iais.roberta.syntax.Phrase;
import de.fhg.iais.roberta.syntax.action.sound.PlayFileAction;
import de.fhg.iais.roberta.syntax.action.sound.SetVolumeAction;
import de.fhg.iais.roberta.util.dbc.Assert;

public class MicrobitStackMachineVisitor extends MbedStackMachineVisitor {

    public MicrobitStackMachineVisitor(ConfigurationAst configuration, List<List<Phrase>> phrases) {
        super(configuration, phrases);
        Assert.isTrue(!phrases.isEmpty());

    }

    @Override
    public Void visitSetVolumeAction(SetVolumeAction setVolumeAction) {
        return null;
    }

    @Override
    public Void visitPlayFileAction(PlayFileAction playFileAction) {
        return null;
    }

}