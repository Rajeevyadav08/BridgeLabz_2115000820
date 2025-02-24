package Feb22;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.ElementType;
import java.lang.annotation.Target;
import java.lang.reflect.AnnotatedElement;

// Step 1: Define Custom Annotation @Author
@Retention(RetentionPolicy.RUNTIME) // Retain annotation at runtime
@Target(ElementType.TYPE) // Applicable to classes
@interface Author {
    String name();
}

// Step 2: Apply Annotation to a Class
@Author(name = "John Doe")
class Book {
    private String title;
    private int pages;

    public Book(String title, int pages) {
        this.title = title;
        this.pages = pages;
    }
}

// Step 3: Use Reflection to Retrieve and Display Annotation Value
public class AnnotationRetrieval {
    public static void main(String[] args) {
        Class<Book> clazz = Book.class;

        if (clazz.isAnnotationPresent(Author.class)) {
            Author author = clazz.getAnnotation(Author.class);
            System.out.println("Author Name: " + author.name());
        } else {
            System.out.println("No @Author annotation present.");
        }
    }
}
