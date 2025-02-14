package com.Week4.Day03_Streams;
import java.io.*;

// Create InterThreadCommunication class to write data through one and read through other
class InterThreadCommunication {
    // Attributes of InterThreadCommunication
    private final PipedOutputStream pipedOutputStream;
    private final PipedInputStream pipedInputStream;

    // Constructor for InterThreadCommunication
    public InterThreadCommunication() throws IOException {
        this.pipedOutputStream = new PipedOutputStream();
        this.pipedInputStream = new PipedInputStream(pipedOutputStream);
    }

    // Method to get the output stream
    public PipedOutputStream getOutputStream() {
        return pipedOutputStream;
    }

    // Method to get the input stream
    public PipedInputStream getInputStream() {
        return pipedInputStream;
    }

    // Method to close stream
    public void closeStreams() {
        try {
            pipedOutputStream.close();
            pipedInputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

// WriterThread class extends Thread
class WriterThread extends Thread {
    // Attributes of WriterThread
    private final PipedOutputStream pipedOutputStream;

    // Constructor for WriterThread
    public WriterThread(PipedOutputStream pipedOutputStream) {
        this.pipedOutputStream = pipedOutputStream;
    }

    // Override the run() method
    @Override
    public void run() {
        try (pipedOutputStream) {
            String message = "Hello from Writer Thread!";
            byte[] data = message.getBytes();
            pipedOutputStream.write(data);
            System.out.println("Writer: Data written to pipe.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

// ReaderThread class extends Thread
class ReaderThread extends Thread {
    // Attributes of ReaderThread
    private final PipedInputStream pipedInputStream;

    // Constructor for ReaderTHread
    public ReaderThread(PipedInputStream pipedInputStream) {
        this.pipedInputStream = pipedInputStream;
    }

    // Override the run() method
    @Override
    public void run() {
        try (pipedInputStream) {
            byte[] buffer = new byte[1024];
            int bytesRead = pipedInputStream.read(buffer);
            String receivedMessage = new String(buffer, 0, bytesRead);
            System.out.println("Reader: Received - " + receivedMessage);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class PipedStream {
    public static void main(String[] args) {
        try {
            // Create an InterThreadCommunication object
            InterThreadCommunication communication = new InterThreadCommunication();

            // Create instnace of WriterThread and ReaderThread object
            WriterThread writer = new WriterThread(communication.getOutputStream());
            ReaderThread reader = new ReaderThread(communication.getInputStream());

            // Start both threads
            writer.start();
            reader.start();

            // Wait for both threads to finish
            writer.join();
            reader.join();

            // Close streams after threads complete
            communication.closeStreams();

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}

