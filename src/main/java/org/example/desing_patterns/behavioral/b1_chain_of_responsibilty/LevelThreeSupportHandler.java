package org.example.desing_patterns.behavioral.b1_chain_of_responsibilty;

public class LevelThreeSupportHandler implements SupportHandler {
    SupportHandler supportHandler;

    @Override
    public void handleRequest(Request request) {
        if (request.getPriority() == Priority.CRITICAL) {
            System.out.println("this request is handled by LevelThree Handler");
        } else {
            supportHandler.handleRequest(request);
        }
    }

    @Override
    public void setNextHandler(SupportHandler nextHandler) {
        supportHandler = nextHandler;
    }
}
