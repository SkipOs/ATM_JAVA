package com.atm.strategy;

import com.atm.transaction.Transaction;

public class PinValidationStrategy implements ValidationStrategy {
    @Override
    public boolean validate(Transaction transaction) {
        System.out.println("Validando transação usando PIN");
        return true;
    }
}
