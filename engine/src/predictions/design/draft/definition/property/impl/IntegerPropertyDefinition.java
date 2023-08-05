package predictions.design.draft.definition.property.impl;

import predictions.design.draft.definition.property.api.AbstractPropertyDefinition;
import predictions.design.draft.definition.property.api.PropertyType;
import predictions.design.draft.definition.value.generator.api.ValueGenerator;

public class IntegerPropertyDefinition extends AbstractPropertyDefinition<Integer> {

    public IntegerPropertyDefinition(String name, ValueGenerator<Integer> valueGenerator) {
        super(name, PropertyType.DECIMAL, valueGenerator);
    }

}
