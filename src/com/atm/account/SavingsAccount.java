package com.atm.account;

public class SavingsAccount extends Account {
    public void deposit(double amount) {
        System.out.println("Depositando " + amount + " na Conta Poupança");
    }

    public void withdraw(double amount) {
        System.out.println("Sacando " + amount + " da Conta Poupança");
    }
}
