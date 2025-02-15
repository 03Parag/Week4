package com.Week4.Day05.Regex.Extraction_Problems;
import java.util.regex.*;

// Create ExtractEmails class to extract the emails
class ExtractEmails {
    public static void main(String[] args) {
        // Enter the text containing email addresses
        String text = "Contact us at support@example.com and info@company.org.";

        // Enter the regex pattern
        String regex = "[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}";

        // Compile the regex pattern
        Pattern pattern = Pattern.compile(regex);

        // Create a matcher to find email addresses in the text
        Matcher matcher = pattern.matcher(text);

        // Loop through all matches and print the email addresses
        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }
}

