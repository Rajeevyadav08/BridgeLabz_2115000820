package Feb03;

import java.util.Scanner;
public class Vehicle {
    private static double registrationFee = 5000.0; 
    private final String registrationNumber;
    private String ownerName;
    private String vehicleType;
    public Vehicle(String ownerName, String vehicleType, String registrationNumber) {
        this.ownerName = ownerName;
        this.vehicleType = vehicleType;
        this.registrationNumber = registrationNumber;
    }
    public static void updateRegistrationFee(double newFee) {
        registrationFee = newFee;
    }
    public void displayVehicleDetails() {
        if (this instanceof Vehicle) {
            System.out.println("\nOwner Name: " + ownerName);
            System.out.println("Vehicle Type: " + vehicleType);
            System.out.println("Registration Number: " + registrationNumber);
            System.out.println("Registration Fee: $" + registrationFee);
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter new registration fee: ");
        double newFee = scanner.nextDouble();
        updateRegistrationFee(newFee);
        System.out.print("Enter the number of vehicles to register: ");
        int n = scanner.nextInt();
        scanner.nextLine();
        Vehicle[] vehicles = new Vehicle[n];
        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter details for Vehicle " + (i + 1) + ":");
            System.out.print("Enter Owner Name: ");
            String ownerName = scanner.nextLine();
            System.out.print("Enter Vehicle Type: ");
            String vehicleType = scanner.nextLine();
            System.out.print("Enter Registration Number: ");
            String registrationNumber = scanner.nextLine();
            vehicles[i] = new Vehicle(ownerName, vehicleType, registrationNumber);
        }
        System.out.println("\n--- Registered Vehicles ---");
        for (Vehicle vehicle : vehicles) {
            vehicle.displayVehicleDetails();
        }
        scanner.close();
    }
}

