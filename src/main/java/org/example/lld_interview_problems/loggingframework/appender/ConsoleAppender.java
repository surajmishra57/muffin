package org.example.lld_interview_problems.loggingframework.appender;


import org.example.lld_interview_problems.loggingframework.LogMassage;
import org.example.lld_interview_problems.loggingframework.formatter.LogFormatter;

public class ConsoleAppender implements LogAppender {
    private final LogFormatter formatter;

    public ConsoleAppender(LogFormatter formatter) {
        this.formatter = formatter;
    }

    @Override
    public void append(LogMassage logMassage) {
        System.out.println(formatter.formate(logMassage));
    }
}
