public class DiscountCalculator {
    public static void main(String[] args) {
        double fee = 125000.0;
        double discountPercent = 10.0;
        double discount = (fee * discountPercent) / 100;
        double finalFee = fee - discount;
        System.out.printf("The discount amount is INR %.2f and final discounted fee is INR %.2f%n", discount, finalFee);
    }
}
