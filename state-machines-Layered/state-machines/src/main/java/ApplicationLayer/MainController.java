package ApplicationLayer;

import DomainLayer.StateMachine;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class MainController {

    public void runStateMachines(StateMachine[] stateMachines) {
        for (StateMachine stateMachine : stateMachines) {
            List<Character> digitsTestCase = Arrays.asList('0', '1', '2', '0');
            List<Character> lettersTestCase = Arrays.asList('A', 'b', 'd', 'A', 'b', 'c', 'd');

            testMachine(stateMachine, lettersTestCase);
            System.out.println();
            testMachine(stateMachine, digitsTestCase);
            System.out.println();
        }
    }

    private void testMachine(StateMachine stateMachine, List<Character> testCase) {
        boolean result;
        System.out.println("Running " + stateMachine.getClass().getSimpleName() + " on " + testCase);

        result = stateMachine.accept(testCase);
        System.out.println("Result: " + result);
    }

}
