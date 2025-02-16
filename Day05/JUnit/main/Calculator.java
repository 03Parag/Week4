package com.Week4.Day05.JUnit.main;

// Create Calculator class to calculate the 2 number using add, subtract, multiply and divide
class Calculator {
    // Method to add
    public int add(int a, int b) {
        return a + b;
    }

    // Method to subtract
    public int subtract(int a, int b) {
        return a - b;
    }

    // Method to multiply
    public int multiply(int a, int b) {
        return a * b;
    }

    // Method to divide
    public int divide(int a, int b) {
        // Check if b is 0
        if (b == 0) {
            throw new ArithmeticException("Division by zero is not allowed");
        }
        return a / b;
    }
}
