package DomainLayer;

import java.util.List;

public interface StateMachine {
    boolean accept(List<Character> streamOfChars);
    void setSideEffect(SideEffect sideEffect);

}
