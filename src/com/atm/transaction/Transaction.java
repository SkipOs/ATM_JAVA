package com.atm.transaction;

import com.atm.account.Account;

public class Transaction {
    private Account account;
    private double amount;

    public Transaction(Account account, double amount) {
        this.account = account;
        this.amount = amount;
    }

    public Account getAccount() {
        return account;
    }

    public double getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return "Transaction [account=" + account + ", amount=" + amount + "]";
    }
}
