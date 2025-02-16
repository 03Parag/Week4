package com.Week4.Day06.Reflection.Advanced_Level;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

// Create an interface with methods to be proxied
interface Greeting {
    void sayHello(String name);
    void sayGoodbye(String name);
}

// Implement the Greeting interface
class GreetingImpl implements Greeting {
    @Override
    public void sayHello(String name) {
        System.out.println("Hello, " + name + "!");
    }

    @Override
    public void sayGoodbye(String name) {
        System.out.println("Goodbye, " + name + "!");
    }
}

// Define a Dynamic Proxy to log method calls
class LoggingProxyHandler implements InvocationHandler {
    private final Object target;

    public LoggingProxyHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // Log the method name before executing it
        System.out.println("Executing method: " + method.getName());

        // Execute the actual method on the target object
        return method.invoke(target, args);
    }
}

// Utility class to create a proxy instance
class ProxyFactory {
    @SuppressWarnings("unchecked")
    public static <T> T createProxy(T target, Class<T> interfaceType) {
        return (T) Proxy.newProxyInstance(
                interfaceType.getClassLoader(),
                new Class<?>[]{interfaceType},
                new LoggingProxyHandler(target)
        );
    }
}

// DynamicProxy class
class DynamicProxy {
    public static void main(String[] args) {
        // Create an instance of the real implementation
        Greeting realGreeting = new GreetingImpl();

        // Create a proxy instance
        Greeting proxyGreeting = ProxyFactory.createProxy(realGreeting, Greeting.class);

        // Invoke methods via proxy (will log method calls)
        proxyGreeting.sayHello("Alice");
        proxyGreeting.sayGoodbye("Bob");
    }
}

