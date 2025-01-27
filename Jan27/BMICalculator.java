package Jan27;

import java.util.Scanner;

public class BMICalculator {

    public static double calculateBMI(double weight, double height) {
        // Convert height from cm to meters
        height = height / 100;
        return weight / (height * height);
    }

    public static String determineBMIStatus(double bmi) {
        if (bmi <= 18.4) {
            return "Underweight";
        } else if (bmi >= 18.5 && bmi <= 24.9) {
            return "Normal";
        } else if (bmi >= 25.0 && bmi <= 39.9) {
            return "Overweight";
        } else {
            return "Obese";
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double[][] data = new double[10][3]; // 10 rows (members), 3 columns (weight, height, BMI)

        for (int i = 0; i < 10; i++) {
            System.out.println("Enter weight (kg) for member " + (i + 1) + ":");
            data[i][0] = scanner.nextDouble();

            System.out.println("Enter height (cm) for member " + (i + 1) + ":");
            data[i][1] = scanner.nextDouble();

            data[i][2] = calculateBMI(data[i][0], data[i][1]);
        }

        System.out.println("\nMember\tWeight (kg)\tHeight (cm)\tBMI\t\tStatus");
        for (int i = 0; i < 10; i++) {
            String status = determineBMIStatus(data[i][2]);
            System.out.printf("%d\t\t%.2f\t\t%.2f\t\t%.2f\t\t%s\n",
                    i + 1, data[i][0], data[i][1], data[i][2], status);
        }

        scanner.close();
    }
}
