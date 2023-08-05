package predictions.design.draft.execution.context;

import predictions.design.draft.execution.instance.enitty.EntityInstance;
import predictions.design.draft.execution.instance.enitty.manager.EntityInstanceManager;
import predictions.design.draft.execution.instance.environment.api.ActiveEnvironment;
import predictions.design.draft.execution.instance.property.PropertyInstance;

public class ContextImpl implements Context {

    private EntityInstance primaryEntityInstance;
    private EntityInstanceManager entityInstanceManager;
    private ActiveEnvironment activeEnvironment;

    public ContextImpl(EntityInstance primaryEntityInstance, EntityInstanceManager entityInstanceManager, ActiveEnvironment activeEnvironment) {
        this.primaryEntityInstance = primaryEntityInstance;
        this.entityInstanceManager = entityInstanceManager;
        this.activeEnvironment = activeEnvironment;
    }

    @Override
    public EntityInstance getPrimaryEntityInstance() {
        return primaryEntityInstance;
    }

    @Override
    public void removeEntity(EntityInstance entityInstance) {
        entityInstanceManager.killEntity(entityInstance.getId());
    }

    @Override
    public PropertyInstance getEnvironmentVariable(String name) {
        return activeEnvironment.getProperty(name);
    }
}
