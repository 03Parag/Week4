package com.Week4.Day05.Regex.Advanced_Problems;
import java.util.regex.*;

// Create ValidateCreditCard class to validate the credit card
class ValidateCreditCard {
    public static void main(String[] args) {
        // Create an array of credit card numbers
        String[] cardNumbers = {"4111111111111111", "5500000000000004", "340000000000009", "411111111111" };

        // Enter the regex pattern
        String visaRegex = "^4\\d{15}$";
        String masterCardRegex = "^5\\d{15}$";

        // Compile the regex patterns
        Pattern visaPattern = Pattern.compile(visaRegex);
        Pattern masterCardPattern = Pattern.compile(masterCardRegex);

        // Loop through each card number
        for (String card : cardNumbers) {
            // Create a matcher to check the credit card numbers against the pattern
            Matcher visaMatcher = visaPattern.matcher(card);
            Matcher masterCardMatcher = masterCardPattern.matcher(card);

            // Print whether the credit card numbers (Visa card, Master card) is valid or not
            if (visaMatcher.matches()) {
                System.out.println(card + " is a Valid Visa Card");
            } else if (masterCardMatcher.matches()) {
                System.out.println(card + " is a Valid MasterCard");
            } else {
                System.out.println(card + " is Invalid");
            }
        }
    }
}

