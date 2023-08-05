package predictions.design.draft.definition.property.impl;

import predictions.design.draft.definition.property.api.AbstractPropertyDefinition;
import predictions.design.draft.definition.property.api.PropertyType;
import predictions.design.draft.definition.value.generator.api.ValueGenerator;

public class StringPropertyDefinition extends AbstractPropertyDefinition<String> {

    public StringPropertyDefinition(String name, ValueGenerator<String> valueGenerator) {
        super(name, PropertyType.STRING, valueGenerator);
    }

}