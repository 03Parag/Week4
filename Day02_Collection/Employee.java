package com.Week4.Day02_Collection;
import java.util.*;

// Employee class with name and department attributes
class Employee {
    // Attributes of Employee
    private String name;
    private String department;

    // Constructor for Employee
    public Employee(String name, String department) {
        this.name = name;
        this.department = department;
    }

    // Method to get the name
    public String getName() {
        return name;
    }

    // Method to get the department
    public String getDepartment() {
        return department;
    }

    // Method to find the object is equal
    public boolean equals(Object obj) {
        // If this object is equal return true
        if (this == obj)
            return true;
        // If object is null or not equal return false
        if (obj == null || getClass() != obj.getClass())
            return false;
        Employee employee = (Employee) obj;
        return Objects.equals(name, employee.name) && Objects.equals(department, employee.department);
    }

    // Method to get the hashcode
    public int hashCode() {
        return Objects.hash(name, department);
    }
}

// Class to group employees by their department
class EmployeeGrouping {
    // Method to group employees by department
    public Map<String, List<Employee>> groupByDepartment(List<Employee> employees) {
        // Create an instance of map
        Map<String, List<Employee>> departmentMap = new HashMap<>();

        // Loop through the list of employees
        for (Employee employee : employees) {
            String department = employee.getDepartment();

            // If the department is not already in the map then add it with a new list
            departmentMap.putIfAbsent(department, new ArrayList<>());

            // Add the employee to the list corresponding to the department
            departmentMap.get(department).add(employee);
        }

        return departmentMap;
    }

    public static void main(String[] args) {
        // Create a list of employees and add new employee
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Alice", "HR"));
        employees.add(new Employee("Bob", "IT"));
        employees.add(new Employee("Carol", "HR"));

        // Create an instance of EmployeeGrouping
        EmployeeGrouping grouping = new EmployeeGrouping();

        // Group employees by department
        Map<String, List<Employee>> groupedEmployees = grouping.groupByDepartment(employees);

        // Print the grouped employees
        for (Map.Entry<String, List<Employee>> entry : groupedEmployees.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}

