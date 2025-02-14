package com.Week4.Day04_Exceptions;

// Create an InsufficientBalanceException class to throw InsufficientBalanceException and IllegalArgumentException  exception if  withdrawal amount exceeds balance and if the amount is negative respectively
class InsufficientBalanceException extends Exception {
    // Constructor for InsufficientBalanceException
    public InsufficientBalanceException(String message) {
        super(message);
    }
}

// BankAccount class
class BankAccount {
    // Attributes of BankAccount
    private double balance;

    // Constructor for BankAccount
    public BankAccount (double balance) {
        this.balance = balance;


        // If balance is negative
        if (balance < 0) {
            throw new IllegalArgumentException("Balance cannot be negativve!");
        }
    }

    // Method to get the bakance
    public double getBalance() {
        return balance;
    }

    // Method to withdrawal amount from bank account
    public void withdrawal(double amount) throws InsufficientBalanceException {
        // If amount is negative
        if (amount < 0) {
            throw new IllegalArgumentException("Invalid amount!");
        }
        // If amount is greater than balance
        if (amount > balance) {
            throw new InsufficientBalanceException("Insufficient balance!");
        }

        balance -= amount;
        System.out.println("Withdrawal successful, new balance: " + balance);
    }

    public static void main(String[] args) {
        try {
            // Create an instance of bank account
            BankAccount bankAccount = new BankAccount(10000);

            // Get the withdrawal method
            bankAccount.withdrawal(5000);
            bankAccount.withdrawal(-1000);
            bankAccount.withdrawal(7000);

        } catch (IllegalArgumentException e) {
            System.err.println("Invalid amount!");

        } catch (InsufficientBalanceException e) {
            System.err.println("Insufficient balance!");
        }
    }
}
