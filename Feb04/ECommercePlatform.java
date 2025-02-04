package Feb04;

import java.util.ArrayList;
import java.util.List;

class Product {
    private String productName;
    private double price;

    public Product(String productName, double price) {
        this.productName = productName;
        this.price = price;
    }

    public String getProductName() {
        return productName;
    }

    public double getPrice() {
        return price;
    }
}

class Order {
    private int orderId;
    private Customer customer;
    private List<Product> products;
    private double totalAmount;

    public Order(int orderId, Customer customer) {
        this.orderId = orderId;
        this.customer = customer;
        this.products = new ArrayList<>();
        this.totalAmount = 0;
    }

    public void addProduct(Product product) {
        products.add(product);
        totalAmount += product.getPrice();
        System.out.println("Product " + product.getProductName() + " added to Order " + orderId);
    }

    public void showOrderDetails() {
        System.out.println("Order ID: " + orderId);
        System.out.println("Customer: " + customer.getName());
        System.out.println("Products in the Order:");
        for (Product product : products) {
            System.out.println("- " + product.getProductName() + " ($" + product.getPrice() + ")");
        }
        System.out.println("Total Amount: $" + totalAmount);
    }
}

class Customer {
    private String name;
    private List<Order> orders;

    public Customer(String name) {
        this.name = name;
        this.orders = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void placeOrder(Order order) {
        orders.add(order);
        System.out.println("Order " + order + " placed by " + name);
    }

    public void showCustomerOrders() {
        System.out.println("Customer: " + name);
        if (orders.isEmpty()) {
            System.out.println("No orders placed.");
            return;
        }
        for (Order order : orders) {
            order.showOrderDetails();
            System.out.println();
        }
    }
}

public class ECommercePlatform {
    public static void main(String[] args) {
        Product product1 = new Product("Laptop", 1000);
        Product product2 = new Product("Smartphone", 800);
        Product product3 = new Product("Headphones", 150);

        Customer customer1 = new Customer("Alice");
        Customer customer2 = new Customer("Bob");

        Order order1 = new Order(101, customer1);
        order1.addProduct(product1);
        order1.addProduct(product2);

        Order order2 = new Order(102, customer2);
        order2.addProduct(product3);

        customer1.placeOrder(order1);
        customer2.placeOrder(order2);

        System.out.println("\nCustomer Orders:");
        customer1.showCustomerOrders();
        customer2.showCustomerOrders();
    }
}

