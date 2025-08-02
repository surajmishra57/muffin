package org.example.lld_interview_problems.loggingframework;

public class LogMassage {
    private final LogLevel logLevel;
    private final String message;
    private final long timestamp;
    private final String threadName;


    public LogMassage(LogLevel logLevel, String message) {
        this.logLevel = logLevel;
        this.message = message;
        this.timestamp = System.currentTimeMillis();
        this.threadName = Thread.currentThread().getName();
    }

    public LogLevel getLogLevel() {
        return logLevel;
    }

    public String getMessage() {
        return message;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public String getThreadName() {
        return threadName;
    }

    @Override
    public String toString() {
        return "[" + logLevel + "] " + timestamp + " - " + message;
    }
}
