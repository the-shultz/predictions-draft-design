package predictions.design.draft.execution.context;

import predictions.design.draft.execution.instance.enitty.EntityInstance;
import predictions.design.draft.execution.instance.property.PropertyInstance;

public interface Context {
    EntityInstance getPrimaryEntityInstance();
    void removeEntity(EntityInstance entityInstance);
    PropertyInstance getEnvironmentVariable(String name);
}
