package com.Week4.Day05.JUnit.main;

// Create DatabaseConnection class with connect and disconnect method
class DatabaseConnection {
    // Create a isConnected boolean
    private boolean isConnected;

    // Method to connect with database
    public void connect() {
        isConnected = true;
        System.out.println("Database connected.");
    }

    // Method to disconnect with database
    public void disconnect() {
        isConnected = false;
        System.out.println("Database disconnected.");
    }

    // Method to find if database is connected
    public boolean isConnected() {
        return isConnected;
    }
}

