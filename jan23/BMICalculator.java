import java.util.Scanner;
public class BMICalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of persons: ");
        int numPersons = scanner.nextInt();
        double[][] personData = new double[numPersons][3]; 
        String[] weightStatus = new String[numPersons];

        for (int i = 0; i < numPersons; i++) {
            System.out.println("\nPerson " + (i + 1));

            do {
                System.out.print("Enter weight (kg): ");
                personData[i][0] = scanner.nextDouble();
            } while (personData[i][0] <= 0);

            do {
                System.out.print("Enter height (m): ");
                personData[i][1] = scanner.nextDouble();
            } while (personData[i][1] <= 0);
            personData[i][2] = calculateBMI(personData[i][0], personData[i][1]);
            weightStatus[i] = determineWeightStatus(personData[i][2]);
        }
        System.out.println("\nPerson\tHeight (m)\tWeight (kg)\tBMI\t\tWeight Status");
        for (int i = 0; i < numPersons; i++) {
            System.out.printf("%d\t\t%.2f\t\t%.2f\t\t%.2f\t\t%s\n", 
                    i + 1, personData[i][1], personData[i][0], personData[i][2], weightStatus[i]);
        }
    }
    public static double calculateBMI(double weight, double height) {
        return weight / (height * height);
    }
    public static String determineWeightStatus(double bmi) {
        if (bmi < 18.5) {
            return "Underweight";
        } else if (bmi < 25) {
            return "Normal";
        } else if (bmi < 30) {
            return "Overweight";
        } else {
            return "Obese";
        }
    }
}