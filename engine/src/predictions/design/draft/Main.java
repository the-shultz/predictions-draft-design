package predictions.design.draft;

import predictions.design.draft.action.impl.IncreaseAction;
import predictions.design.draft.definition.entity.EntityDefinition;
import predictions.design.draft.definition.entity.EntityDefinitionImpl;
import predictions.design.draft.instance.environment.api.ActiveEnvironment;
import predictions.design.draft.definition.environment.api.EnvVariablesManager;
import predictions.design.draft.definition.environment.impl.EnvVariableManagerImpl;
import predictions.design.draft.definition.property.impl.IntegerPropertyDefinition;
import predictions.design.draft.definition.value.generator.api.ValueGeneratorFactory;
import predictions.design.draft.instance.enitty.EntityInstance;
import predictions.design.draft.instance.enitty.manager.EntityInstanceManager;
import predictions.design.draft.instance.enitty.manager.EntityInstanceManagerImpl;
import predictions.design.draft.instance.property.PropertyInstanceImpl;
import predictions.design.draft.rule.Rule;
import predictions.design.draft.rule.RuleImpl;

public class Main {

    public static void main(String[] args) {

        // definition phase - happens as part of file read and validity checks
        IntegerPropertyDefinition agePropertyDefinition = new IntegerPropertyDefinition("age", ValueGeneratorFactory.createRandomInteger(10, 50));
        IntegerPropertyDefinition smokingInDayPropertyDefinition = new IntegerPropertyDefinition("smokingInDay", ValueGeneratorFactory.createFixed(10));

        EntityDefinition smokerEntityDefinition = new EntityDefinitionImpl("smoker", 100);
        smokerEntityDefinition.getProps().add(agePropertyDefinition);
        smokerEntityDefinition.getProps().add(smokingInDayPropertyDefinition);

        // define rules by creating instances of actions
        Rule rule1 = new RuleImpl("rule 1");
        rule1.addAction(new IncreaseAction(smokerEntityDefinition, "age", "1"));
        rule1.addAction(new IncreaseAction(smokerEntityDefinition, "smokingInDay", "3"));

        EnvVariablesManager envVariablesManager = new EnvVariableManagerImpl();
        IntegerPropertyDefinition taxAmountEnvironmentVariablePropertyDefinition = new IntegerPropertyDefinition("tax-amount", ValueGeneratorFactory.createRandomInteger(10, 100));
        envVariablesManager.addEnvironmentVariable(taxAmountEnvironmentVariablePropertyDefinition);




        // execution phase - happens upon command 3

        // initialization phase

        // creating entity instance manager
        EntityInstanceManager entityInstanceManager = new EntityInstanceManagerImpl();

        // create 3 instance of the smokerEntityDefinition smoker
        for (int i = 0; i < smokerEntityDefinition.getPopulation(); i++) {
            entityInstanceManager.create(smokerEntityDefinition);
        }

        // create env variable instance
        ActiveEnvironment activeEnvironment = envVariablesManager.createActiveEnvironment();
        // all available environment variable with their definition
//        for (PropertyDefinition propertyDefinition : envVariablesManager.getEnvVariables()) {

            // collect value from user...
            int valueFromUser = 54;
            activeEnvironment.addPropertyInstance(new PropertyInstanceImpl(taxAmountEnvironmentVariablePropertyDefinition, valueFromUser));
//        }

        // all env variable not inserted by user, needs to be generated randomly. lucky we have all data needed for it...
        //Integer randomEnvVariableValue = taxAmountEnvironmentVariablePropertyDefinition.generateValue();
        //activeEnvironment.addPropertyInstance(new PropertyInstanceImpl(taxAmountEnvironmentVariablePropertyDefinition, randomEnvVariableValue));

        // during a tick...

        // given an instance...
        EntityInstance entityInstance = entityInstanceManager.getInstances().get(0);

        if (rule1.getActivation().isActive(1)) {
            rule1
                    .getActionsToPerform()
                    .forEach(action ->
                            action.invoke(entityInstance, activeEnvironment));
        }
    }


}
