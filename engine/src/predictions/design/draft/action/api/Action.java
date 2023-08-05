package predictions.design.draft.action.api;

import predictions.design.draft.definition.entity.EntityDefinition;
import predictions.design.draft.instance.enitty.EntityInstance;

public interface Action {
    void invoke(EntityInstance entityInstance);
    ActionType getActionType();
    EntityDefinition getContextEntity();
}
