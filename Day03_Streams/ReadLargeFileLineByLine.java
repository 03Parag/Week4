package com.Week4.Day03_Streams;
import java.io.*;

// Create ReadLargeFileLineByLine class to read a large file line by line and print line that contain error
class ReadLargeFileLineByLine {
    // Attributes of ReadLargeFileLineByLine
    private final String filePath;

    // Constructor for ReadLargeFileLineByLine
    public ReadLargeFileLineByLine(String filePath) {
        this.filePath = filePath;
    }

    // Method to print error lines
    public void printErrorLines() {
        // Create an instance of BufferedReader object
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.toLowerCase().contains("error")) {
                    System.out.println(line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        // Enter the file path
        String filePath = "Java code/largefile.txt";

        // Create an instance of ReadLargeFileLineByLine object
        ReadLargeFileLineByLine fileReader = new ReadLargeFileLineByLine(filePath);

        // Print the error lines
        fileReader.printErrorLines();
    }
}

