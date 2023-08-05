package predictions.design.draft;

import predictions.design.draft.action.impl.IncreaseAction;
import predictions.design.draft.definition.entity.EntityDefinition;
import predictions.design.draft.definition.entity.EntityDefinitionImpl;
import predictions.design.draft.definition.property.impl.IntegerPropertyDefinition;
import predictions.design.draft.definition.value.generator.api.ValueGeneratorFactory;
import predictions.design.draft.instance.enitty.EntityInstance;
import predictions.design.draft.instance.enitty.manager.EntityInstanceManager;
import predictions.design.draft.instance.enitty.manager.EntityInstanceManagerImpl;
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

        // execution phase - happens upon command 3

        // creating entity instance manager
        EntityInstanceManager entityInstanceManager = new EntityInstanceManagerImpl();

        // create 3 instance of the smokerEntityDefinition smoker
        for (int i = 0; i < smokerEntityDefinition.getPopulation(); i++) {
            entityInstanceManager.create(smokerEntityDefinition);
        }

        // given an instance...
        EntityInstance entityInstance = entityInstanceManager.getInstances().get(0);

        if (rule1.getActivation().isActive(1)) {
            rule1
                    .getActionsToPerform()
                    .forEach(action ->
                            action.invoke(entityInstance));
        }
    }


}
