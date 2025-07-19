package org.example.desing_patterns.behavioral.b1_chain_of_responsibility_task.solution;

public class FirstLevelSupportHandler implements SupportHandler {
    SupportHandler nextHandler;

    @Override
    public void handleRequest(SupportTicket supportTicket) {
        if (supportTicket.getIssueType().equals(IssueType.GENERAL)) {
            System.out.println("your problem : " + supportTicket.getProblem());

        } else {
            nextHandler.handleRequest(supportTicket);
        }

    }

    @Override
    public void setNextHandler(SupportHandler nextHandler) {
        this.nextHandler = nextHandler;
    }
}
