package predictions.design.draft.definition.environment.api;

import predictions.design.draft.definition.property.api.PropertyDefinition;
import predictions.design.draft.execution.instance.environment.api.ActiveEnvironment;

import java.util.Collection;

public interface EnvVariablesManager {
    void addEnvironmentVariable(PropertyDefinition propertyDefinition);
    ActiveEnvironment createActiveEnvironment();
    Collection<PropertyDefinition> getEnvVariables();
}
