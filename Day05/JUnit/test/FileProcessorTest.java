package com.Week4.Day05.JUnit.test;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

// Create FileProcessorTest class to test FileProcessor class
class FileProcessorTest {
    // Enter the test file and create an instance of file processor
    private static final String TEST_FILE = "testfile.txt";
    private final FileProcessor fileProcessor = new FileProcessor();

    @BeforeEach
    public void setUp() throws IOException {
        Files.deleteIfExists(Path.of(TEST_FILE));
    }

    @AfterEach
    public void tearDown() throws IOException {
        Files.deleteIfExists(Path.of(TEST_FILE));
    }

    @Test
    public void writeToFileTest() throws IOException {
        String content = "Hello, JUnit!";
        fileProcessor.writeToFile(TEST_FILE, content);

        assertTrue(Files.exists(Path.of(TEST_FILE)), "File should exist after writing");
    }

    @Test
    public void readFromFileTest() throws IOException {
        String content = "JUnit file handling test";
        fileProcessor.writeToFile(TEST_FILE, content);

        String readContent = fileProcessor.readFromFile(TEST_FILE);
        assertEquals(content, readContent, "Read content should match written content");
    }

    @Test
    public void readFromFile_FileNotFoundTest() {
        Exception exception = assertThrows(IOException.class, () -> {
            fileProcessor.readFromFile("non_existent.txt");
        });

        assertTrue(exception.getMessage().contains("non_existent.txt"), "Exception message should indicate missing file");
    }
}

