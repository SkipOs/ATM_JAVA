package com.atm.observer;

import com.atm.transaction.Transaction;

public class SmsNotificationObserver implements TransactionObserver {
    @Override
    public void update(Transaction transaction) {
        System.out.println("Enviando notificação por SMS para a transação: " + transaction);
    }
}
