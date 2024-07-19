package com.atm.observer;

import com.atm.transaction.Transaction;

public interface TransactionObserver {
    void update(Transaction transaction);
}
