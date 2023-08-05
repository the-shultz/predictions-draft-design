package predictions.design.draft.rule;

import predictions.design.draft.action.api.Action;

import java.util.ArrayList;
import java.util.List;

public class RuleImpl implements Rule {

    private final String name;
    private Activation activation;
    private final List<Action> actions;

    public RuleImpl(String name) {
        this.name = name;
        actions = new ArrayList<>();
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Activation getActivation() {
        return activation;
    }

    @Override
    public List<Action> getActionsToPerform() {
        return actions;
    }

    @Override
    public void addAction(Action action) {
        actions.add(action);
    }
}
