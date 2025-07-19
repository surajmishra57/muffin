package org.example.desing_patterns.behavioral.b1_chain_of_responsibilty;

public class LevelTwoSupportHandler implements SupportHandler {
    SupportHandler nextHandler;

    @Override
    public void handleRequest(Request request) {
        if (request.getPriority() == Priority.INTERMEDIATE) {
            System.out.println("This Request Is Handled By Level Two Handler");
        } else {
            nextHandler.handleRequest(request);
        }
    }

    @Override
    public void setNextHandler(SupportHandler nextHandler) {
        this.nextHandler = nextHandler;
    }
}
