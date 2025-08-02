package org.example.lld_interview_problems.loggingframework;

public enum LogLevel {
    DEBUG, INFO, WARN, ERROR, FATAL;

    public boolean isAsSeverAs(LogLevel other) {
        return this.ordinal() >= other.ordinal();
    }

}
