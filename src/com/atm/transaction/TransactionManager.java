package com.atm.transaction;

import java.util.ArrayList;
import java.util.List;
import com.atm.observer.TransactionObserver;

public class TransactionManager {
    private static TransactionManager instance;
    private List<TransactionObserver> observers = new ArrayList<>();

    private TransactionManager() {}

    public static TransactionManager getInstance() {
        if (instance == null) {
            instance = new TransactionManager();
        }
        return instance;
    }

    public void processTransaction(Transaction transaction) {
        System.out.println("Processando transação: " + transaction);
        notifyObservers(transaction);
    }

    public void addObserver(TransactionObserver observer) {
        observers.add(observer);
    }

    private void notifyObservers(Transaction transaction) {
        for (TransactionObserver observer : observers) {
            observer.update(transaction);
        }
    }
}
