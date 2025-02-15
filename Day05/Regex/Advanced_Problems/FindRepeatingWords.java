package com.Week4.Day05.Regex.Advanced_Problems;
import java.util.regex.*;
import java.util.*;

// Create FindRepeatingWords class to find the repeating word in the text
class FindRepeatingWords {
    public static void main(String[] args) {
        // Enter the text containing repeating words
        String text = "This is is a repeated repeated word test.";

        // Enter the regex pattern
        String regex = "\\b(\\w+)\\b";

        // Compile the regex pattern
        Pattern pattern = Pattern.compile(regex);

        // Create a matcher to find words
        Matcher matcher = pattern.matcher(text);

        // HashMap to store word frequencies
        Map<String, Integer> wordCount = new HashMap<>();

        // Loop through the text to extract words and count occurrences
        while (matcher.find()) {
            String word = matcher.group().toLowerCase(); // Convert to lowercase for case insensitivity
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }

        // List to store repeated words
        List<String> repeatedWords = new ArrayList<>();

        // Find words that appear more than once
        for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
            if (entry.getValue() > 1) {
                repeatedWords.add(entry.getKey());
            }
        }

        // Print the repeated words
        System.out.println("Repeated Words: " + String.join(", ", repeatedWords));
    }
}
