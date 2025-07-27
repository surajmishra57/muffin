package org.example.lld_interview_problems.solutions.part_1_atm;

import java.util.Date;

public class WithdrawalTransaction extends Transaction {

    public WithdrawalTransaction(String accountNumber, double amount, Date date) {
        super(accountNumber, amount, date);
    }

    @Override
    public void process() {

    }
}
