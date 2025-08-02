package org.example.lld_interview_problems.loggingframework;


import org.example.lld_interview_problems.loggingframework.appender.LogAppender;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Logger {
    private LogLevel minLevel;
    private final List<LogAppender> appenders;
    private final ExecutorService executor;


    public Logger(LogLevel minLevel, List<LogAppender> appenders) {
        this.appenders = appenders;
        this.minLevel = minLevel;
        this.executor = Executors.newSingleThreadExecutor();
    }

    public void log(LogLevel level, String msg) {
        if (!level.isAsSeverAs(minLevel)) return;
        LogMassage massage = new LogMassage(level, msg);
        executor.submit(() -> appenders.forEach(a -> a.append(massage)));
    }

    public void shutdown() {
        executor.shutdown();
    }

    public void setMinLevel(LogLevel minLevel) {
        this.minLevel = minLevel;
    }


    public void debug(String message) {
        log(LogLevel.DEBUG, message);
    }

    public void info(String message) {
        log(LogLevel.INFO, message);
    }

    public void warn(String message) {
        log(LogLevel.WARN, message);
    }

    public void fatal(String message) {
        log(LogLevel.FATAL, message);
    }

    public void error(String message) {
        log(LogLevel.ERROR, message);
    }

}
