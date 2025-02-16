package com.Week4.Day05.JUnit.test;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import static org.junit.jupiter.api.Assertions.*;
import java.util.concurrent.TimeUnit;

// Create TaskProcessorTest class to test TaskProcessor class
class TaskProcessorTest {

    // Create an instance of task processor
    private final TaskProcessor taskProcessor = new TaskProcessor();

    @Test
    @Timeout(value = 2, unit = TimeUnit.SECONDS)
    public void longRunningTaskTest() {
        assertEquals("Task Completed", taskProcessor.longRunningTask(),
                "Method should return 'Task Completed'");
    }
}

