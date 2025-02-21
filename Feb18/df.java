package Feb18;

import java.util.*;

class ShoppingCart {
    private Map<String, Double> productPrices = new HashMap<>();
    private Map<String, Double> cartOrder = new LinkedHashMap<>();
    private TreeMap<Double, String> sortedByPrice = new TreeMap<>();

    public void addProduct(String product, double price) {
        productPrices.put(product, price);
        cartOrder.put(product, price);
        sortedByPrice.put(price, product);
    }

    public void displayCart() {
        System.out.println("Cart in Order of Addition: " + cartOrder);
        System.out.println("Cart Sorted by Price: " + sortedByPrice);
    }

    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();
        cart.addProduct("Laptop", 800);
        cart.addProduct("Phone", 500);
        cart.addProduct("Headphones", 100);
        cart.addProduct("Keyboard", 50);

        cart.displayCart();
    }
}
