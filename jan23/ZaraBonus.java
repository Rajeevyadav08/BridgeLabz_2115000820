import java.util.Scanner;

public class ZaraBonus {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double[][] employeeData = new double[10][4];
        double totalBonus = 0;
        double totalOldSalary = 0;
        double totalNewSalary = 0;

        for (int i = 0; i < 10; i++) {
            System.out.println("\nEmployee " + (i + 1));

            do {
                System.out.print("Enter salary: ");
                employeeData[i][0] = scanner.nextDouble();
            } while (employeeData[i][0] <= 0); 

            do {
                System.out.print("Enter years of service: ");
                employeeData[i][1] = scanner.nextDouble();
            } while (employeeData[i][1] < 0); 

            totalOldSalary += employeeData[i][0]; 
        }

        for (int i = 0; i < 10; i++) {
            if (employeeData[i][1] > 5) {
                employeeData[i][2] = 0.05 * employeeData[i][0]; 
            } else {
                employeeData[i][2] = 0.02 * employeeData[i][0]; 
            }

            employeeData[i][3] = employeeData[i][0] + employeeData[i][2]; 

            totalBonus += employeeData[i][2];
            totalNewSalary += employeeData[i][3];
        }
        System.out.println("\nTotal Bonus Payout: " + totalBonus);
        System.out.println("Total Old Salary: " + totalOldSalary);
        System.out.println("Total New Salary: " + totalNewSalary);
        System.out.println("\nEmployee\tOld Salary\tYears of Service\tBonus\t\tNew Salary");
        for (int i = 0; i < 10; i++) {
            System.out.printf("%d\t\t%.2f\t\t%.2f\t\t\t%.2f\t\t%.2f\n", 
                    i + 1, employeeData[i][0], employeeData[i][1], employeeData[i][2], employeeData[i][3]);
        }
    }
}