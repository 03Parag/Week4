package com.Week4.Day05.Regex.Basic_Regex_Problems;
import java.util.regex.*;

// Create a UsernameValidator class to validate a username
class UsernameValidator {
    public static void main(String[] args) {
        // Enter the regex pattern
        String regex = "^[a-zA-Z][a-zA-Z0-9_]{4,14}$";

        // Compile the regex pattern
        Pattern pattern = Pattern.compile(regex);

        // Create an array of usernames
        String[] usernames = {"user_123", "123user", "us"};

        // Loop through thelis tof usernames
        for (String username : usernames) {
            // Create a matcher to check the username against the pattern
            Matcher matcher = pattern.matcher(username);

            // Print whether the username is valid or not
            if (matcher.matches()) {
                System.out.println(username + " -> Valid");
            } else {
                System.out.println(username + " -> Invalid");
            }
        }
    }
}
