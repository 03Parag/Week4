package com.Week4.Day05.Regex.Advanced_Problems;
import java.util.regex.*;
import java.util.*;

// Create ExtractCurrencyValues class to extract the currency values from the text
class ExtractCurrencyValues {
    public static void main(String[] args) {
        // Enter the text containing currency values
        String text = "The price is $45.99, and the discount is 10.50.";

        // Enter the regex pattern
        String regex = "\\$?\\d+\\.\\d{2}";

        // Compile the regex pattern
        Pattern pattern = Pattern.compile(regex);

        // Create a matcher to find currency values in the text
        Matcher matcher = pattern.matcher(text);

        // List to store extracted currency values
        List<String> currencyValues = new ArrayList<>();

        // Loop through all matches and add to the list
        while (matcher.find()) {
            currencyValues.add(matcher.group());
        }

        // Print the extracted currency values
        System.out.println("Extracted Currency Values: " + String.join(", ", currencyValues ));
    }
}
