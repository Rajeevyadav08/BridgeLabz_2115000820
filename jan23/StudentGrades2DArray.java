import java.util.Scanner;
public class StudentGrades2DArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of students: ");
        int numStudents = scanner.nextInt();

        int[][] marks = new int[numStudents][3]; 
        double[] percentages = new double[numStudents];
        char[] grades = new char[numStudents];

        for (int i = 0; i < numStudents; i++) {
            System.out.println("\nStudent " + (i + 1));

            do {
                System.out.print("Enter Physics marks: ");
                marks[i][0] = scanner.nextInt();
            } while (marks[i][0] < 0);

            do {
                System.out.print("Enter Chemistry marks: ");
                marks[i][1] = scanner.nextInt();
            } while (marks[i][1] < 0);

            do {
                System.out.print("Enter Maths marks: ");
                marks[i][2] = scanner.nextInt();
            } while (marks[i][2] < 0);
            percentages[i] = (marks[i][0] + marks[i][1] + marks[i][2]) / 3.0;
            if (percentages[i] >= 80) {
                grades[i] = 'A';
            } else if (percentages[i] >= 70) {
                grades[i] = 'B';
            } else if (percentages[i] >= 60) {
                grades[i] = 'C';
            } else if (percentages[i] >= 50) {
                grades[i] = 'D';
            } else if (percentages[i] >= 40) {
                grades[i] = 'E';
            } else {
                grades[i] = 'R';
            }
        }
        System.out.println("\nStudent\tPhysics\tChemistry\tMaths\tPercentage\tGrade");
        for (int i = 0; i < numStudents; i++) {
            System.out.println((i + 1) + "\t" + marks[i][0] + "\t" + marks[i][1] + "\t" + marks[i][2] + "\t" + 
                               String.format("%.2f", percentages[i]) + "%\t\t" + grades[i]);
        }
    }
}