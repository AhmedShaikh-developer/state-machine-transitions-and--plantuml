package DomainLayer;

import ApplicationLayer.LoggingSideEffectStrategy;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.LinkedList;
import java.util.List;

public class FindAbcAndPrintThings implements StateMachine {
    int state = 'A';
    static final int FINAL_STATE = 'f';

    private List<Transition> transitions;
    public FindAbcAndPrintThings(LoggingSideEffectStrategy loggingSideEffectStrategy) {
        transitions = new LinkedList<Transition>();
        transitions.add(new Transition('A', 'A', 'b'));
        transitions.add(new Transition('A', '*', 'A'));
        transitions.add(new Transition('b', 'b', 'c'));
        transitions.add(new Transition('b', 'A', 'b'));
        transitions.add(new Transition('b', '*', 'A'));
        transitions.add(new Transition('c', 'c', FINAL_STATE));
        transitions.add(new Transition('c', 'A', 'b'));
        transitions.add(new Transition('c', '*', 'A'));
        transitions.add(new Transition(FINAL_STATE, '*', FINAL_STATE));
    }

    @Override
    public synchronized boolean accept(List<Character> streamOfChars) {
        state = 'A';
        return findAbcAndPrintThings(streamOfChars);
    }

    @Override
    public void setSideEffect(SideEffect sideEffect) {

    }

    public boolean findAbcAndPrintThings(List<Character> streamOfChars) {

        if (streamOfChars.isEmpty()) {
            return state == FINAL_STATE;
        }

        List<Character> mutableStream = new LinkedList<>(streamOfChars);

        char next = mutableStream.remove(0);

        for (Transition transition : transitions) {
            if (transition.state == state && (transition.nextChar == next || transition.nextChar == '*')) {
                runAppropriateSideEffect(next);
                state = transition.nextState;
                return findAbcAndPrintThings(mutableStream);
            }
        }

        return false;
    }

    private void runAppropriateSideEffect(char next) {

        try(PrintStream out = new PrintStream(new FileOutputStream("log.txt", true))){
            if (state == 'A') {
                if (next == 'A') {
                    out.println("Found the " + next);
                } else {

                    out.println("Did not find the A. Still looking for A...");
                }
            } else if (state == 'b') {
                if (next == 'b') {
                    out.println("Found the " + next);
                } else if (next == 'A') {
                    out.println("Saw another A, going to b");
                } else {
                    out.println("Did not find the b. Restarting the search...");
                }
            } else if (state == 'c') {
                if (next == 'c') {
                    out.println("Found the " + next);
                } else if (next == 'A') {
                    out.println("Saw another A, going to b");
                } else {
                    out.println("Did not find the c. Restarting the search...");
                }
            } else if (state == FINAL_STATE) {
                out.println("In the final state, saw a meaningless " + next);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
