package com.Week4.Day05.JUnit.test;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

// Create UserRegistrationTest class to test UserRegistration class
class UserRegistrationTest {
    // Create an instance of  UserRegistration
    private UserRegistration userRegistration;

    @BeforeEach
    public void setUp() {
        userRegistration = new UserRegistration();
    }

    @Test
    public void registerUserValidTest() {
        assertEquals("User registered successfully",
                userRegistration.registerUser("JohnDoe", "john.doe@example.com", "SecurePass1"));
    }

    @Test
    public void registerUserEmptyUsernameTest() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            userRegistration.registerUser("", "john.doe@example.com", "SecurePass1");
        });

        assertEquals("Username cannot be empty", exception.getMessage());
    }

    @Test
    public void registerUserInvalidEmailTest() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            userRegistration.registerUser("JohnDoe", "invalid-email", "SecurePass1");
        });

        assertEquals("Invalid email format", exception.getMessage());
    }

    @Test
    public void registerUserShortPasswordTest() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            userRegistration.registerUser("JohnDoe", "john.doe@example.com", "short");
        });

        assertEquals("Password must be at least 8 characters long", exception.getMessage());
    }

    @Test
    public void registerUserNullValuesTest() {
        assertThrows(IllegalArgumentException.class, () -> userRegistration.registerUser(null, "john.doe@example.com", "SecurePass1"));
        assertThrows(IllegalArgumentException.class, () -> userRegistration.registerUser("JohnDoe", null, "SecurePass1"));
        assertThrows(IllegalArgumentException.class, () -> userRegistration.registerUser("JohnDoe", "john.doe@example.com", null));
    }
}


