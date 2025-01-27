package Jan27;

import java.util.Scanner;

public class TriangleRun {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the first side of the triangle (in meters): ");
        double side1 = scanner.nextDouble();

        System.out.print("Enter the second side of the triangle (in meters): ");
        double side2 = scanner.nextDouble();

        System.out.print("Enter the third side of the triangle (in meters): ");
        double side3 = scanner.nextDouble();

        double targetDistance = 5000; 

        double perimeter = calculatePerimeter(side1, side2, side3);
        double rounds = targetDistance / perimeter;

        System.out.println("Number of rounds to complete 5km: " + rounds);

        scanner.close();
    }

    public static double calculatePerimeter(double side1, double side2, double side3) {
        return side1 + side2 + side3;
    }
}
