package com.Week4.Day03_Streams;
import java.io.*;

// Create ReadWriteTextFile class to read and write text files
class ReadWriteTextFile {
    // Method to copy file from source to destination
    public void copyFile(String sourcePath, String destinationPath) {
        // Create a source file
        File sourceFile = new File(sourcePath);
        if (!sourceFile.exists()) {
            System.out.println("Source file does not exist");
            return;
        }

        // Create the destination file path
        File destinationFile = new File(destinationPath);

        // Ensure the destination directory exists
        File destinationDir = destinationFile.getParentFile();
        if (destinationDir != null && !destinationDir.exists()) {
            if (!destinationDir.mkdirs()) {
                System.out.println("Failed to create destination directory.");
                return;
            }
        }

        // Create an instance of fileInputStream and fileOutputStream object
        try (FileInputStream fileInputStream = new FileInputStream(sourceFile);
             FileOutputStream fileOutputStream = new FileOutputStream(destinationFile)) {
            // Store the data
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = fileInputStream.read(buffer)) != -1) {
                fileOutputStream.write(buffer, 0, bytesRead);
            }
            System.out.println("File copied to: " + destinationPath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        // Enter the source path and destination path
        String sourcePath = "src/com/Week4/Day03/ReadWriteTextFile.java";
        String destinationPath = "Java code/ReadWriteTextFile_copy.java";

        // Create an instance of ReadWriteTextFile
        ReadWriteTextFile readWriteTextFile = new ReadWriteTextFile();
        // Call the copyFile method
        readWriteTextFile.copyFile(sourcePath, destinationPath);
    }
}
