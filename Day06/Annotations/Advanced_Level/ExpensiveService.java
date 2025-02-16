package com.Week4.Day06.Annotations.Advanced_Level;
import java.lang.annotation.*;
import java.lang.reflect.*;
import java.util.*;

// Define @CacheResult Annotation
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface CacheResult {}

// Implement a Computationally Expensive Service
class ExpensiveService {

    @CacheResult
    public int computeSquare(int number) {
        System.out.println("Computing square of: " + number);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        return number * number;
    }
}

// Implement Caching Handler Using Proxy
class CacheHandler implements InvocationHandler {
    private final Object target;
    private final Map<String, Object> cache = new HashMap<>();

    public CacheHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (method.isAnnotationPresent(CacheResult.class)) {
            String cacheKey = method.getName() + ":" + args[0];
            if (cache.containsKey(cacheKey)) {
                System.out.println("Returning cached result for: " + args[0]);
                return cache.get(cacheKey);
            }
            Object result = method.invoke(target, args);
            cache.put(cacheKey, result);
            return result;
        }
        return method.invoke(target, args);
    }
}

// Create a Proxy for Caching
@SuppressWarnings("unchecked")
class CacheProxy {
    public static <T> T createProxy(T obj, Class<T> interfaceClass) {
        return (T) Proxy.newProxyInstance(
                interfaceClass.getClassLoader(),
                new Class<?>[]{interfaceClass},
                new CacheHandler(obj)
        );
    }
}

// Test the Caching System
class CustomCacheAnnotationExample {
    public static void main(String[] args) {
        ExpensiveService originalService = new ExpensiveService();
        ExpensiveService cachedService = CacheProxy.createProxy(originalService, ExpensiveService.class);

        // First call - Executes normally
        System.out.println("Result: " + cachedService.computeSquare(5));

        // Second call - Retrieves from cache
        System.out.println("Result: " + cachedService.computeSquare(5));

        // New input - Computes again
        System.out.println("Result: " + cachedService.computeSquare(7));
    }
}

