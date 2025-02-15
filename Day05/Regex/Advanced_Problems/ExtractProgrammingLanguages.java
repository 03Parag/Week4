package com.Week4.Day05.Regex.Advanced_Problems;
import java.util.regex.*;
import java.util.*;

// Create ExtractProgrammingLanguages class to extract the programming languages from the text
class ExtractProgrammingLanguages {
    public static void main(String[] args) {
        // Enter the text containing programming languages
        String text = "I love Java, Python, and JavaScript, but I haven't tried Go yet.";

        // Enter the regex pattern
        String regex = "\\b(JavaScript|Java|Python|Go|C|C\\+\\+|C#|Ruby|Swift|Kotlin|PHP|Rust)\\b";

        // Compile the regex pattern
        Pattern pattern = Pattern.compile(regex);

        // Create a matcher to find languages in the text
        Matcher matcher = pattern.matcher(text);

        // List to store extracted languages
        List<String> languages = new ArrayList<>();

        // Loop through all matches and add to the list
        while (matcher.find()) {
            languages.add(matcher.group());
        }

        // Print the extracted programming languages
        System.out.println(String.join(", ", languages));
    }
}

