package com.Week4.Day03_Streams;
import java.io.*;

class UpperToLowerCaseConverter {
    // Attributes of UpperToLowerCaseConverter
    private final String sourceFile;
    private final String destinationFile;

    // Constructor for UpperToLowerCaseConverter
    public UpperToLowerCaseConverter(String sourceFile, String destinationFile) {
        this.sourceFile = sourceFile;
        this.destinationFile = destinationFile;
    }

    // Method to read from the source file, convert to lowercase, and write to destination file
    public void convertToLowerCase() {
        // Create an instance of BufferedReader, BufferedReader, FileReader and FileWriter object
        try (BufferedReader reader = new BufferedReader(new FileReader(sourceFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(destinationFile))) {

            int ch;
            while ((ch = reader.read()) != -1) {
                writer.write(Character.toLowerCase(ch));
            }

            System.out.println("File converted successfully: " + destinationFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        // Enter the source and destination file
        String source = "src/com/Week4/Day03/UpperToLowerCaseConverter.java";
        String destination = "Java code/UpperToLowerCaseConverter_Copy.java";

        // Create an instance of UpperToLowerCaseConverter object
        UpperToLowerCaseConverter converter = new UpperToLowerCaseConverter(source, destination);

        // Convert to lowercase
        converter.convertToLowerCase();
    }
}

