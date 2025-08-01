package org.example.lld_interview_problems.solutions.part_1_atm;

import java.util.HashMap;
import java.util.Map;

public class Account {
    private String accountNumber;
    private double balance;
    private Map<String, Card> cards;

    public Account(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.cards = new HashMap<>();
    }


    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public Map<String, Card> getCards() {
        return cards;
    }

    public synchronized boolean withdraw(double amount) {
        if (balance >= amount) {
            this.balance -= amount;
            return true;
        }
        return false;
    }

    public synchronized void deposit(double amount) {
        balance += amount;
    }
}
