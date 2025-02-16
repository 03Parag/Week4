package com.Week4.Day05.JUnit.main;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

// Create DateFormatter class to change the date format from yyyy-mm-dd to dd-mm-yyyy
class DateFormatter {
    // Create an instance of input and output format
    private static final DateTimeFormatter inputFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private static final DateTimeFormatter OutputFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    // Method to format date
    public String formatDate(String inputDate) {
        try {
            LocalDate date = LocalDate.parse(inputDate, inputFormat);
            return date.format(OutputFormat);
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("Invalid date format. Expected yyyy-MM-dd.");
        }
    }
}

