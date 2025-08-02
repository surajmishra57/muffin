package org.example.lld_interview_problems.loggingframework;

public class Main {
    public static void main(String[] args) {
        run();
    }

    public static void run() {
        Logger logger = LogManager.getLogger();
        logger.setMinLevel(LogLevel.FATAL);
        logger.debug("this is debug");
        logger.info("this is info");
        logger.error("this is error");
        logger.fatal("this is fatal");
        logger.warn("this is warn");

        logger.shutdown();
    }
}
