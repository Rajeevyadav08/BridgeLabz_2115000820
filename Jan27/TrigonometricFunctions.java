package Jan27;

import java.util.Scanner;

public class TrigonometricFunctions {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the angle in degrees: ");
        double angleInDegrees = scanner.nextDouble();

        double[] results = calculateTrigonometricFunctions(angleInDegrees);

        System.out.println("Sine: " + results[0]);
        System.out.println("Cosine: " + results[1]);
        System.out.println("Tangent: " + results[2]);

        scanner.close();
    }

    public static double[] calculateTrigonometricFunctions(double angleInDegrees) {
        double angleInRadians = Math.toRadians(angleInDegrees);
        double sine = Math.sin(angleInRadians);
        double cosine = Math.cos(angleInRadians);
        double tangent = Math.tan(angleInRadians);
        double[] results = {sine, cosine, tangent};

        return results;
    }
}