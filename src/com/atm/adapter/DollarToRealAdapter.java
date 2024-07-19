package com.atm.adapter;

import com.atm.account.Account;

public class DollarToRealAdapter extends Account {
    private DollarTransaction dollarTransaction;

    public DollarToRealAdapter(DollarTransaction dollarTransaction) {
        this.dollarTransaction = dollarTransaction;
    }

    @Override
    public void deposit(double amount) {
        dollarTransaction.deposit(amount);
    }

    @Override
    public void withdraw(double amount) {
        dollarTransaction.withdraw(amount);
    }
}
