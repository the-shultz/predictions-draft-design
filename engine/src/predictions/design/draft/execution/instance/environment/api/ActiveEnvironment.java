package predictions.design.draft.execution.instance.environment.api;

import predictions.design.draft.execution.instance.property.PropertyInstance;

public interface ActiveEnvironment {
    PropertyInstance getProperty(String name);
    void addPropertyInstance(PropertyInstance propertyInstance);
}
