package com.atm;

import java.util.Scanner;

import com.atm.account.Account;
import com.atm.account.AccountFactory;
import com.atm.transaction.Transaction;
import com.atm.transaction.TransactionManager;
import com.atm.strategy.PinValidationStrategy;
import com.atm.strategy.TransactionValidator;
import com.atm.observer.EmailNotificationObserver;
import com.atm.observer.SmsNotificationObserver;

public class ATM {
    public static void main(String[] args) {
        // Singleton: Obter a instância do gerenciador de transações
        TransactionManager transactionManager = TransactionManager.getInstance();

        // Factory Method: Criar contas
        Account checkingAccount = AccountFactory.createAccount("Corrente");
        Account savingsAccount = AccountFactory.createAccount("Poupança");
        Account dollarAccount = AccountFactory.createAccount("Dólar");

        // Strategy: Definir a estratégia de validação
        TransactionValidator validator = new TransactionValidator();
        validator.setStrategy(new PinValidationStrategy());

        // Observer: Adicionar observadores
        transactionManager.addObserver(new EmailNotificationObserver());
        transactionManager.addObserver(new SmsNotificationObserver());

        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("\n--- Menu do Caixa Eletrônico ---");
            System.out.println("1. Depositar em Conta Corrente");
            System.out.println("2. Sacar de Conta Corrente");
            System.out.println("3. Depositar em Conta Poupança");
            System.out.println("4. Sacar de Conta Poupança");
            System.out.println("5. Depositar em Conta Dólar");
            System.out.println("6. Sacar de Conta Dólar");
            System.out.println("7. Sair");
            System.out.print("Escolha uma opção: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Digite o valor para depositar em Conta Corrente: ");
                    double depositChecking = scanner.nextDouble();
                    Transaction depositTransactionChecking = new Transaction(checkingAccount, depositChecking);
                    if (validator.validate(depositTransactionChecking)) {
                        transactionManager.processTransaction(depositTransactionChecking);
                    }
                    break;
                case 2:
                    System.out.print("Digite o valor para sacar de Conta Corrente: ");
                    double withdrawChecking = scanner.nextDouble();
                    Transaction withdrawTransactionChecking = new Transaction(checkingAccount, -withdrawChecking);
                    if (validator.validate(withdrawTransactionChecking)) {
                        transactionManager.processTransaction(withdrawTransactionChecking);
                    }
                    break;
                case 3:
                    System.out.print("Digite o valor para depositar em Conta Poupança: ");
                    double depositSavings = scanner.nextDouble();
                    Transaction depositTransactionSavings = new Transaction(savingsAccount, depositSavings);
                    if (validator.validate(depositTransactionSavings)) {
                        transactionManager.processTransaction(depositTransactionSavings);
                    }
                    break;
                case 4:
                    System.out.print("Digite o valor para sacar de Conta Poupança: ");
                    double withdrawSavings = scanner.nextDouble();
                    Transaction withdrawTransactionSavings = new Transaction(savingsAccount, -withdrawSavings);
                    if (validator.validate(withdrawTransactionSavings)) {
                        transactionManager.processTransaction(withdrawTransactionSavings);
                    }
                    break;
                case 5:
                    System.out.print("Digite o valor em dólares para depositar: ");
                    double depositDollar = scanner.nextDouble();
                    Transaction depositTransactionDollar = new Transaction(dollarAccount, depositDollar);
                    if (validator.validate(depositTransactionDollar)) {
                        transactionManager.processTransaction(depositTransactionDollar);
                    }
                    break;
                case 6:
                    System.out.print("Digite o valor em dólares para sacar: ");
                    double withdrawDollar = scanner.nextDouble();
                    Transaction withdrawTransactionDollar = new Transaction(dollarAccount, -withdrawDollar);
                    if (validator.validate(withdrawTransactionDollar)) {
                        transactionManager.processTransaction(withdrawTransactionDollar);
                    }
                    break;
                case 7:
                    exit = true;
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida. Por favor, tente novamente.");
            }
        }

        scanner.close();
    }
}
