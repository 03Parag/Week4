package com.Week4.Day02_Collection;
import java.util.*;

// Create BankingSystem class to store customer accounts, sorts customers by balance and withdrawal requests
class BankingSystem {
    // Attributes of BankingSystem
    private Map<Integer, Double> accountBalances;
    private TreeMap<Double, List<Integer>> sortedAccounts;
    private Queue<Integer> withdrawalQueue;

    // Constructor for bankingsystem
    public BankingSystem() {
        this.accountBalances = new HashMap<>();
        this.sortedAccounts = new TreeMap<>();
        this.withdrawalQueue = new LinkedList<>();
    }

    // Method to add account in bank
    public void addAccount(int accountNumber, double balance) {
        accountBalances.put(accountNumber, balance);
        sortedAccounts.computeIfAbsent(balance, k -> new ArrayList<>()).add(accountNumber);
    }

    // Method to deposit in bank
    public void deposit(int accountNumber, double amount) {
        if (accountBalances.containsKey(accountNumber)) {
            double oldBalance = accountBalances.get(accountNumber);
            double newBalance = oldBalance + amount;
            accountBalances.put(accountNumber, newBalance);

            // Update sorted accounts
            sortedAccounts.get(oldBalance).remove((Integer) accountNumber);
            if (sortedAccounts.get(oldBalance).isEmpty()) {
                sortedAccounts.remove(oldBalance);
            }
            sortedAccounts.computeIfAbsent(newBalance, k -> new ArrayList<>()).add(accountNumber);

            System.out.println("Deposited $" + amount + " to Account " + accountNumber);
        } else {
            System.out.println("Account not found!");
        }
    }

    // Method to request withdrawal
    public void requestWithdrawal(int accountNumber) {
        if (accountBalances.containsKey(accountNumber)) {
            withdrawalQueue.add(accountNumber);
            System.out.println("Withdrawal request added for Account " + accountNumber);
        } else {
            System.out.println("Account not found!");
        }
    }

    // Method to process withdrawal
    public void processWithdrawals() {
        while (!withdrawalQueue.isEmpty()) {
            int accountNumber = withdrawalQueue.poll();
            System.out.println("Processing withdrawal for Account " + accountNumber);
        }
    }

    // Method to display accounts sorted by balance
    public void displayAccountsSortedByBalance() {
        System.out.println("\nAccounts Sorted by Balance (TreeMap - Ascending Order):");
        for (Map.Entry<Double, List<Integer>> entry : sortedAccounts.entrySet()) {
            System.out.println("$" + entry.getKey() + " -> Accounts: " + entry.getValue());
        }
    }

    // Method to display account balance
    public void displayAccountBalances() {
        System.out.println("\nAccount Balances (Unordered - HashMap):");
        for (Map.Entry<Integer, Double> entry : accountBalances.entrySet()) {
            System.out.println("Account " + entry.getKey() + " -> $" + entry.getValue());
        }
    }

    public static void main(String[] args) {
        // Create an instance of banking system
        BankingSystem bank = new BankingSystem();

        // Get the add account method
        bank.addAccount(1001, 5000);
        bank.addAccount(1002, 2000);
        bank.addAccount(1003, 8000);
        bank.addAccount(1004, 3000);

        // Get the display account balance method
        bank.displayAccountBalances();
        bank.displayAccountsSortedByBalance();

        // Get the deposit and withdrawal request method
        bank.deposit(1002, 1000);
        bank.requestWithdrawal(1003);
        bank.requestWithdrawal(1001);

        // Get the withdrawal process and display account sorted by balance method
        bank.processWithdrawals();
        bank.displayAccountsSortedByBalance();
    }
}
