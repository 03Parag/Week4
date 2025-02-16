package com.Week4.Day05.JUnit.main;

// Create BankAccount class to make deposit, withdraw and get balance method
class BankAccount {
    // Attributes of BankAccount
    private double balance;

    // Constructor for BankAccount
    public BankAccount(double initialBalance) {
        // If initial balance is negative
        if (initialBalance < 0) {
            throw new IllegalArgumentException("Initial balance cannot be negative");
        }
        this.balance = initialBalance;
    }

    // Method to deposit amount in bank
    public void deposit(double amount) {
        // If amount is zero or negative
        if (amount <= 0) {
            throw new IllegalArgumentException("Deposit amount must be positive");
        }
        balance += amount;
    }

    // Method to withdraw amount in bank
    public void withdraw(double amount) {
        // If amount is zero or negative
        if (amount <= 0) {
            throw new IllegalArgumentException("Withdrawal amount must be positive");
        }
        if (amount > balance) {
            throw new IllegalArgumentException("Insufficient funds");
        }
        balance -= amount;
    }

    // Method to get the balance
    public double getBalance() {
        return balance;
    }
}

