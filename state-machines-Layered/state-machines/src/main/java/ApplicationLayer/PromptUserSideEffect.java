package ApplicationLayer;

import DomainLayer.SideEffectStrategy;

public class PromptUserSideEffect implements SideEffect {

    private SideEffectStrategy strategy;

    @Override
    public void setStrategy(SideEffectStrategy strategy) {
        this.strategy = strategy;
    }

    @Override
    public void execute(char next) {
        strategy.execute(next);
    }
}