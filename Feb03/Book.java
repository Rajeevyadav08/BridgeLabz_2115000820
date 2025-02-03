package Feb03;

import java.util.Scanner;
public class Book {
    private static String libraryName = "Central Library";
    private final String isbn;
    private String title;
    private String author;
    public Book(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
    }
    public static void displayLibraryName() {
        System.out.println("Library Name: " + libraryName);
    }
    public void displayBookDetails() {
        if (this instanceof Book) {
            System.out.println("\nLibrary: " + libraryName);
            System.out.println("Title: " + title);
            System.out.println("Author: " + author);
            System.out.println("ISBN: " + isbn);
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of books to add: ");
        int n = scanner.nextInt();
        scanner.nextLine();
        Book[] books = new Book[n];
        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter details for Book " + (i + 1) + ":");
            System.out.print("Enter Book Title: ");
            String title = scanner.nextLine();
            System.out.print("Enter Author Name: ");
            String author = scanner.nextLine();
            System.out.print("Enter ISBN: ");
            String isbn = scanner.nextLine();
            books[i] = new Book(title, author, isbn);
        }
        displayLibraryName();
        System.out.println("\n--- Book Collection ---");
        for (Book book : books) {
            book.displayBookDetails();
        }
        scanner.close();
    }
}

