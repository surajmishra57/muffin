package org.example.desing_patterns.behavioral.b1_chain_of_responsibilty;

public interface SupportHandler {
    void handleRequest(Request request);

    void setNextHandler(SupportHandler nextHandler);
}
