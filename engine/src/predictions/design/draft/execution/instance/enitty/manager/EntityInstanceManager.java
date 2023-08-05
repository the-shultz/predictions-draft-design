package predictions.design.draft.execution.instance.enitty.manager;

import predictions.design.draft.definition.entity.EntityDefinition;
import predictions.design.draft.execution.instance.enitty.EntityInstance;

import java.util.List;

public interface EntityInstanceManager {

    EntityInstance create(EntityDefinition entityDefinition);
    List<EntityInstance> getInstances();

    void killEntity(int id);
}
