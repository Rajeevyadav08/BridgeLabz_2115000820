package Feb03;

import java.util.Scanner;
public class Product {
    private static double discount = 10.0; 
    private final int productID;
    private String productName;
    private double price;
    private int quantity;
    public Product(int productID, String productName, double price, int quantity) {
        this.productID = productID;
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
    }
    public static void updateDiscount(double newDiscount) {
        discount = newDiscount;
    }
    public void displayProductDetails() {
        if (this instanceof Product) {
            System.out.println("\nProduct ID: " + productID);
            System.out.println("Product Name: " + productName);
            System.out.println("Price: $" + price);
            System.out.println("Quantity: " + quantity);
            double finalPrice = price - (price * discount / 100);
            System.out.println("Price After " + discount + "% Discount: $" + finalPrice);
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter discount percentage: ");
        double newDiscount = scanner.nextDouble();
        updateDiscount(newDiscount);
        System.out.print("Enter the number of products to add: ");
        int n = scanner.nextInt();
        scanner.nextLine();
        Product[] products = new Product[n];
        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter details for Product " + (i + 1) + ":");
            System.out.print("Enter Product ID: ");
            int productID = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Enter Product Name: ");
            String productName = scanner.nextLine();
            System.out.print("Enter Price: ");
            double price = scanner.nextDouble();
            System.out.print("Enter Quantity: ");
            int quantity = scanner.nextInt();
            scanner.nextLine();
            products[i] = new Product(productID, productName, price, quantity);
        }
        System.out.println("\n--- Shopping Cart Items ---");
        for (Product product : products) {
            product.displayProductDetails();
        }
        scanner.close();
    }
}
