package org.example.lld_interview_problems.loggingframework.formatter;


import org.example.lld_interview_problems.loggingframework.LogMassage;

public class SimpleFormatter implements LogFormatter {
    @Override
    public String formate(LogMassage massage) {
        return String.format(
                "[%s] [%s] [%s] : %s",
                massage.getTimestamp(),
                massage.getLogLevel(),
                massage.getThreadName(),
                massage.getMessage()
        );
    }
}
