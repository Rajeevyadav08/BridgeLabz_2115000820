package Feb10;

import java.util.Scanner;

class Book {
    String title;
    String author;
    String genre;
    int bookId;
    boolean isAvailable;
    Book next;
    Book prev;

    Book(String title, String author, String genre, int bookId, boolean isAvailable) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.bookId = bookId;
        this.isAvailable = isAvailable;
        this.next = null;
        this.prev = null;
    }
}

class LibraryManagementSystem {
    private Book head = null;
    private Book tail = null;

    public void addAtBeginning(String title, String author, String genre, int bookId, boolean isAvailable) {
        Book newBook = new Book(title, author, genre, bookId, isAvailable);
        if (head == null) {
            head = tail = newBook;
        } else {
            newBook.next = head;
            head.prev = newBook;
            head = newBook;
        }
    }

    public void addAtEnd(String title, String author, String genre, int bookId, boolean isAvailable) {
        Book newBook = new Book(title, author, genre, bookId, isAvailable);
        if (head == null) {
            head = tail = newBook;
        } else {
            tail.next = newBook;
            newBook.prev = tail;
            tail = newBook;
        }
    }

    public void addAtPosition(String title, String author, String genre, int bookId, boolean isAvailable, int position) {
        if (position <= 1) {
            addAtBeginning(title, author, genre, bookId, isAvailable);
            return;
        }
        Book newBook = new Book(title, author, genre, bookId, isAvailable);
        Book temp = head;
        int count = 1;
        while (count < position - 1 && temp.next != null) {
            temp = temp.next;
            count++;
        }
        newBook.next = temp.next;
        if (temp.next != null) {
            temp.next.prev = newBook;
        } else {
            tail = newBook;
        }
        temp.next = newBook;
        newBook.prev = temp;
    }

    public void removeById(int bookId) {
        if (head == null) {
            System.out.println("Library is empty.");
            return;
        }
        if (head.bookId == bookId) {
            if (head == tail) {
                head = tail = null;
            } else {
                head = head.next;
                head.prev = null;
            }
            System.out.println("Book with ID " + bookId + " removed.");
            return;
        }
        Book temp = head;
        while (temp != null && temp.bookId != bookId) {
            temp = temp.next;
        }
        if (temp == null) {
            System.out.println("Book with ID " + bookId + " not found.");
        } else {
            if (temp == tail) {
                tail = tail.prev;
                tail.next = null;
            } else {
                temp.prev.next = temp.next;
                temp.next.prev = temp.prev;
            }
            System.out.println("Book with ID " + bookId + " removed.");
        }
    }

    public void searchByTitle(String title) {
        Book temp = head;
        boolean found = false;
        while (temp != null) {
            if (temp.title.equalsIgnoreCase(title)) {
                System.out.println("Book Found: " + temp.title + " by " + temp.author + " (Genre: " + temp.genre + ", ID: " + temp.bookId + ", Available: " + temp.isAvailable + ")");
                found = true;
            }
            temp = temp.next;
        }
        if (!found) {
            System.out.println("No book found with title: " + title);
        }
    }

    public void searchByAuthor(String author) {
        Book temp = head;
        boolean found = false;
        while (temp != null) {
            if (temp.author.equalsIgnoreCase(author)) {
                System.out.println("Book Found: " + temp.title + " by " + temp.author + " (Genre: " + temp.genre + ", ID: " + temp.bookId + ", Available: " + temp.isAvailable + ")");
                found = true;
            }
            temp = temp.next;
        }
        if (!found) {
            System.out.println("No book found by author: " + author);
        }
    }

    public void updateAvailability(int bookId, boolean newStatus) {
        Book temp = head;
        while (temp != null) {
            if (temp.bookId == bookId) {
                temp.isAvailable = newStatus;
                System.out.println("Availability updated for Book ID " + bookId);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Book with ID " + bookId + " not found.");
    }

    public void displayBooks() {
        if (head == null) {
            System.out.println("Library is empty.");
            return;
        }
        Book temp = head;
        while (temp != null) {
            System.out.println(temp.title + " by " + temp.author + " (Genre: " + temp.genre + ", ID: " + temp.bookId + ", Available: " + temp.isAvailable + ")");
            temp = temp.next;
        }
    }

    public void displayBooksInReverse() {
        if (tail == null) {
            System.out.println("Library is empty.");
            return;
        }
        Book temp = tail;
        while (temp != null) {
            System.out.println(temp.title + " by " + temp.author + " (Genre: " + temp.genre + ", ID: " + temp.bookId + ", Available: " + temp.isAvailable + ")");
            temp = temp.prev;
        }
    }

    public void countTotalBooks() {
        int count = 0;
        Book temp = head;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        System.out.println("Total number of books in the library: " + count);
    }
}

public class LibraryManagementApp {
    public static void main(String[] args) {
        LibraryManagementSystem library = new LibraryManagementSystem();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\nLibrary Management System Menu");
            System.out.println("1. Add Book at Beginning");
            System.out.println("2. Add Book at End");
            System.out.println("3. Add Book at Specific Position");
            System.out.println("4. Remove Book by ID");
            System.out.println("5. Search Book by Title");
            System.out.println("6. Search Book by Author");
            System.out.println("7. Update Availability Status");
            System.out.println("8. Display All Books");
            System.out.println("9. Display All Books in Reverse");
            System.out.println("10. Count Total Books");
            System.out.println("11. Exit");
            System.out.print("Choose an option: ");
            int choice = sc.nextInt();
            sc.nextLine();

            if (choice == 1) {
                System.out.print("Enter Book Title: ");
                String title = sc.nextLine();
                System.out.print("Enter Author: ");
                String author = sc.nextLine();
                System.out.print("Enter Genre: ");
                String genre = sc.nextLine();
                System.out.print("Enter Book ID: ");
                int bookId = sc.nextInt();
                System.out.print("Is Available (true/false): ");
                boolean isAvailable = sc.nextBoolean();
                library.addAtBeginning(title, author, genre, bookId, isAvailable);
            } else if (choice == 2) {
                System.out.print("Enter Book Title: ");
                String title = sc.nextLine();
                System.out.print("Enter Author: ");
                String author = sc.nextLine();
                System.out.print("Enter Genre: ");
                String genre = sc.nextLine();
                System.out.print("Enter Book ID: ");
                int bookId = sc.nextInt();
                System.out.print("Is Available (true/false): ");
                boolean isAvailable = sc.nextBoolean();
                library.addAtEnd(title, author, genre, bookId, isAvailable);
            } else if (choice == 3) {
                System.out.print("Enter Book Title: ");
                String title = sc.nextLine();
                System.out.print("Enter Author: ");
                String author = sc.nextLine();
                System.out.print("Enter Genre: ");
                String genre = sc.nextLine();
                System.out.print("Enter Book ID: ");
                int bookId = sc.nextInt();
                System.out.print("Is Available (true/false): ");
                boolean isAvailable = sc.nextBoolean();
                System.out.print("Enter Position: ");
                int position = sc.nextInt();
                library.addAtPosition(title, author, genre, bookId, isAvailable, position);
            } else if (choice == 4) {
                System.out.print("Enter Book ID to Remove: ");
                int bookId = sc.nextInt();
                library.removeById(bookId);
            } else if (choice == 5) {
                System.out.print("Enter Book Title to Search: ");
                String title = sc.nextLine();
                library.searchByTitle(title);
            } else if (choice == 6) {
                System.out.print("Enter Author to Search: ");
                String author = sc.nextLine();
                library.searchByAuthor(author);
            } else if (choice == 7) {
                System.out.print("Enter Book ID to Update Availability: ");
                int bookId = sc.nextInt();
                System.out.print("Enter New Availability (true/false): ");
                boolean newStatus = sc.nextBoolean();
                library.updateAvailability(bookId, newStatus);
            } else if (choice == 8) {
                library.displayBooks();
            } else if (choice == 9) {
                library.displayBooksInReverse();
            } else if (choice == 10) {
                library.countTotalBooks();
            } else if (choice == 11) {
                System.out.println("Exiting...");
                sc.close();
                break;
            } else {
                System.out.println("Invalid choice. Try again.");
            }
        }
    }
}

