package org.example.lld_interview_problems.loggingframework.appender;


import org.example.lld_interview_problems.loggingframework.LogMassage;
import org.example.lld_interview_problems.loggingframework.formatter.LogFormatter;

import java.io.FileWriter;

public class FileAppender implements LogAppender {
    private FileWriter writer;
    private final LogFormatter formatter;

    public FileAppender(String filePath, LogFormatter formatter) {
        this.formatter = formatter;
        try {
            this.writer = new FileWriter(filePath, true);
        } catch (Exception e) {
            System.out.println("fail to create writer for file write cause " + e.getMessage());
        }
    }

    @Override
    public void append(LogMassage logMassage) {
        try {
            writer.write(formatter.formate(logMassage) + "\n");
            writer.flush();
        } catch (Exception e) {
            System.out.println("fail to write logs to file exception : " + e.getMessage());
        }
    }
}
