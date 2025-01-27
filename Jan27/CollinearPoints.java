package Jan27;

import java.util.Scanner;

public class CollinearPoints {

    public static boolean areCollinearUsingSlope(double x1, double y1, double x2, double y2, double x3, double y3) {
        // Handle cases where denominator is zero (vertical lines)
        if (x1 == x2) {
            return x3 == x1; // All points must have the same x-coordinate
        }
        if (x2 == x3) {
            return x1 == x2; // All points must have the same x-coordinate
        }

        double slopeAB = (y2 - y1) / (x2 - x1);
        double slopeBC = (y3 - y2) / (x3 - x2);
        double slopeAC = (y3 - y1) / (x3 - x1);

        return Math.abs(slopeAB - slopeBC) < 1e-9 && Math.abs(slopeBC - slopeAC) < 1e-9; 
        // Use a small tolerance to account for potential floating-point errors
    }

    public static boolean areCollinearUsingArea(double x1, double y1, double x2, double y2, double x3, double y3) {
        // Area of triangle using determinant formula
        double area = 0.5 * Math.abs(x1 * (y2 - y3) + x2 * (y3 - y1) + x3 * (y1 - y2));
        return area <= 1e-9; // Allow for small numerical errors
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter x1: ");
        double x1 = scanner.nextDouble();
        System.out.print("Enter y1: ");
        double y1 = scanner.nextDouble();
        System.out.print("Enter x2: ");
        double x2 = scanner.nextDouble();
        System.out.print("Enter y2: ");
        double y2 = scanner.nextDouble();
        System.out.print("Enter x3: ");
        double x3 = scanner.nextDouble();
        System.out.print("Enter y3: ");
        double y3 = scanner.nextDouble();

        if (areCollinearUsingSlope(x1, y1, x2, y2, x3, y3)) {
            System.out.println("Points are collinear using slope formula.");
        } else {
            System.out.println("Points are not collinear using slope formula.");
        }

        if (areCollinearUsingArea(x1, y1, x2, y2, x3, y3)) {
            System.out.println("Points are collinear using area formula.");
        } else {
            System.out.println("Points are not collinear using area formula.");
        }

        scanner.close();
    }
}