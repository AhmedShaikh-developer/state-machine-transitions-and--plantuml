package ApplicationLayer;

import DomainLayer.SideEffectStrategy;

import java.util.Scanner;

public class PromptUserSideEffectStrategy implements SideEffectStrategy {

    public PromptUserSideEffectStrategy(String s) {
    }

    @Override
    public void execute(char next) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter your name: ");
            String input = scanner.nextLine();
            System.out.println("You entered: " + input);
        }
    }
}
