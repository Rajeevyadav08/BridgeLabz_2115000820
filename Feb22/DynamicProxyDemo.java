package Feb22;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

// Step 1: Define an Interface
interface Service {
    void performTask(String task);
    int computeSum(int a, int b);
}

// Step 2: Implement the Interface
class ServiceImpl implements Service {
    @Override
    public void performTask(String task) {
        System.out.println("Executing task: " + task);
    }

    @Override
    public int computeSum(int a, int b) {
        return a + b;
    }
}

// Step 3: Create a Dynamic Proxy Handler
class LoggingProxyHandler implements InvocationHandler {
    private final Object target;

    public LoggingProxyHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // Logging before method execution
        System.out.println("[LOG] Method called: " + method.getName());
        System.out.println("[LOG] Arguments: " + (args != null ? java.util.Arrays.toString(args) : "None"));

        // Invoke actual method
        Object result = method.invoke(target, args);

        // Logging after method execution
        System.out.println("[LOG] Method " + method.getName() + " executed successfully.");

        return result;
    }
}

// Step 4: Create and Use the Proxy
public class DynamicProxyDemo {
    public static void main(String[] args) {
        // Create the actual service instance
        Service realService = new ServiceImpl();

        // Create a dynamic proxy
        Service proxyInstance = (Service) Proxy.newProxyInstance(
                Service.class.getClassLoader(),
                new Class[]{Service.class},
                new LoggingProxyHandler(realService)
        );

        // Use the proxy instance
        proxyInstance.performTask("File Processing");
        int sum = proxyInstance.computeSum(10, 20);
        System.out.println("Computed Sum: " + sum);
    }
}

