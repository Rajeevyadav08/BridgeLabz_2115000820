package Jan27;

import java.util.Random;

public class ZaraBonus {

    public static int[][] getEmployeeData(int numEmployees) {
        Random rand = new Random();
        int[][] employeeData = new int[numEmployees][2]; // [0] = salary, [1] = yearsOfService

        for (int i = 0; i < numEmployees; i++) {
            employeeData[i][0] = rand.nextInt(90000) + 10000; // 5-digit salary
            employeeData[i][1] = rand.nextInt(10) + 1; // Years of service (1 to 10 years)
        }

        return employeeData;
    }

    public static int[][] calculateNewSalaryAndBonus(int[][] employeeData) {
        int[][] updatedData = new int[employeeData.length][3]; // [0] = oldSalary, [1] = newSalary, [2] = bonus

        for (int i = 0; i < employeeData.length; i++) {
            updatedData[i][0] = employeeData[i][0]; // Old salary
            int yearsOfService = employeeData[i][1];
            int bonusPercentage = (yearsOfService > 5) ? 5 : 2;
            int bonusAmount = (employeeData[i][0] * bonusPercentage) / 100;
            updatedData[i][1] = employeeData[i][0] + bonusAmount; // New salary
            updatedData[i][2] = bonusAmount;
        }

        return updatedData;
    }

    public static void displayResults(int[][] updatedData) {
        int totalOldSalary = 0;
        int totalNewSalary = 0;
        int totalBonus = 0;

        System.out.println("Employee\tOld Salary\tNew Salary\tBonus");
        for (int i = 0; i < updatedData.length; i++) {
            System.out.printf("%d\t\t%d\t\t%d\t\t%d\n",
                    i + 1, updatedData[i][0], updatedData[i][1], updatedData[i][2]);
            totalOldSalary += updatedData[i][0];
            totalNewSalary += updatedData[i][1];
            totalBonus += updatedData[i][2];
        }

        System.out.println("\nTotal Old Salary: " + totalOldSalary);
        System.out.println("Total New Salary: " + totalNewSalary);
        System.out.println("Total Bonus: " + totalBonus);
    }

    public static void main(String[] args) {
        int numEmployees = 10;
        int[][] employeeData = getEmployeeData(numEmployees);
        int[][] updatedData = calculateNewSalaryAndBonus(employeeData);
        displayResults(updatedData);
    }
}