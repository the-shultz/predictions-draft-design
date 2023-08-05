package predictions.design.draft;

import predictions.design.draft.definition.entity.EntityDefinition;
import predictions.design.draft.definition.entity.EntityDefinitionImpl;
import predictions.design.draft.definition.property.impl.IntegerPropertyDefinition;
import predictions.design.draft.definition.value.generator.api.ValueGeneratorFactory;
import predictions.design.draft.instance.enitty.manager.EntityInstanceManager;
import predictions.design.draft.instance.enitty.manager.EntityInstanceManagerImpl;

public class Main {

    public static void main(String[] args) {

        IntegerPropertyDefinition agePropertyDefinition = new IntegerPropertyDefinition("age", ValueGeneratorFactory.createRandomInteger(10, 50));
        IntegerPropertyDefinition smokingInDayPropertyDefinition = new IntegerPropertyDefinition("smokingInDay", ValueGeneratorFactory.createFixed(10));

        EntityDefinition smokerEntityDefinition = new EntityDefinitionImpl("smoker", 100);
        smokerEntityDefinition.getProps().add(agePropertyDefinition);
        smokerEntityDefinition.getProps().add(smokingInDayPropertyDefinition);


        // creating entity instance manager
        EntityInstanceManager entityInstanceManager = new EntityInstanceManagerImpl();

        // create 3 instance of the smokerEntityDefinition smoker
        for (int i = 0; i < smokerEntityDefinition.getPopulation(); i++) {
            entityInstanceManager.create(smokerEntityDefinition);
        }
    }


}
