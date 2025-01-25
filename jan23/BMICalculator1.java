import java.util.Scanner;

public class BMICalculator1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of persons: ");
        int numPersons = scanner.nextInt();

        double[] weights = new double[numPersons];
        double[] heights = new double[numPersons];
        double[] bmis = new double[numPersons];
        String[] weightStatus = new String[numPersons];

        for (int i = 0; i < numPersons; i++) {
            System.out.println("\nPerson " + (i + 1));
            do {
                System.out.print("Enter weight (kg): ");
                weights[i] = scanner.nextDouble();
            } while (weights[i] <= 0);

            do {
                System.out.print("Enter height (m): ");
                heights[i] = scanner.nextDouble();
            } while (heights[i] <= 0);
            bmis[i] = calculateBMI(weights[i], heights[i]);
            weightStatus[i] = determineWeightStatus(bmis[i]);
        }
        System.out.println("\nPerson\tHeight (m)\tWeight (kg)\tBMI\t\tWeight Status");
        for (int i = 0; i < numPersons; i++) {
            System.out.printf("%d\t\t%.2f\t\t%.2f\t\t%.2f\t\t%s\n", 
                    i + 1, heights[i], weights[i], bmis[i], weightStatus[i]);
        }
    }

    public static double calculateBMI(double weight, double height) {
        return weight / (height * height);
    }

    public static String determineWeightStatus(double bmi) {
        if (bmi <= 18.4) {
            return "Underweight";
        } else if (bmi <= 24.9) {
            return "Normal";
        } else if (bmi <= 39.9) {
            return "Overweight";
        } else {
            return "Obese";
        }
    }
}