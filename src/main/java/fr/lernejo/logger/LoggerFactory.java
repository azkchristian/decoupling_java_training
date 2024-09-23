package fr.lernejo.logger;

import java.util.function.Predicate;

public class LoggerFactory {
    public static Logger getLogger(String name) {
        Logger consoleLogger = new ContextualLogger(name, new ConsoleLogger());
        Predicate<String> condition = message -> message.contains("simulation");
        Logger fileLogger = new FilteredLogger(new ContextualLogger(name, new FileLogger("log.txt")), condition);
        return new CompositeLogger(consoleLogger, fileLogger);
    }
}
