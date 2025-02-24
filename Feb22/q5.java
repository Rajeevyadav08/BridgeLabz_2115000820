package Feb22;

import java.lang.annotation.*;
import java.lang.reflect.Method;

// Step 1: Define a container annotation
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface BugReports {
    BugReport[] value();
}

// Step 2: Define the repeatable annotation
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Repeatable(BugReports.class)
@interface BugReport {
    String description();
}

// Step 3: Apply the annotation multiple times
class Software {
    @BugReport(description = "Null pointer exception in edge cases.")
    @BugReport(description = "Performance issue when handling large data.")
    public void process() {
        System.out.println("Processing software task...");
    }
}

// Step 4: Retrieve and print all bug reports using Reflection API
public class q5 {
    public static void main(String[] args) throws Exception {
        Method method = Software.class.getMethod("process");

        if (method.isAnnotationPresent(BugReports.class)) {
            BugReport[] bugReports = method.getAnnotationsByType(BugReport.class);
            for (BugReport report : bugReports) {
                System.out.println("Bug Report: " + report.description());
            }
        }

        // Calling the annotated method
        Software software = new Software();
        software.process();
    }
}
