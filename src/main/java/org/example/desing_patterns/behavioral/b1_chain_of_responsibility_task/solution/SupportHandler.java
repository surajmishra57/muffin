package org.example.desing_patterns.behavioral.b1_chain_of_responsibility_task.solution;

public interface SupportHandler {
    void handleRequest(SupportTicket supportTicket);

    void setNextHandler(SupportHandler nextHandler);
}
