package com.Week4.Day05.Regex.Extraction_Problems;
import java.util.regex.*;

// Create ExtractDates class to extract the dates
class ExtractDates {
    public static void main(String[] args) {
        // Enter the text containing dates
        String text = "The events are scheduled for 12/05/2023, 15/08/2024, and 29/02/2020.";

        // Enter the regex pattern
        String regex = "\\b\\d{2}/\\d{2}/\\d{4}\\b";

        // Compile the regex pattern
        Pattern pattern = Pattern.compile(regex);

        // Create a matcher to find dates in the text
        Matcher matcher = pattern.matcher(text);

        // Loop through all matches and print the extracted dates
        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }
}

