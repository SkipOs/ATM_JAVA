package com.atm.strategy;

import com.atm.transaction.Transaction;

public class TransactionValidator {
    private ValidationStrategy strategy;

    public void setStrategy(ValidationStrategy strategy) {
        this.strategy = strategy;
    }

    public boolean validate(Transaction transaction) {
        return strategy.validate(transaction);
    }
}
