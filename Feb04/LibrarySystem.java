package Feb04;

import java.util.ArrayList;
import java.util.List;

class Book {
    private String title;
    private String author;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public void showBookDetails() {
        System.out.println("Book Title: " + title + ", Author: " + author);
    }
}

class Library {
    private String libraryName;
    private List<Book> books;

    public Library(String libraryName) {
        this.libraryName = libraryName;
        this.books = new ArrayList<>();
    }

    public String getLibraryName() {
        return libraryName;
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void showLibraryBooks() {
        System.out.println("Library: " + libraryName);
        if (books.isEmpty()) {
            System.out.println("No books available.");
        } else {
            for (Book book : books) {
                book.showBookDetails();
            }
        }
    }
}

public class LibrarySystem {
    public static void main(String[] args) {
        // Create some books
        Book book1 = new Book("The Great Gatsby", "F. Scott Fitzgerald");
        Book book2 = new Book("To Kill a Mockingbird", "Harper Lee");
        Book book3 = new Book("1984", "George Orwell");
        Book book4 = new Book("Moby-Dick", "Herman Melville");

        // Create libraries
        Library library1 = new Library("Central Library");
        Library library2 = new Library("Community Library");

        // Add books to libraries
        library1.addBook(book1);
        library1.addBook(book2);
        library2.addBook(book3);
        library2.addBook(book4);

        // Show details of books in libraries
        System.out.println("\nLibrary 1 Books:");
        library1.showLibraryBooks();

        System.out.println("\nLibrary 2 Books:");
        library2.showLibraryBooks();

        // Books can exist independently
        System.out.println("\nIndependent Books:");
        book1.showBookDetails();
        book3.showBookDetails();
    }
}
