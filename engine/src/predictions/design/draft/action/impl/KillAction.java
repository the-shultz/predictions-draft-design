package predictions.design.draft.action.impl;

import predictions.design.draft.action.api.AbstractAction;
import predictions.design.draft.action.api.ActionType;
import predictions.design.draft.definition.entity.EntityDefinition;
import predictions.design.draft.execution.context.Context;

public class KillAction extends AbstractAction {

    public KillAction(EntityDefinition entityDefinition) {
        super(ActionType.KILL, entityDefinition);
    }

    @Override
    public void invoke(Context context) {
        context.removeEntity(context.getPrimaryEntityInstance());
    }

}
