package com.Week4.Day05.JUnit.main;

// Create PasswordValidator class check if it is valid or not
class PasswordValidator {
    // Method to check if password is valid or not
    public boolean isValid(String password) {
        // If password is null or its length is zero
        if (password == null || password.length() < 8) {
            return false;
        }

        // Initialize the hasUpperCase and hasDigit as false
        boolean hasUpperCase = false;
        boolean hasDigit = false;

        // Loop through the passwords
        for (char ch : password.toCharArray()) {
            if (Character.isUpperCase(ch)) {
                hasUpperCase = true;
            }
            if (Character.isDigit(ch)) {
                hasDigit = true;
            }
        }

        return hasUpperCase && hasDigit;
    }
}

