package predictions.design.draft.action.api;

import predictions.design.draft.definition.entity.EntityDefinition;
import predictions.design.draft.execution.context.Context;

public interface Action {
    void invoke(Context context);
    ActionType getActionType();
    EntityDefinition getContextEntity();
}
