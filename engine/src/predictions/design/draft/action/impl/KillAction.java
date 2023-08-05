package predictions.design.draft.action.impl;

import predictions.design.draft.action.api.AbstractAction;
import predictions.design.draft.action.api.ActionType;
import predictions.design.draft.definition.entity.EntityDefinition;
import predictions.design.draft.instance.enitty.EntityInstance;
import predictions.design.draft.instance.enitty.manager.EntityInstanceManager;
import predictions.design.draft.instance.environment.api.ActiveEnvironment;

public class KillAction extends AbstractAction {

    public KillAction(EntityDefinition entityDefinition) {
        super(ActionType.KILL, entityDefinition);
    }

    @Override
    public void invoke(EntityInstance entityInstance, ActiveEnvironment activeEnvironment, EntityInstanceManager entityInstanceManager) {
        entityInstanceManager.killEntity(entityInstance.getId());
    }

}
