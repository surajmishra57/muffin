package org.example.desing_patterns.behavioral.b1_chain_of_responsibility_task.solution;

public class Main {
    public static void main(String[] args) {
        FirstLevelSupportHandler firstLevelSupportHandler = new FirstLevelSupportHandler();
        SecondLevelSupportHandler secondLevelSupportHandler = new SecondLevelSupportHandler();
        ManagerHandler managerHandler = new ManagerHandler();

        firstLevelSupportHandler.setNextHandler(secondLevelSupportHandler);
        secondLevelSupportHandler.setNextHandler(managerHandler);

        SupportTicket supportTicket1 = new SupportTicket(IssueType.COMPLAINT, "My PC NOT WORKING");
        SupportTicket supportTicket2 = new SupportTicket(IssueType.TECHNICAL, "SOME APPLICATIN IS CRASH");
        SupportTicket supportTicket3 = new SupportTicket(IssueType.GENERAL, "How To login");
        SupportTicket supportTicket4 = new SupportTicket(IssueType.NONE, "hehehee..");

        firstLevelSupportHandler.handleRequest(supportTicket1);
        firstLevelSupportHandler.handleRequest(supportTicket2);
        firstLevelSupportHandler.handleRequest(supportTicket3);
        firstLevelSupportHandler.handleRequest(supportTicket4);

    }
}
