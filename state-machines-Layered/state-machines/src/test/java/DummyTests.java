import ApplicationLayer.LoggingSideEffectStrategy;
import ApplicationLayer.PromptUserSideEffect;
import ApplicationLayer.PromptUserSideEffectStrategy;
import DomainLayer.FindAbcAndPrintThings;
import DomainLayer.StateMachine;
import DomainLayer.SumOfDigitsEquals3;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class DummyTests {

    @Test
    public void testSumOfDigitsEquals3() {
        StateMachine sumStateMachine = new SumOfDigitsEquals3(new LoggingSideEffectStrategy(System.out));

        assertTrue(sumStateMachine.accept(List.of('0', '1', '2')));
        assertFalse(sumStateMachine.accept(List.of('1', '1', '1')));
        assertTrue(sumStateMachine.accept(List.of('2', '1')));
        assertFalse(sumStateMachine.accept(List.of('2', '2', '2')));
    }

    @Test
    public void testFindAbcAndPrintThings() {
        StateMachine findAbcStateMachine = new FindAbcAndPrintThings(new LoggingSideEffectStrategy(System.out));

        assertTrue(findAbcStateMachine.accept(List.of('A', 'b', 'c')));
        assertFalse(findAbcStateMachine.accept(List.of('A', 'b', 'd')));
        assertTrue(findAbcStateMachine.accept(List.of('A', 'b', 'c', 'A', 'b', 'c')));
        assertFalse(findAbcStateMachine.accept(List.of('A', 'b', 'c', 'd', 'A')));
    }

    @Test
    public void testPromptUserSideEffect() {

        PromptUserSideEffectStrategy promptUserStrategy = new PromptUserSideEffectStrategy("Enter your name: ");
        PromptUserSideEffect prompt = new PromptUserSideEffect();
        prompt.setStrategy(promptUserStrategy);

        prompt.execute('A');
    }
}
