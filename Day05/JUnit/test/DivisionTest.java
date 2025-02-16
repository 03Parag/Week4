package com.Week4.Day05.JUnit.test;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

// Create DivisionTest class to test the Division test
class DivisionTest {
    // Create an instance of Division
    Division division = new Division();

    @Test
    public void divideValidTest() {
        assertEquals(2, division.divide(10, 5), "10 / 5 should equal 2");
        assertEquals(0, division.divide(0, 5), "0 / 5 should equal 0");
        assertEquals(-2, division.divide(-10, 5), "-10 / 5 should equal -2");
    }

    @Test
    public void divideByZeroTest() {
        Exception exception = assertThrows(ArithmeticException.class, () -> {
            division.divide(10, 0);
        });

        assertEquals("Division by zero is not allowed", exception.getMessage(),
                "Exception message should match the expected message");
    }
}

