package predictions.design.draft.action.api;

import predictions.design.draft.definition.entity.EntityDefinition;
import predictions.design.draft.instance.enitty.manager.EntityInstanceManager;
import predictions.design.draft.instance.environment.api.ActiveEnvironment;
import predictions.design.draft.instance.enitty.EntityInstance;

public interface Action {
    void invoke(EntityInstance entityInstance, ActiveEnvironment activeEnvironment, EntityInstanceManager entityInstanceManager);
    ActionType getActionType();
    EntityDefinition getContextEntity();
}
