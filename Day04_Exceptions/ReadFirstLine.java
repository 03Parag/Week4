package com.Week4.Day04_Exceptions;
import java.io.*;

// Create a ReadFirstLineclass to read the first line of a file and if file don't exist give IOException
class ReadFirstLine {
    public static void main(String[] args) {
        // Enter the file path
        String filePath = "info.txt";

        // Create an instance of bufferedreader object
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            // Read the first line from the file
            String firstLine = reader.readLine();

            // If the first line is not empty print it
            if (firstLine != null) {
                System.out.println("First line: " + firstLine);
            } else {
                System.out.println("File is empty");
            }
        } catch (IOException e) {
            System.err.println("Error reading file");
        }
    }
}
