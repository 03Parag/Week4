package com.Week4.Day02_Collection;
import java.util.*;

// Create ShoppingCart class store price, maintain the order of item and display the item sorted by price
class ShoppingCart {
    // Attributes of ShoppingCart
    private Map<String, Double> priceMap;
    private LinkedHashMap<String, Double> orderMap;
    private TreeMap<Double, List<String>> sortedByPriceMap;

    // Constructor for ShoppingCart
    public ShoppingCart() {
        this.priceMap = new HashMap<>();
        this.orderMap = new LinkedHashMap<>();
        this.sortedByPriceMap = new TreeMap<>();
    }

    // Method to add product
    public void addProduct(String product, double price) {
        priceMap.put(product, price);
        orderMap.put(product, price);
        sortedByPriceMap.computeIfAbsent(price, k -> new ArrayList<>()).add(product);
    }

    // Method to display product details
    public void displayProductPrices() {
        System.out.println("Product Prices (Unordered - HashMap):");
        for (Map.Entry<String, Double> entry : priceMap.entrySet()) {
            System.out.println(entry.getKey() + " -> Rs" + entry.getValue());
        }
    }

    // Method to display added order
    public void displayAddedOrder() {
        System.out.println("\nItems in Order Added (LinkedHashMap - Insertion Order):");
        for (Map.Entry<String, Double> entry : orderMap.entrySet()) {
            System.out.println(entry.getKey() + " -> $" + entry.getValue());
        }
    }

    // Method to display item sorted by price
    public void displaySortedByPrice() {
        System.out.println("\nItems Sorted by Price (TreeMap - Price Order):");
        for (Map.Entry<Double, List<String>> entry : sortedByPriceMap.entrySet()) {
            System.out.println("$" + entry.getKey() + " -> " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        // Create an instance of ShoppingCart
        ShoppingCart cart = new ShoppingCart();

        // Get the add product method
        cart.addProduct("Laptop", 999.99);
        cart.addProduct("Phone", 499.49);
        cart.addProduct("Headphones", 199.99);
        cart.addProduct("Monitor", 299.99);
        cart.addProduct("Mouse", 49.99);
        cart.addProduct("Keyboard", 99.99);

        // Get the display product price method
        cart.displayProductPrices();
        cart.displayAddedOrder();
        cart.displaySortedByPrice();
    }
}

