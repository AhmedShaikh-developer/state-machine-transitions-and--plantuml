package DomainLayer;

import ApplicationLayer.LoggingSideEffectStrategy;

import java.util.LinkedList;
import java.util.List;

public class SumOfDigitsEquals3 implements StateMachine {

    private SideEffect sideEffect;
    private List<Transition> transitions;
    public SumOfDigitsEquals3(LoggingSideEffectStrategy loggingSideEffectStrategy) {
        transitions = new LinkedList<Transition>();
        transitions.add(new Transition(0, '0', 0));
        transitions.add(new Transition(0, '1', 1));
        transitions.add(new Transition(0, '2', 2));
        transitions.add(new Transition(0, '3', 3));
        transitions.add(new Transition(1, '0', 1));
        transitions.add(new Transition(1, '1', 2));
        transitions.add(new Transition(1, '2', 3));
        transitions.add(new Transition(2, '0', 2));
        transitions.add(new Transition(2, '1', 3));
        transitions.add(new Transition(3, '0', 3));
    }
    @Override
    public boolean accept(List<Character> streamOfChars) {
        return sumOfDigitsEquals3(0, new LinkedList<>(streamOfChars));
    }

    @Override
    public void setSideEffect(SideEffect sideEffect) {
        this.sideEffect = sideEffect;
    }

    public boolean sumOfDigitsEquals3(int sum, List<Character> streamOfChars) {
        if (streamOfChars.isEmpty()) {
            return sum == 3;
        }

        char next = streamOfChars.remove(0);

        for(Transition transition: transitions) {
            if(transition.state == sum && transition.nextChar == next) {
                return sumOfDigitsEquals3(transition.nextState, streamOfChars);
            }
        }

        return false;
    }
}
