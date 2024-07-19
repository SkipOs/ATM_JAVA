package com.atm.strategy;

import com.atm.transaction.Transaction;

public interface ValidationStrategy {
    boolean validate(Transaction transaction);
}
