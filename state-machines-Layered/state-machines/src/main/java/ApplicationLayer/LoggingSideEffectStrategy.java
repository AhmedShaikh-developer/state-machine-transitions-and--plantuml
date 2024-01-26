package ApplicationLayer;

import DomainLayer.SideEffectStrategy;

import java.io.PrintStream;

public class LoggingSideEffectStrategy implements SideEffectStrategy {

    private final PrintStream out;

    public LoggingSideEffectStrategy(PrintStream out) {
        this.out = out;
    }

    @Override
    public void execute(char next) {
        out.println("Logging a message for character: " + next);
    }
}