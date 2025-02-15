package com.Week4.Day05.Regex.Basic_Regex_Problems;
import java.util.regex.*;

// Create HexColorValidator class to validate the hex color
class HexColorValidator {
    public static void main(String[] args) {
        // Enter the regex pattern
        String regex = "^#([A-Fa-f0-9]{6})$";

        // Compile the regex pattern
        Pattern pattern = Pattern.compile(regex);

        // Create an array of hex color codes
        String[] hexColors = {"#FFA500", "#ff4500","#123"};

        // Loop through the list of hex colors
        for (String color : hexColors) {
            // Create a matcher to check the hex color against the pattern
            Matcher matcher = pattern.matcher(color);

            // Print whether the hex color code is valid or not
            if (matcher.matches()) {
                System.out.println(color + " -> Valid");
            } else {
                System.out.println(color + " -> Invalid");
            }
        }
    }
}


