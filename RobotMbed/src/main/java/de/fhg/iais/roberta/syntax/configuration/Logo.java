package de.fhg.iais.roberta.syntax.configuration;

import de.fhg.iais.roberta.transformer.forClass.NepoConfiguration;
import de.fhg.iais.roberta.util.dbc.DbcException;

@NepoConfiguration(name = "LOGO", category = "CONFIGURATION_BLOCK",
    blocklyNames = {"robConf_logo"})
public final class Logo extends ConfigurationComponent {
    private Logo() {
        super(null, true, null, null, null);
        throw new DbcException("should NEVER be called");
    }
}
