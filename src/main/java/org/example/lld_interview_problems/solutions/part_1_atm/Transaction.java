package org.example.lld_interview_problems.solutions.part_1_atm;

import java.util.Date;

public abstract class Transaction {
    private String accountNumber;
    private double amount;
    private Date date;

    public Transaction(String accountNumber, double amount, Date date) {
        this.accountNumber = accountNumber;
        this.amount = amount;
        this.date = date;
    }

    public abstract void process();
}
