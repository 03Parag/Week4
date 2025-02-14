package com.Week4.Day03_Streams;
import java.io.*;

class StoreRetrievePrimitiveData {
    // Attributes of StoreRetrievePrimitiveData
    private final String filePath;

    // Constructor for StoreRetrievePrimitiveData
    public StoreRetrievePrimitiveData(String filePath) {
        this.filePath = filePath;
    }

    // Method to write student data in a binary file
    public void writeStudentData(int rollNumber, String name, double gpa) {
        // Create an DataOutputStream object
        try (DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream(filePath, true))) {
            dataOutputStream.writeInt(rollNumber);
            dataOutputStream.writeUTF(name);
            dataOutputStream.writeDouble(gpa);
            System.out.println("Student data saved: " + rollNumber + ", " + name + ", " + gpa);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Method to read student data from the binary file
    public void readStudentData() {
        // Create an DataInputStream object
        try (DataInputStream dataInputStream = new DataInputStream(new FileInputStream(filePath))) {
            System.out.println("\nStored Student Details:");
            while (dataInputStream.available() > 0) {
                int rollNumber = dataInputStream.readInt();
                String name = dataInputStream.readUTF();
                double gpa = dataInputStream.readDouble();
                System.out.println("Roll No: " + rollNumber + ", Name: " + name + ", GPA: " + gpa);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        // Enter the file path
        String filePath = "Java code/StudentData.java";
        // Create an instance of StoreRetrievePrimitiveData object
        StoreRetrievePrimitiveData handler = new StoreRetrievePrimitiveData(filePath);

        // Writing student details
        handler.writeStudentData(101, "Alice", 3.8);
        handler.writeStudentData(102, "Bob", 3.6);
        handler.writeStudentData(103, "Charlie", 3.9);

        // Reading and displaying student details
        handler.readStudentData();
    }
}

