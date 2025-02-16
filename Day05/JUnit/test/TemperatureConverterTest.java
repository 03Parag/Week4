package com.Week4.Day05.JUnit.test;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

// Create TemperatureConverterTest class to test the TemperatureConverter class
class TemperatureConverterTest {
    // Create an instance of TemperatureConverter
    private TemperatureConverter converter;

    @BeforeEach
    public void setUp() {
        converter = new TemperatureConverter();
    }

    @Test
    public void celsiusToFahrenheitTest() {
        assertEquals(32.0, converter.celsiusToFahrenheit(0), 0.01, "0°C should be 32°F");
        assertEquals(212.0, converter.celsiusToFahrenheit(100), 0.01, "100°C should be 212°F");
        assertEquals(98.6, converter.celsiusToFahrenheit(37), 0.01, "37°C should be 98.6°F");
    }

    @Test
    public void fahrenheitToCelsiusTest() {
        assertEquals(0.0, converter.fahrenheitToCelsius(32), 0.01, "32°F should be 0°C");
        assertEquals(100.0, converter.fahrenheitToCelsius(212), 0.01, "212°F should be 100°C");
        assertEquals(37.0, converter.fahrenheitToCelsius(98.6), 0.01, "98.6°F should be 37°C");
    }
}

