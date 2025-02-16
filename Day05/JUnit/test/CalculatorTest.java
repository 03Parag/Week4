package com.Week4.Day05.JUnit.test;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

// Create a CalculateTest class to test the calculator class
class CalculatorTest {
    // Create an instance of calculator
    Calculator calculator = new Calculator();

    @Test
    public void addTest() {
        assertEquals(5, calculator.add(2, 3), "2 + 3 should be equal to 5");
    }

    @Test
    public void subtractTest() {
        assertEquals(1, calculator.subtract(3, 2), "3 - 2 should be equal to 1");
    }

    @Test
    public void multiplyTest() {
        assertEquals(6, calculator.multiply(2,3), "2 * 3 should be equal to 6");
    }

    @Test
    public void divideTest() {
        assertEquals(2, calculator.divide(6, 3), "6 / 3 should be equal to 2");
    }

    @Test
    public void divideByZeroTest() {
        Exception exception = assertThrows(ArithmeticException.class, () -> {
           calculator.divide(2, 0);
        });
        String expectedMessage = "Division by zero is not allowed";
        String actualMessage = exception.getMessage();

        assertEquals(expectedMessage, actualMessage, "Exception message should match");
    }
}
