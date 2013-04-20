package javarepl.console.commands;

import javarepl.Evaluator;
import javarepl.console.ConsoleLogger;
import jline.console.completer.StringsCompleter;

import static com.googlecode.totallylazy.Predicates.equalTo;

public class QuitApplication extends Command {
    private static final String COMMAND = ":quit";

    public QuitApplication(ConsoleLogger logger) {
        super(COMMAND + " - quit application", equalTo(COMMAND).or(equalTo(null)), new StringsCompleter(COMMAND), logger);
    }

    public CommandResult call(Evaluator evaluator, String expression) throws Exception {
        CommandResultCollector resultCollector = createResultCollector(expression);
        resultCollector.logInfo("Terminating...");
        evaluator.clearOutputDirectory();
        System.exit(0);
        return resultCollector.result();
    }
}
