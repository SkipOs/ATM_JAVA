package com.atm.adapter;

public class DollarTransactionImpl implements DollarTransaction {
    private static final double EXCHANGE_RATE = 5.0; // Suponha que 1 dólar = 5 reais

    @Override
    public void deposit(double amount) {
        double amountInReal = amount * EXCHANGE_RATE;
        System.out.println("Depositando " + amount + " dólares (" + amountInReal + " reais)");
    }

    @Override
    public void withdraw(double amount) {
        double amountInReal = amount * EXCHANGE_RATE;
        System.out.println("Sacando " + amount + " dólares (" + amountInReal + " reais)");
    }
}
