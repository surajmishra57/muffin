package org.example.desing_patterns.behavioral.b1_chain_of_responsibilty;

public class LevelOneSupportHandler implements SupportHandler {
    SupportHandler nextSupportHandler;

    @Override
    public void handleRequest(Request request) {
        if (request.getPriority() == Priority.BASIC) {
            System.out.println("this request handled By first handler");
        } else {
            nextSupportHandler.handleRequest(request);
        }
    }

    @Override
    public void setNextHandler(SupportHandler nextHandler) {
        nextSupportHandler = nextHandler;
    }
}
