package com.Week4.Day05.Regex.Advanced_Problems;
import java.util.regex.*;

// Create ValidateIPAddress class to validate the IP Address
class ValidateIPAddress {
    public static void main(String[] args) {
        // Create an array of IP addresses
        String[] ipAddresses = {"192.168.1.1", "255.255.255.255", "256.100.50.25", "192.168.1"};

        // Enter the regex pattern
        String regex =
                "\\b(25[0-5]|2[0-4]\\d|1\\d{2}|[1-9]?\\d)\\." + "(25[0-5]|2[0-4]\\d|1\\d{2}|[1-9]?\\d)\\." + "(25[0-5]|2[0-4]\\d|1\\d{2}|[1-9]?\\d)\\." + "(25[0-5]|2[0-4]\\d|1\\d{2}|[1-9]?\\d)\\b";

        // Compile the regex pattern
        Pattern pattern = Pattern.compile(regex);

        // Loop through each IP address
        for (String ip : ipAddresses) {
            // Create a matcher to check the IP Address against the pattern
            Matcher matcher = pattern.matcher(ip);

            // Print whether the IP Address is valid or not
            if (matcher.matches()) {
                System.out.println(ip + " -> Valid");
            } else {
                System.out.println(ip + " -> Invalid");
            }
        }
    }
}

