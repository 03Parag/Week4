package com.Week4.Day05.Regex.Extraction_Problems;
import java.util.regex.*;

// Create ExtractLinks class to extract the links
class ExtractLinks {
    public static void main(String[] args) {
        // Enter the text containing URLs
        String text = "Visit https://www.google.com and http://example.org for more info.";

        // Enter the regex pattern
        String regex = "\\bhttps?://[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}\\b";

        // Compile the regex pattern
        Pattern pattern = Pattern.compile(regex);

        // Create a matcher to find URLs in the text
        Matcher matcher = pattern.matcher(text);

        // Loop through all matches and print the extracted links
        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }
}

