package predictions.design.draft.instance.enitty.manager;

import predictions.design.draft.definition.entity.EntityDefinition;
import predictions.design.draft.instance.enitty.EntityInstance;

import java.util.List;

public interface EntityInstanceManager {

    EntityInstance create(EntityDefinition entityDefinition);
    List<EntityInstance> getInstances();

}
