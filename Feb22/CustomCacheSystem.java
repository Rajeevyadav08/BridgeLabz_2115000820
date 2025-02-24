package Feb22;

import java.lang.annotation.*;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

// Step 1: Define the @CacheResult annotation
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface CacheResult {}

// Step 2: Create a Cache Manager to store results
class CacheManager {
    private static final Map<String, Object> cache = new HashMap<>();

    public static Object getCachedResult(String key) {
        return cache.getOrDefault(key, null);
    }

    public static void storeResult(String key, Object result) {
        cache.put(key, result);
    }
}

// Step 3: Create a Utility to Handle Caching with Reflection
class CacheHandler {
    public static Object invokeWithCache(Object obj, String methodName, Object... args) {
        try {
            Method method = obj.getClass().getMethod(methodName, getParameterTypes(args));

            if (method.isAnnotationPresent(CacheResult.class)) {
                String cacheKey = methodName + "(" + argsToString(args) + ")";
                Object cachedValue = CacheManager.getCachedResult(cacheKey);

                if (cachedValue != null) {
                    System.out.println("Returning cached result for: " + cacheKey);
                    return cachedValue;
                }

                Object result = method.invoke(obj, args);
                CacheManager.storeResult(cacheKey, result);
                return result;
            } else {
                return method.invoke(obj, args);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private static Class<?>[] getParameterTypes(Object[] args) {
        return java.util.Arrays.stream(args)
                .map(Object::getClass)
                .toArray(Class<?>[]::new);
    }

    private static String argsToString(Object[] args) {
        return java.util.Arrays.toString(args);
    }
}

// Step 4: Create a Computationally Expensive Method
class ExpensiveService {
    @CacheResult
    public long computeFactorial(int n) {
        System.out.println("Computing factorial of " + n + "...");
        long result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }
}

// Step 5: Test the Caching System
public class CustomCacheSystem {
    public static void main(String[] args) {
        ExpensiveService service = new ExpensiveService();

        // First call (computes the result)
        System.out.println("Result: " + CacheHandler.invokeWithCache(service, "computeFactorial", 5));

        // Second call (returns cached result)
        System.out.println("Result: " + CacheHandler.invokeWithCache(service, "computeFactorial", 5));

        // Different input (computes again)
        System.out.println("Result: " + CacheHandler.invokeWithCache(service, "computeFactorial", 6));
    }
}
