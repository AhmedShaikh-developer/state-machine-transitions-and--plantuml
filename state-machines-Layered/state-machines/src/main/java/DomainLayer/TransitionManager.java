package DomainLayer;

import java.util.List;

public class TransitionManager {

    private List<Transition> transitions;

    public TransitionManager(List<Transition> transitions) {
        this.transitions = transitions;
    }

    public boolean processInput(int currentState, List<Character> streamOfChars, SideEffect sideEffect) {
        if (streamOfChars.isEmpty()) {
            return isFinalState(currentState);
        }

        char nextChar = streamOfChars.remove(0);

        for (Transition transition : transitions) {
            if (transition.state == currentState && (transition.nextChar == nextChar || transition.nextChar == '*')) {
                if (sideEffect != null) {
                    sideEffect.execute();
                }

                return processInput(transition.nextState, streamOfChars, sideEffect);
            }
        }

        for (Transition transition : transitions) {
            if (transition.state == currentState && transition.nextChar == '*') {

                if (sideEffect != null) {
                    sideEffect.execute();
                }

                return processInput(transition.nextState, streamOfChars, sideEffect);
            }
        }

        return false;
    }

    private boolean isFinalState(int state) {
        return state == 3; // State 3 is the final state in SumOfDigitsEquals3
    }
}