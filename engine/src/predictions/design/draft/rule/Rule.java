package predictions.design.draft.rule;

import predictions.design.draft.action.api.Action;

import java.util.List;

public interface Rule {
    String getName();
    Activation getActivation();
    List<Action> getActionsToPerform();
    void addAction(Action action);
}
