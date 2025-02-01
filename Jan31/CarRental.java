package Jan31;

public class CarRental {
    private String customerName;
    private String carModel;
    private int rentalDays;
    private double dailyRate;

    public CarRental(String customerName, String carModel, int rentalDays, double dailyRate) {
        this.customerName = customerName;
        this.carModel = carModel;
        this.rentalDays = rentalDays;
        this.dailyRate = dailyRate;
    }

    public double calculateTotalCost() {
        return rentalDays * dailyRate;
    }

    @Override
    public String toString() {
        return "Customer: " + customerName + ", Car Model: " + carModel + ", Rental Days: " + rentalDays + ", Total Cost: $" + calculateTotalCost();
    }

    public static void main(String[] args) {
        CarRental rental1 = new CarRental("John Doe", "Toyota Camry", 5, 40.0);
        System.out.println(rental1);
    }
}
