package org.example.desing_patterns.behavioral.b1_chain_of_responsibility_task.solution;

public class ManagerHandler implements SupportHandler {
    SupportHandler nextHandler;

    @Override
    public void handleRequest(SupportTicket supportTicket) {
        if (supportTicket.getIssueType().equals(IssueType.COMPLAINT))
            System.out.println("Your Complaint : " + supportTicket.getProblem());
        else
            System.out.println("Invalid Request");
    }

    @Override
    public void setNextHandler(SupportHandler nextHandler) {
        this.nextHandler = nextHandler;
    }
}
