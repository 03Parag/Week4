package com.Week4.Day01_Generic;
import java.util.*;
// WarehouseItem class
abstract class WarehouseItem {
    // Attributes of WarehouseItem
    private String name;
    private double price;

    // Constructor for WarehouseItem
    public WarehouseItem(String name, double price) {
        this.name = name;
        this.price = price;
    }

    // Method to get the name
    public String getName() {
        return name;
    }

    // Method to get the price
    public double getPrice() {
        return price;
    }
}

// Electronics class (SubClass)
class Electronics extends WarehouseItem {

    // Constructor for Electronics
    public Electronics(String name, double price) {
        // Call the WarehouseItem constructor
        super(name, price);
    }
}

// Groceries class (SubClass)
class Groceries extends WarehouseItem {

    // Constructor for Groceries
    public Groceries(String name, double price) {
        // Call the WarehouseItem constructor
        super(name, price);
    }
}

// Furniture class (SubClass)
class Furniture extends WarehouseItem {

    // Constructor for Furniture
    public Furniture(String name, double price) {
        // Call the WarehouseItem constructor
        super(name, price);
    }
}

// Generic Storage class
class Storage<T extends WarehouseItem> {
    // Attributes of Storage
    private List<T> items;

    // Constructor for Storage
    public Storage() {
        this.items = new ArrayList<>();
    }

    // Method to add item
    public void addItem(T item) {
        items.add(item);
    }

    // Method to get item
    public T getItem(int index) {
        // If index is postive or zero and less than items size return get index and if not then throw IndexOutOfBoundsException
        if (index >= 0 && index < items.size()) {
            return items.get(index);
        }
        throw new IndexOutOfBoundsException("Invalid index");
    }

    // Method to get the list of all items
    public List<T> getAllItems() {
        return new ArrayList<>(items);
    }
}

// WarehouseItemUtility class (display all items in storage regardless of their type)
class WarehouseItemUtility {
    // Method to display all items in storage regardless of their type
    public static void displayItems(List<? extends WarehouseItem> items) {
        for (WarehouseItem item : items) {
            System.out.println("Item: " + item.getName() + ", Price: $" + item.getPrice());
        }
    }
}

// Main class
class SmartWarehouseManagementSystem {
    public static void main(String[] args) {
        // Create storege instance for electronics , groceries and furniture each
        Storage<Electronics> electronicsStorage = new Storage<>();
        Storage<Groceries> groceriesStorage = new Storage<>();
        Storage<Furniture> furnitureStorage = new Storage<>();

        // Create electronics , groceries and furniture items each
        Electronics laptop = new Electronics("Laptop", 1000);
        Electronics smartphone = new Electronics("Smartphone" , 800);

        Groceries flour = new Groceries("Flour", 500);
        Groceries milk = new Groceries("Milk", 300);

        Furniture chair = new Furniture("Chair", 700);
        Furniture table = new Furniture("Table", 400);

        // Add items for electronics , groceries and furniture each
        electronicsStorage.addItem(laptop);
        electronicsStorage.addItem(smartphone);

        groceriesStorage.addItem(flour);
        groceriesStorage.addItem(milk);

        furnitureStorage.addItem(chair);
        furnitureStorage.addItem(table);

        // Display all items
        System.out.println("Electronics:");
        WarehouseItemUtility.displayItems(electronicsStorage.getAllItems());

        System.out.println("\nGroceries:");
        WarehouseItemUtility.displayItems(groceriesStorage.getAllItems());

        System.out.println("\nFurniture:");
        WarehouseItemUtility.displayItems(furnitureStorage.getAllItems());
    }
}
