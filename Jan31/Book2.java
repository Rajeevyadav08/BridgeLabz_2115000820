package Jan31;

public class Book2 {
    private String title;
    private String author;
    private double price;
    private boolean available;

    public Book2(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.available = true;
    }

    public String borrowBook() {
        if (available) {
            available = false;
            return "You have successfully borrowed \"" + title + "\"";
        }
        return "Sorry, \"" + title + "\" is currently not available";
    }

    public String returnBook() {
        available = true;
        return "You have successfully returned \"" + title + "\"";
    }

    @Override
    public String toString() {
        String status = available ? "Available" : "Not Available";
        return "Title: " + title + ", Author: " + author + ", Price: $" + price + ", Status: " + status;
    }

    public static void main(String[] args) {
        Book2 book1 = new Book2("The Great Gatsby", "F. Scott Fitzgerald", 10.99);
        System.out.println(book1);
        System.out.println(book1.borrowBook());
        System.out.println(book1);
        System.out.println(book1.returnBook());
        System.out.println(book1);
    }
}
