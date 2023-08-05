package predictions.design.draft;

import predictions.design.draft.definition.property.impl.IntegerPropertyDefinition;
import predictions.design.draft.definition.value.generator.api.ValueGeneratorFactory;

public class Main {

    public static void main(String[] args) {

        IntegerPropertyDefinition agePropertyDefinition = new IntegerPropertyDefinition("age", ValueGeneratorFactory.createRandomInteger(10, 50));
        IntegerPropertyDefinition smokingInDayPropertyDefinition = new IntegerPropertyDefinition("smokingInDay", ValueGeneratorFactory.createFixed(10));

    }


}
