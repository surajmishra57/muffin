package org.example.desing_patterns.behavioral.b1_chain_of_responsibility_task.solution;

public class SupportTicket {
    private IssueType issueType;
    private String problem;

    public SupportTicket(IssueType issueType, String problem) {
        this.issueType = issueType;
        this.problem = problem;
    }

    public IssueType getIssueType() {
        return issueType;
    }

    public String getProblem() {
        return problem;
    }
}
