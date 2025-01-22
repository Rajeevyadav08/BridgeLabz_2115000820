import java.util.Scanner;

public class HeightConverter {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your height in centimeters: ");
        double heightCm = scanner.nextDouble();
        double cmPerInch = 2.54;
        double inchesPerFoot = 12.0;
        double heightInches = heightCm / cmPerInch;
        int feet = (int) (heightInches / inchesPerFoot);
        double remainingInches = heightInches % inchesPerFoot;

        System.out.println("Your Height in cm is " + heightCm + 
                           " while in feet is " + feet + 
                           " and inches is " + remainingInches);

        scanner.close();
    }
}

