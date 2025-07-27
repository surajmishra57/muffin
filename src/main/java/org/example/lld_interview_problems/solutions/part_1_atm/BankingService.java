package org.example.lld_interview_problems.solutions.part_1_atm;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class BankingService {
    private Map<String, Account> accounts = new ConcurrentHashMap<>();
    private Map<String, Card> cards = new ConcurrentHashMap<>();
    private Map<Card, Account> cardAccountMap = new ConcurrentHashMap<>();

    public BankingService(Map<String, Account> accounts, Map<String, Card> cards, Map<Card, Account> cardAccountMap) {
        this.accounts = accounts;
        this.cards = cards;
        this.cardAccountMap = cardAccountMap;
    }

    public Account createAccount(String accountNumber, double initialBalance) {
        Account account = new Account(accountNumber, initialBalance);
        accounts.put(accountNumber, account);
        return account;
    }

    public Card createCard(String cardNumber, String pin) {
        Card card = new Card(cardNumber, pin);
        cards.put(cardNumber, card);
        return card;
    }

    public boolean authenticate(Card card, String pin) {
        return card.getPin().equals(pin);
    }

    public void linkCardToAccount(Card card, Account account) {
        account.getCards().put(card.getCardNumber(), card);
        cardAccountMap.put(card, account);
    }

    public Card getCard(String cardNumber) {
        return cards.getOrDefault(cardNumber, null);
    }

    public double getBalance(Card card) {
        return cardAccountMap.get(card).getBalance();
    }

    public void withDrawMoney(Card card, double amount) {
        cardAccountMap.get(card).withdraw(amount);
    }

    public void depositMoney(Card card, double amount) {
        cardAccountMap.get(card).deposit(amount);
    }


}
