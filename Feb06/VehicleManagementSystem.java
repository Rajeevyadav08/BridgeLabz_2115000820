package Feb06;

// Superclass: Vehicle
class Vehicle {
    int maxSpeed;
    String model;

    Vehicle(int maxSpeed, String model) {
        this.maxSpeed = maxSpeed;
        this.model = model;
    }

    void displayInfo() {
        System.out.println("Model: " + model);
        System.out.println("Max Speed: " + maxSpeed + " km/h");
    }
}

// Interface: Refuelable
interface Refuelable {
    void refuel();
}

// Subclass: ElectricVehicle
class ElectricVehicle extends Vehicle {
    int batteryCapacity;

    ElectricVehicle(int maxSpeed, String model, int batteryCapacity) {
        super(maxSpeed, model);
        this.batteryCapacity = batteryCapacity;
    }

    void charge() {
        System.out.println(model + " is charging. Battery capacity: " + batteryCapacity + " kWh");
    }
}

// Subclass: PetrolVehicle (implements Refuelable)
class PetrolVehicle extends Vehicle implements Refuelable {
    int fuelTankCapacity;

    PetrolVehicle(int maxSpeed, String model, int fuelTankCapacity) {
        super(maxSpeed, model);
        this.fuelTankCapacity = fuelTankCapacity;
    }

    @Override
    public void refuel() {
        System.out.println(model + " is refueling. Fuel tank capacity: " + fuelTankCapacity + " liters");
    }
}

// Main Class
public class VehicleManagementSystem {
    public static void main(String[] args) {
        ElectricVehicle tesla = new ElectricVehicle(250, "Tesla Model 3", 75);
        PetrolVehicle ford = new PetrolVehicle(200, "Ford Mustang", 60);

        // Display information and specific behaviors
        System.out.println("---- Electric Vehicle ----");
        tesla.displayInfo();
        tesla.charge();

        System.out.println("\n---- Petrol Vehicle ----");
        ford.displayInfo();
        ford.refuel();
    }
}

