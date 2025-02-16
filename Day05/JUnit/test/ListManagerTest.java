package com.Week4.Day05.JUnit.test;

import org.junit.jupiter.api.*;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

// Create a ListManagerTest class to test ListManager class
class ListManagerTest {
    // Create an instance of ListManager
    ListManager listManager = new ListManager();

    @Test
    public void addElementTest() {
        List<Integer> list = new ArrayList<>();
        listManager.addElement(list, 5);
        assertEquals(1, list.size(), "List size should be 1 after adding an element");
        assertTrue(list.contains(5), "List should contain the added element 5");
    }

    @Test
    public void removeElementTest() {
        List<Integer> list = new ArrayList<>();
        list.add(5);
        list.add(10);
        listManager.removeElement(list, 5);
        assertEquals(1, list.size(), "List size should be 1 after removing an element");
        assertFalse(list.contains(5), "List should not contain the removed element 5");
    }

    @Test
    public void removeNonExistentElementTest() {
        List<Integer> list = new ArrayList<>();
        list.add(10);
        listManager.removeElement(list, 5); // Trying to remove a non-existent element
        assertEquals(1, list.size(), "List size should remain unchanged if element doesn't exist");
    }

    @Test
    public void testGetSize() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        assertEquals(2, listManager.getSize(list), "List size should be 2");
    }

    @Test
    public void testGetSizeEmptyList() {
        List<Integer> list = new ArrayList<>();
        assertEquals(0, listManager.getSize(list), "Size of an empty list should be 0");
    }

    @Test
    public void testNullListThrowsException() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> listManager.addElement(null, 5));
        assertEquals("List cannot be null", exception.getMessage());

        exception = assertThrows(IllegalArgumentException.class, () -> listManager.removeElement(null, 5));
        assertEquals("List cannot be null", exception.getMessage());

        exception = assertThrows(IllegalArgumentException.class, () -> listManager.getSize(null));
        assertEquals("List cannot be null", exception.getMessage());
    }
}
