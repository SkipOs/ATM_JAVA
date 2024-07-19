package com.atm.account;

public class CheckingAccount extends Account {
    public void deposit(double amount) {
        System.out.println("Depositando " + amount + " na Conta Corrente");
    }

    public void withdraw(double amount) {
        System.out.println("Sacando " + amount + " da Conta Corrente");
    }
}
