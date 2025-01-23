import java.util.Scanner;
public class BMICalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your weight in kilograms: ");
        double weight = scanner.nextDouble();
        System.out.print("Enter your height in centimeters: ");
        double height = scanner.nextDouble();
        double heightMeters = height / 100;
        double bmi = weight / (heightMeters * heightMeters);
        String weightStatus;
        if (bmi < 18.5) {
            weightStatus = "Underweight";
        } else if (bmi >= 18.5 && bmi <= 24.9) {
            weightStatus = "Normal";
        } else if (bmi >= 25 && bmi <= 29.9) {
            weightStatus = "Overweight";
        } else {
            weightStatus = "Obese";
        }
        System.out.println("Your BMI is: " + bmi);
        System.out.println("Your weight status is: " + weightStatus);
        scanner.close();
    }
}