package com.Week4.Day05.JUnit.test;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

// Create BankAccountTest class to test BankAccount class
class BankAccountTest {
    // Create an instance of bank account
    private BankAccount account;

    @BeforeEach
    public void setUp() {
        account = new BankAccount(100.0);
    }

    @Test
    public void depositTest() {
        account.deposit(50.0);
        assertEquals(150.0, account.getBalance(), "Balance should be updated after deposit");
    }

    @Test
    public void withdrawTest() {
        account.withdraw(30.0);
        assertEquals(70.0, account.getBalance(), "Balance should be updated after withdrawal");
    }

    @Test
    public void withdrawInsufficientFundsTest() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            account.withdraw(200.0); // More than available balance
        });

        assertEquals("Insufficient funds", exception.getMessage(), "Exception message should indicate insufficient funds");
    }

    @Test
    public void depositNegativeAmountTest() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            account.deposit(-10.0);
        });

        assertEquals("Deposit amount must be positive", exception.getMessage(), "Exception message should indicate invalid deposit");
    }

    @Test
    public void withdrawNegativeAmountTest() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            account.withdraw(-5.0);
        });

        assertEquals("Withdrawal amount must be positive", exception.getMessage(), "Exception message should indicate invalid withdrawal");
    }

    @Test
    public void initialBalanceTest() {
        BankAccount newAccount = new BankAccount(500.0);
        assertEquals(500.0, newAccount.getBalance(), "Initial balance should be set correctly");
    }

    @Test
    public void initialBalanceNegativeTest() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new BankAccount(-100.0);
        });

        assertEquals("Initial balance cannot be negative", exception.getMessage(), "Exception message should indicate invalid initial balance");
    }
}

