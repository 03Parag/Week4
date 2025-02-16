package com.Week4.Day05.JUnit.main;

// Create Division class to divide the two number
class Division {
    // Method to divide
    public int divide(int a, int b) {
        // If the b is zero
        if (b == 0) {
            throw new ArithmeticException("Division by zero is not allowed");
        }
        return a / b;
    }
}
