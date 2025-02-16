package com.Week4.Day05.JUnit.test;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

// Create EvenNumberTest class to test EvenNumber class
class EvenNumberTest {
    // Create an instance of even number
    private final EvenNumber evenNumber = new EvenNumber();

    @ParameterizedTest
    @ValueSource(ints = {2, 4, 6})
    public void isEvenTest_True(int number) {
        assertTrue(evenNumber.isEven(number), number + " should be even");
    }

    private void assertTrue(boolean even, String s) {
    }


    @ParameterizedTest
    @ValueSource(ints = {7, 9})
    public void isEvenTest_False(int number) {
        assertFalse(evenNumber.isEven(number), number + " should be odd");
    }

    private void assertFalse(boolean even, String s) {
    }
}
