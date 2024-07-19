package com.atm.observer;

import com.atm.transaction.Transaction;

public class EmailNotificationObserver implements TransactionObserver {
    @Override
    public void update(Transaction transaction) {
        System.out.println("Enviando notificação por email para a transação: " + transaction);
    }
}
