package com.Week4.Day05.JUnit.main;

// Create StringUtils class to make a string reverse, palindrome and convert to uppercase
class StringUtils {
    // Method to reverse the string
    public String reverse(String string) {
        // If string is null
        if (string == null)
            return null;
        return new StringBuilder(string).reverse().toString();
    }

    // Method to find if a string is a palindrome
    public boolean isPalindrome(String string) {
        // If string is null
        if (string == null)
            return false;
        String reversed = reverse(string);
        return string.equals(reversed);
    }

    // Method to convert string to toUpperCase
    public String toUpperCase(String string) {
        // If string is null
        if (string == null)
            return null;
        return string.toUpperCase();
    }
}
