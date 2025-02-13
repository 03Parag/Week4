package com.Week4.Day01_Generic;
import java.util.*;
// Product class (Generic class)
class Product<T> {
    // Attributes of product
    private String name;
    private double price;
    private T category;

    // Constructor for product
    public Product(String name, double price, T category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    // Method to get the name
    public String getName() {
        return name;
    }

    // Method to get the price
    public double getPrice() {
        return price;
    }

    // Method to get the category
    public T getCategory() {
        return category;
    }

    // Method to set the price
    public void setPrice(double price) {
        this.price = price;
    }
}

// Generic Store class
class Store<T extends Product<?>> {
    // Attributes of store
    private List<T> items;

    // Constructor for store
    public Store() {
        this.items = new ArrayList<>();
    }

    // Method to add item
    public void addItem(T item) {
        items.add(item);
    }

    // Method to get the item
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

// Utility class (managing product discounts)
class ProductUtility {
    // Method to manage product discount
    public static <T extends Product> void applyDiscount(T product, double percentage) {
        // If percentage is less than 0 or more than 100 throw IllegalArgumentException
        if (percentage < 0 || percentage > 100) {
            throw new IllegalArgumentException("Discount must be between 0% and 100%");
        }
        // Get the new price
        double newPrice = product.getPrice() - (product.getPrice() * (percentage / 100));
        // Set the new price
        product.setPrice(newPrice);
        System.out.println("Applied " + percentage + "% discount on " + product.getName() + ". New Price: Rs" + newPrice);
    }

    // Method to display products
    public static <T> void displayItems(List<Product<T>> items) {
        for (Product<T> item : items) {
            System.out.println("Product: " + item.getName() + ", Category: " + item.getCategory() + ", Price: $" + item.getPrice());
        }
    }
}

// Main class
class DynamicOnlineMarketplace {
    public static void main(String[] args) {
        // Create storage instances for books, clothing, and gadgets
        Store<Product<String>> bookStorage = new Store<>();
        Store<Product<String>> clothingStorage = new Store<>();
        Store<Product<String>> gadgetStorage = new Store<>();

        // Create products with specific categories (String-based categories)
        Product<String> book1 = new Product<>("The Wing's of Fire", 200.0, "Book");
        Product<String> book2 = new Product<>("Rich Dad Poor Dad", 250.0, "Book");

        Product<String> tshirt = new Product<>("Men's T-Shirt", 150.0, "Clothing");
        Product<String> dress = new Product<>("Women's Dress", 500.0, "Clothing");

        Product<String> smartphone = new Product<>("Smartphone", 800.0, "Gadget");
        Product<String> laptop = new Product<>("Laptop", 1200.0, "Gadget");

        // Add items to storage
        bookStorage.addItem(book1);
        bookStorage.addItem(book2);

        clothingStorage.addItem(tshirt);
        clothingStorage.addItem(dress);

        gadgetStorage.addItem(smartphone);
        gadgetStorage.addItem(laptop);

        // Display all items
        System.out.println("Books:");
        ProductUtility.displayItems(bookStorage.getAllItems());

        System.out.println("\nClothing:");
        ProductUtility.displayItems(clothingStorage.getAllItems());

        System.out.println("\nGadgets:");
        ProductUtility.displayItems(gadgetStorage.getAllItems());

        // Apply discount dynamically
        System.out.println("\nApplying Discount:");
        ProductUtility.applyDiscount(smartphone, 10);
        ProductUtility.applyDiscount(book1, 5);
    }
}

