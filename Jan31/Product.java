package Jan31;

public class Product {
    private String productName;
    private double price;
    private static int totalProducts = 0; // Class variable to track total products

    // Constructor
    public Product(String productName, double price) {
        this.productName = productName;
        this.price = price;
        totalProducts++; // Increment the total product count whenever a new product is created
    }

    // Instance method to display product details
    public void displayProductDetails() {
        System.out.println("Product Name: " + productName);
        System.out.println("Price: " + price);
    }

    // Class method to display total number of products
    public static void displayTotalProducts() {
        System.out.println("Total Products: " + totalProducts);
    }

    // Main method for testing
    public static void main(String[] args) {
        Product product1 = new Product("Laptop", 1000);
        Product product2 = new Product("Smartphone", 500);

        product1.displayProductDetails();
        product2.displayProductDetails();
        Product.displayTotalProducts();
    }
}
