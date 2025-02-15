package com.Week4.Day05.Regex.Replace_And_Modify_Strings;
import java.util.regex.*;

// Create ReplaceMultipleSpaces class to replace multiple spaces with single space
class ReplaceMultipleSpaces {
    public static void main(String[] args) {
        // Enter the text containing multiple spaces
        String text = "This   is   an   example   with    multiple   spaces.";

        // Replace multiple spaces with a single space
        String replacedText = text.replaceAll("\\s+", " ");

        System.out.println("Original text: " + text);
        // Print the result
        System.out.println("Replaced text: " + replacedText);
    }
}

