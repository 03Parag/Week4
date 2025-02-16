package com.Week4.Day05.JUnit.test;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

// Create DateFormatterTest class to test DateFormatter class
class DateFormatterTest {
    // Create an instance of DateFormatter
    private DateFormatter dateFormatter;

    @BeforeEach
    public void setUp() {
        dateFormatter = new DateFormatter();
    }

    @Test
    public void validDateTest() {
        assertEquals("25-12-2024", dateFormatter.formatDate("2024-12-25"), "Date conversion failed");
        assertEquals("01-01-2023", dateFormatter.formatDate("2023-01-01"), "Date conversion failed");
    }

    @Test
    public void invalidDateFormatTest() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            dateFormatter.formatDate("25/12/2024"); 
        });

        String expectedMessage = "Invalid date format";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void nullDateTest() {
        assertThrows(IllegalArgumentException.class, () -> dateFormatter.formatDate(null), "Null should throw exception");
    }

    @Test
    public void emptyDateTest() {
        assertThrows(IllegalArgumentException.class, () -> dateFormatter.formatDate(""), "Empty string should throw exception");
    }
}

