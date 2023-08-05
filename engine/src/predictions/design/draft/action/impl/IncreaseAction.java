package predictions.design.draft.action.impl;

import predictions.design.draft.action.api.AbstractAction;
import predictions.design.draft.action.api.ActionType;
import predictions.design.draft.definition.entity.EntityDefinition;
import predictions.design.draft.instance.enitty.manager.EntityInstanceManager;
import predictions.design.draft.instance.environment.api.ActiveEnvironment;
import predictions.design.draft.definition.property.api.PropertyType;
import predictions.design.draft.instance.enitty.EntityInstance;
import predictions.design.draft.instance.property.PropertyInstance;

public class IncreaseAction extends AbstractAction {

    private final String property;
    private final String byExpression;

    public IncreaseAction(EntityDefinition entityDefinition, String property, String byExpression) {
        super(ActionType.INCREASE, entityDefinition);
        this.property = property;
        this.byExpression = byExpression;
    }

    @Override
    public void invoke(EntityInstance entityInstance, ActiveEnvironment activeEnvironment, EntityInstanceManager entityInstanceManager) {
        PropertyInstance propertyInstance = entityInstance.getPropertyByName(property);
        if (!verifyNumericPropertyTYpe(propertyInstance)) {
            throw new IllegalArgumentException("increase action can't operate on a none number property [" + property);
        }

        Integer v = PropertyType.DECIMAL.convert(propertyInstance.getValue());

        // something that evaluates expression to a number, say the result is 5...
        // now you can also access the environment variables through the active environment...
        // PropertyInstance blaPropertyInstance = activeEnvironment.getProperty("bla");
        int x = 5;

        // actual calculation
        int result = x + v;

        // updating result on the property
        propertyInstance.updateValue(result);
    }

    private boolean verifyNumericPropertyTYpe(PropertyInstance propertyValue) {
        return
                PropertyType.DECIMAL.equals(propertyValue.getPropertyDefinition().getType()) || PropertyType.FLOAT.equals(propertyValue.getPropertyDefinition().getType());
    }
}
