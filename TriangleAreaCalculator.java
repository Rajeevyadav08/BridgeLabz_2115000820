import java.util.Scanner;

public class TriangleAreaCalculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the base of the triangle (in inches): ");
        double baseInInches = input.nextDouble();

        System.out.print("Enter the height of the triangle (in inches): ");
        double heightInInches = input.nextDouble();
        double areaInInches = 0.5 * baseInInches * heightInInches;
        double areaInCm2 = areaInInches * 6.4516;
        System.out.printf("The area of the triangle in square inches is %.2f and in square centimeters is %.2f%n",
                areaInInches, areaInCm2);
        input.close();
    }
}
