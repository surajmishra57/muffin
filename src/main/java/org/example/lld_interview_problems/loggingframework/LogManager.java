package org.example.lld_interview_problems.loggingframework;


import org.example.lld_interview_problems.loggingframework.appender.ConsoleAppender;
import org.example.lld_interview_problems.loggingframework.appender.FileAppender;
import org.example.lld_interview_problems.loggingframework.appender.LogAppender;
import org.example.lld_interview_problems.loggingframework.formatter.SimpleFormatter;

import java.util.ArrayList;
import java.util.List;

public class LogManager {
    private static volatile Logger logger;

    public static Logger getLogger() {
        if (logger == null) {
            synchronized (LogManager.class) {
                if (logger == null) {
                    logger = new LoggerBuilder()
                            .setLevel(LogLevel.INFO)
                            .addAppender(new ConsoleAppender(new SimpleFormatter()))
                            .addAppender(new FileAppender("./file1.txt",new SimpleFormatter()))
                            .build();
                }
            }
        }
        return logger;
    }


    public static class LoggerBuilder {
        private LogLevel level = LogLevel.INFO;
        private final List<LogAppender> appenders = new ArrayList<>();

        public LoggerBuilder setLevel(LogLevel level) {
            this.level = level;
            return this;
        }

        public LoggerBuilder addAppender(LogAppender logAppender) {
            this.appenders.add(logAppender);
            return this;
        }

        public Logger build() {
            return new Logger(level, appenders);
        }
    }
}
