package com.Week4.Day04_Exceptions;
import java.io.*;

// Create ReadFile class to read a file and if file don't exist print message
class ReadFile {
    public static void main(String[] args) {
        // Enter the file path
        String filePath = "data.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.err.println("File not found");
        }
    }
}
