package com.Week4.Day05.Regex.Extraction_Problems;
import java.util.regex.*;

// Create ExtractCapitalizedWords class to extract the capital words
class ExtractCapitalizedWords {
    public static void main(String[] args) {
        // Enter the text containing capitalized words
        String text = "The Eiffel Tower is in Paris and the Statue of Liberty is in New York.";

        // Enter the regex pattern
        String regex = "\\b[A-Z][a-z]*\\b";

        // Compile the regex pattern
        Pattern pattern = Pattern.compile(regex);

        // Create a matcher to find capitalized words in the text
        Matcher matcher = pattern.matcher(text);

        // Loop through all matches and print the capitalized words
        while (matcher.find()) {
            System.out.print(matcher.group() + " ");
        }
    }
}

