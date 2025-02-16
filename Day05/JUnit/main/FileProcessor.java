package com.Week4.Day05.JUnit.main;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

// Create FileProcessor class to read and write a file
class FileProcessor {
    // Method to write content to a file
    public void writeToFile(String filename, String content) throws IOException {
        Files.write(Path.of(filename), content.getBytes(), StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
    }

    // Method to read content from a file
    public String readFromFile(String filename) throws IOException {
        return Files.readString(Path.of(filename));
    }
}

