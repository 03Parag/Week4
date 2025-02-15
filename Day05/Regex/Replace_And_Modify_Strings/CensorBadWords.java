package com.Week4.Day05.Regex.Replace_And_Modify_Strings;
import java.util.regex.*;

// Create CensorBadWords class to censor bad words from a text
class CensorBadWords {
    public static void main(String[] args) {
        // Enter the text containing sentence with bad words
        String text = "This is a damn bad example with some stupid words.";

        // Create an array of list of bad words to be censored
        String[] badWords = {"damn", "stupid"};

        // Loop through each bad word with ****
        for (String word : badWords) {
            text = text.replaceAll("(?i)\\b" + word + "\\b", "****");
        }

        // Print the censored sentence
        System.out.println(text);
    }
}

