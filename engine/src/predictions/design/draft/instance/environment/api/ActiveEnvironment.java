package predictions.design.draft.instance.environment.api;

import predictions.design.draft.instance.property.PropertyInstance;

public interface ActiveEnvironment {
    PropertyInstance getProperty(String name);
    void addPropertyInstance(PropertyInstance propertyInstance);
}
