package com.Week4.Day05.JUnit.test;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

// Create PasswordValidatorTest class to test the PasswordValidator class
class PasswordValidatorTest {
    // Create an instance of PasswordValidator
    private PasswordValidator validator;

    @BeforeEach
    public void setUp() {
        validator = new PasswordValidator();
    }

    @Test
    public void validPasswordTest() {
        assertTrue(validator.isValid("StrongPass1"), "Valid password should return true");
    }

    @Test
    public void shortPasswordTest() {
        assertFalse(validator.isValid("Ab1"), "Password shorter than 8 characters should return false");
    }

    @Test
    public void noUpperCaseTest() {
        assertFalse(validator.isValid("password1"), "Password without an uppercase letter should return false");
    }

    @Test
    public void noDigitTest() {
        assertFalse(validator.isValid("PasswordOnly"), "Password without a digit should return false");
    }

    @Test
    public void nullPasswordTest() {
        assertFalse(validator.isValid(null), "Null password should return false");
    }

    @Test
    public void emptyPasswordTest() {
        assertFalse(validator.isValid(""), "Empty password should return false");
    }
}

