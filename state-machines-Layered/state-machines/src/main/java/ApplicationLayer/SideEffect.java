package ApplicationLayer;

import DomainLayer.SideEffectStrategy;

public interface SideEffect {
    void setStrategy(SideEffectStrategy strategy);
    void execute(char next);
}
