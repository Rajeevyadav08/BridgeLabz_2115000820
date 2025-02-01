package Jan31;
import java.util.Scanner;
public class Book {
    private String title;
    private String author;
    private double price;
    public Book() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter book title: ");
        this.title = scanner.nextLine();
        System.out.print("Enter book author: ");
        this.author = scanner.nextLine();
        System.out.print("Enter book price: ");
        while (!scanner.hasNextDouble()) {
            System.out.print("Invalid input. Enter book price: ");
            scanner.next();
        }
        this.price = scanner.nextDouble();
    }
    public String getTitle() {
        return title;
    }
    public String getAuthor() {
        return author;
    }
    public double getPrice() {
        return price;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public void displayBookInfo() {
        System.out.println("Book Details - ");
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Price: $" + price);
    }
    public static void main(String[] args) {
        Book userBook = new Book();
        userBook.displayBookInfo();
    }
}
