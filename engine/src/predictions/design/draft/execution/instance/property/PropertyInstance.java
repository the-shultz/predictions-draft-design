package predictions.design.draft.execution.instance.property;

import predictions.design.draft.definition.property.api.PropertyDefinition;

public interface PropertyInstance {
    PropertyDefinition getPropertyDefinition();
    Object getValue();
    void updateValue(Object val);

}
