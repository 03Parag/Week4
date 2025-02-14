package com.Week4.Day03_Streams;
import java.io.*;
import java.util.Arrays;

// Create ImageByteArrayConverter class to convert image to byte array and back to image
 class ImageByteArrayConverter {
    // Attributes of ImageByteArrayConverter
    private final String sourcePath;
    private final String destinationPath;

    // Constructor for ImageByteArrayConverter
    public ImageByteArrayConverter(String sourcePath, String destinationPath) {
        this.sourcePath = sourcePath;
        this.destinationPath = destinationPath;
    }

    // Method to convert image file to byte array
    public byte[] convertImageToByteArray() {
        // Create an instance of FileInputStream and ByteArrayOutputStream object
        try (FileInputStream fileInputStream = new FileInputStream(sourcePath); ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream()) {
            // Create a buffer of size 4KB
            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = fileInputStream.read(buffer)) != -1) {
                byteArrayOutputStream.write(buffer, 0, bytesRead);
            }
            return byteArrayOutputStream.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
            return new byte[0];
        }
    }

    // Method to write byte array back to an image file
    public void writeByteArrayToImage(byte[] imageData) {
        try (ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(imageData); FileOutputStream fileOutputStream = new FileOutputStream(destinationPath)) {
            // Create a buffer of size 4KB
            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = byteArrayInputStream.read(buffer)) != -1) {
                fileOutputStream.write(buffer, 0, bytesRead);
            }
            System.out.println("Image written successfully to: " + destinationPath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Method to verify if the original and new image files are identical
    public boolean verifyFiles() {
        try (FileInputStream fileInputStream1 = new FileInputStream(sourcePath); FileInputStream fileInputStream2 = new FileInputStream(destinationPath); ByteArrayOutputStream byteArrayOutputStream1 = new ByteArrayOutputStream(); ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream()) {
            // Create a buffer of size 4KB
            byte[] buffer = new byte[4096];
            int bytesRead;

            while ((bytesRead = fileInputStream1.read(buffer)) != -1) {
                byteArrayOutputStream1.write(buffer, 0, bytesRead);
            }

            while ((bytesRead = fileInputStream2.read(buffer)) != -1) {
                byteArrayOutputStream2.write(buffer, 0, bytesRead);
            }

            return Arrays.equals(byteArrayOutputStream1.toByteArray(), byteArrayOutputStream2.toByteArray());
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static void main(String[] args) {
        // Enter the source and destination image
        String sourceImage = "Java code/Original.png";
        String destinationImage = "Java code/Copy.png";

        // Create an instance of ImageByteArrayConverter object
        ImageByteArrayConverter converter = new ImageByteArrayConverter(sourceImage, destinationImage);

        // Convert image to byte array
        byte[] imageData = converter.convertImageToByteArray();

        // Write byte array back to an image file
        if (imageData.length > 0) {
            converter.writeByteArrayToImage(imageData);

            // Verify file integrity
            if (converter.verifyFiles()) {
                System.out.println("Verification successful,  Files are identical.");
            } else {
                System.out.println("Verification failed, Files are different.");
            }
        }
    }
}
