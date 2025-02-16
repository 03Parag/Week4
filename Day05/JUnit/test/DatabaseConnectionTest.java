package com.Week4.Day05.JUnit.test;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

// Create DatabaseConnectionTest class to test DatabaseConnection class
class DatabaseConnectionTest {
    // Create an instance of database connection
    private DatabaseConnection databaseConnection;

    @BeforeEach
    public void setUp() {
        databaseConnection = new DatabaseConnection();
        databaseConnection.connect();
    }

    @AfterEach
    public void tearDown() {
        databaseConnection.disconnect();
    }

    @Test
    public void connectionEstablishedTest() {
        assertTrue(databaseConnection.isConnected(), "Database should be connected after setup");
    }

    @Test
    public void connectionClosedTest() {
        databaseConnection.disconnect();
        assertFalse(databaseConnection.isConnected(), "Database should be disconnected after calling disconnect()");
    }
}

