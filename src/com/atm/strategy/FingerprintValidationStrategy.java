package com.atm.strategy;

import com.atm.transaction.Transaction;

public class FingerprintValidationStrategy implements ValidationStrategy {
    @Override
    public boolean validate(Transaction transaction) {
        System.out.println("Validando transação usando impressão digital");
        return true;
    }
}
