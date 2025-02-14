package com.Week4.Day03_Streams;
import java.io.*;

// Create FileCopy class to copy file from source to destination file using buffered and unbuffered stream
class FileCopy {
    // Create final buffer size of 4KB
    private static final int BufferSize= 4096;

    // Method to copy file using Buffered Streams
    public void copyWithBufferedStreams(String sourceFile, String destinationFile) {
        double startTimeBuffer = System.nanoTime();
        // Create an instance of BufferedInputStream and BufferedOutputStream object
        try (BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(sourceFile)); BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(destinationFile))) {

            byte[] buffer = new byte[BufferSize];
            int bytesRead;
            while ((bytesRead = bufferedInputStream.read(buffer)) != -1) {
                bufferedOutputStream.write(buffer, 0, bytesRead);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        double endTimeBuffer = System.nanoTime();
        double durationTimeBuffer = (endTimeBuffer - startTimeBuffer) / 1000000;
        System.out.println("Buffered Streams Copy Time: " + durationTimeBuffer + " ms");
    }

    // Method to copy file using Unbuffered Streams
    public void copyWithUnbufferedStreams(String sourceFile, String destinationFile) {
        double startTimeUnbuffer = System.nanoTime();

        // Create an instance of fileInputStream and fileOutputStream object
        try (FileInputStream fileInputStream = new FileInputStream(sourceFile);
             FileOutputStream fileOutputStream = new FileOutputStream(destinationFile)) {
            // Store the data
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = fileInputStream.read(buffer)) != -1) {
                fileOutputStream.write(buffer, 0, bytesRead);
            }
            System.out.println("File copied to: " + destinationFile);
        } catch (IOException e) {
            e.printStackTrace();
        }

        double endTimeUnbuffer = System.nanoTime();
        double durationTimeUnbuffer = (endTimeUnbuffer - startTimeUnbuffer) / 1000000;
        System.out.println("Unbuffered Streams Copy Time: " + durationTimeUnbuffer + " ms");
    }

    public static void main(String[] args) {
        // Enter the source, destination buffer and destination unbuffer file
        String sourceFile = "src/com/Week4/Day03/FileCopy.java";
        String destinationBuffered = "Java code/FileCopyBuffered_copy.java";
        String destinationUnbuffered = "Java code/FileCopyUnbuffered_copy.java";

        // Create an instanc eof file copy
        FileCopy fileCopy = new FileCopy();

        // Get the copyWithBufferedStreams() method
        System.out.println("Copying file using Buffered Streams");
        fileCopy.copyWithBufferedStreams(sourceFile, destinationBuffered);

        // Get the copyWithUnbufferedStreams() method
        System.out.println("\nCopying file using Unbuffered Streams");
        fileCopy.copyWithUnbufferedStreams(sourceFile, destinationUnbuffered);
    }
}

