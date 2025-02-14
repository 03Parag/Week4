package com.Week4.Day04_Exceptions;

// Create InterestCalculator class to calculate the interest using amount, rate and year and if an exception occur return IllegalArgumentException
class InterestCalculator {
    public double calculateInterest(double amount, double rate, int years) throws IllegalArgumentException {
        // If amount or rate is negative
        if (amount < 0 || rate < 0) {
            throw new IllegalArgumentException("Amount and rate must be positive");
        }
        return amount * rate * years / 100;
    }

    public static void main(String[] args) {
        // Create an instance of interestCalculator object
        InterestCalculator interestCalculator = new InterestCalculator();

        try {
            // Enter amount, rate and years
            double amount = 1000;
            double rate = -5;
            int years = 2;

            // Get the calculateInterest method
            double interest = interestCalculator.calculateInterest(amount, rate ,years);
            // Print the interest
            System.out.println("Calculated interest: " + interest);

        } catch (IllegalArgumentException e) {
            System.err.println("Invalid input: Amount and rate must be positive");
        }
    }
}
