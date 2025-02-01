package Jan31;

public class Book3 {
    public String ISBN;
    protected String title;
    private String author;

    public Book3(String ISBN, String title, String author) {
        this.ISBN = ISBN;
        this.title = title;
        this.author = author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    @Override
    public String toString() {
        return "ISBN: " + ISBN + ", Title: " + title + ", Author: " + author;
    }
}

class EBook extends Book {
    public EBook(String ISBN, String title, String author) {
        super(ISBN, title, author);
    }

    public void displayBookInfo() {
        System.out.println("EBook ISBN: " + ISBN + ", Title: " + title);
    }

    public static void main(String[] args) {
        EBook ebook1 = new EBook("123-456-789", "Java Programming", "John Doe");
        ebook1.displayBookInfo();
        System.out.println(ebook1);
        ebook1.setAuthor("Jane Doe");
        System.out.println("Updated " + ebook1);
    }
}