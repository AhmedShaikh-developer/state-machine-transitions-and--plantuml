package PresentationLayer;

import ApplicationLayer.LoggingSideEffectStrategy;
import ApplicationLayer.MainController;
import ApplicationLayer.PromptUserSideEffectStrategy;
import DomainLayer.FindAbcAndPrintThings;
import DomainLayer.StateMachine;
import DomainLayer.SumOfDigitsEquals3;
import ApplicationLayer.PromptUserSideEffect;

public class Main {

    public static void main(String[] args) {
        StateMachine[] stateMachines = {
                new SumOfDigitsEquals3(new LoggingSideEffectStrategy(System.out)),
                new FindAbcAndPrintThings(new LoggingSideEffectStrategy(System.out))
        };

        MainController mainController = new MainController();
        mainController.runStateMachines(stateMachines);

        PromptUserSideEffectStrategy promptUserStrategy = new PromptUserSideEffectStrategy("Enter your name: ");

        PromptUserSideEffect prompt = new PromptUserSideEffect();
        prompt.setStrategy(promptUserStrategy);

        prompt.execute('A');
    }
}


