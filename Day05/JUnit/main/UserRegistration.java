package com.Week4.Day05.JUnit.main;

import java.util.regex.Pattern;

// Create UserRegistration class to valid user registration
class UserRegistration {
    // create an email pattern using regex
    private static final Pattern EmailPattern =
            Pattern.compile("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$");

    // Method to register user
    public String registerUser(String username, String email, String password) {
        if (username == null || username.trim().isEmpty()) {
            throw new IllegalArgumentException("Username cannot be empty");
        }
        if (email == null || !EmailPattern.matcher(email).matches()) {
            throw new IllegalArgumentException("Invalid email format");
        }
        if (password == null || password.length() < 8) {
            throw new IllegalArgumentException("Password must be at least 8 characters long");
        }
        return "User registered successfully";
    }
}

