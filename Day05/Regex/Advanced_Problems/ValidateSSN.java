package com.Week4.Day05.Regex.Advanced_Problems;
import java.util.regex.*;

// Create ValidateSSN class to validate the SSN
class ValidateSSN {
    public static void main(String[] args) {
        // Example inputs
        String[] ssnList = {"123-45-6789", "123456789"};

        // Enter the regex pattern
        String regex = "^(?!000|666|9\\d{2})\\d{3}-\\d{2}-\\d{4}$";

        // Compile the regex pattern
        Pattern pattern = Pattern.compile(regex);

        // Loop through to validate each SSN
        for (String ssn : ssnList) {
            // Create a matcher to validate SSNs
            Matcher matcher = pattern.matcher(ssn);
            // Print whether the SSN is valid or not
            if (matcher.matches()) {
                System.out.println(ssn + "\" is valid");
            } else {
                System.out.println(ssn + "\" is invalid");
            }
        }
    }
}

