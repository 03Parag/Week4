package com.Week4.Day03_Streams;
import java.io.*;
import java.util.*;

// Create Employee class to implement serializable
class Employee implements Serializable {
    // Create a final serialVersionUID
    private static final long serialVersionUID = 1L;

    // Attributes of Employee
    private int id;
    private String name;
    private String department;
    private double salary;

    //Constructor for Employee
    public Employee(int id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    // Method to display details
    public void display() {
        System.out.println("\nID: " + id + "\nName: " + name + "\nDepartment: " + department + "\nSalary: " + salary);
    }
}

// EmployeeSerialization class
 class EmployeeSerialization {
    // Attributes of EmployeeSerialization
    private final String filePath;

    // Constructor for EmployeeSerialization
    public EmployeeSerialization(String filePath) {
        this.filePath = filePath;
    }

    // Method to serialize and save employees to a file
    public void saveEmployees(List<Employee> employees) {
        // Create an instance of objectoutputstream object
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
            oos.writeObject(employees);
            System.out.println("Employees saved successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // // Method to deserialize and retrieve employees from a file
    public List<Employee> loadEmployees() {
        List<Employee> employees = new ArrayList<>();
        // Create an objectinputstream object
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
            employees = (List<Employee>) ois.readObject();
            System.out.println("Employees loaded successfully!");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return employees;
    }

    public static void main(String[] args) {
        // Enter a filePath
        String filePath = "Java code/SerialEmployee.java";
        // Create an instance of EmployeeSerialization object
        EmployeeSerialization manager = new EmployeeSerialization(filePath);

        // Add employee in a file
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(1, "Alice", "HR", 50000));
        employees.add(new Employee(2, "Bob", "IT", 75000));
        employees.add(new Employee(3, "Charlie", "Finance", 60000));

        // Serialize employees
        manager.saveEmployees(employees);

        // Deserialize employees
        List<Employee> loadedEmployees = manager.loadEmployees();
        System.out.println("\nRetrieved Employees:");
        for (Employee emp : loadedEmployees) {
            emp.display();
        }
    }
}

