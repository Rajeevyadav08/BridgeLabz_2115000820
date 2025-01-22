import java.util.Scanner;

public class PurchasePriceCalculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the unit price of the item: ");
        double unitPrice = input.nextDouble();

        System.out.print("Enter the quantity to be bought: ");
        int quantity = input.nextInt();

        double totalPrice = unitPrice * quantity;

        System.out.printf("The total purchase price is INR %.2f if the quantity is %d and unit price is INR %.2f%n", totalPrice, quantity, unitPrice);

        input.close();
    }
}
