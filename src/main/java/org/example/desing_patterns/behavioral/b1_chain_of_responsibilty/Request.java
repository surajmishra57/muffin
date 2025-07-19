package org.example.desing_patterns.behavioral.b1_chain_of_responsibilty;

public class Request {
    Priority priority;

    public Request(Priority priority) {
        this.priority = priority;
    }

    public Priority getPriority() {
        return priority;
    }
}
