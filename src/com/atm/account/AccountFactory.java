package com.atm.account;

import com.atm.adapter.DollarToRealAdapter;
import com.atm.adapter.DollarTransactionImpl;

public class AccountFactory {
    public static Account createAccount(String type) {
        switch (type) {
            case "Corrente":
                return new CheckingAccount();
            case "Poupança":
                return new SavingsAccount();
            case "Dólar":
                return new DollarToRealAdapter(new DollarTransactionImpl());
            default:
                throw new IllegalArgumentException("Tipo de conta desconhecido");
        }
    }
}
