package org.example.lld_interview_problems.solutions.part_1_atm;

import java.util.Date;

public class DepositTransaction extends Transaction {
    public DepositTransaction(String accountNumber, double amount, Date date) {
        super(accountNumber, amount, date);
    }

    @Override
    public void process() {

    }
}
