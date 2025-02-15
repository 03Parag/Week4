package com.Week4.Day05.Regex.Basic_Regex_Problems;
import java.util.regex.*;

// Create LicensePlateValidator class to validate the license plate number
class LicensePlateValidator {
    public static void main(String[] args) {
        // Enter the regex pattern
        String regex = "^[A-Z]{2}\\d{4}$";

        // Compile the regex pattern
        Pattern pattern = Pattern.compile(regex);

        // Create an array of license plate numbers
        String[] licensePlates = {"AB1234", "A12345"};

        // Loop through the list of license plate numbers
        for (String plate : licensePlates) {
            // Create a matcher to check the license plate against the pattern
            Matcher matcher = pattern.matcher(plate);

            // Print whether the license plate is valid or not
            if (matcher.matches()) {
                System.out.println(plate + " -> Valid");
            } else {
                System.out.println(plate + " -> Invalid");
            }
        }
    }
}

