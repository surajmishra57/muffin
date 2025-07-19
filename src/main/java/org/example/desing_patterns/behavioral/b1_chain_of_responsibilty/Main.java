package org.example.desing_patterns.behavioral.b1_chain_of_responsibilty;

/**
 *
 *
 *
 *
 *
 *
 */
public class Main {
    public static void main(String[] args) {
        LevelOneSupportHandler levelOneSupportHandler = new LevelOneSupportHandler();
        LevelTwoSupportHandler levelTwoSupportHandler = new LevelTwoSupportHandler();
        LevelThreeSupportHandler levelThreeSupportHandler = new LevelThreeSupportHandler();

        levelOneSupportHandler.setNextHandler(levelTwoSupportHandler);
        levelTwoSupportHandler.setNextHandler(levelThreeSupportHandler);

        Request request1 = new Request(Priority.BASIC);
        Request request2 = new Request(Priority.INTERMEDIATE);
        Request request3 = new Request(Priority.CRITICAL);

        levelOneSupportHandler.handleRequest(request1);
        levelOneSupportHandler.handleRequest(request2);
        levelOneSupportHandler.handleRequest(request3);
    }
}
