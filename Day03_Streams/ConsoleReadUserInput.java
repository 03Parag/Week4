package com.Week4.Day03_Streams;
import java.io.*;

// Create ConsoleReadUserInput class to read user input and store it into a file
class ConsoleReadUserInput {
    // Attributes of ConsoleReadUserInput
    private String filePath;

    // Constructor for ConsoleReadUserInput
    public ConsoleReadUserInput(String filePath) {
        this.filePath = filePath;
    }
    // Method to save user input in a file
    public void saveUserInput()  {
        // Create an instance of buffered reader and file writer object
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)); FileWriter writer = new FileWriter(filePath, true)) {

            System.out.println("Enter your name: ");
            String name = reader.readLine();

            System.out.println("Enter your age: ");
            String age = reader.readLine();

            System.out.println("Enter your favorite programming language: ");
            String language = reader.readLine();

            String userInfo = "\nName: " + name + "\nAge: " + age + "\nFavorite Language: " + language;
            writer.write(userInfo);

            System.out.println("User information saved");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        // Enter the file
        String filePath = "Java code/ConsoleWrite.java";

        // Create an instance of ConsoleReadUserInput
        ConsoleReadUserInput consoleReadUserInput = new ConsoleReadUserInput(filePath);

        // Get the saveUserInput method
        consoleReadUserInput.saveUserInput();
    }
}
