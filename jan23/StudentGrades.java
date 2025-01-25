import java.util.Scanner;

public class StudentGrades {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of students: ");
        int numStudents = scanner.nextInt();

        int[] physicsMarks = new int[numStudents];
        int[] chemistryMarks = new int[numStudents];
        int[] mathMarks = new int[numStudents];
        double[] percentages = new double[numStudents];
        char[] grades = new char[numStudents];

        for (int i = 0; i < numStudents; i++) {
            System.out.println("\nStudent " + (i + 1));

            do {
                System.out.print("Enter Physics marks: ");
                physicsMarks[i] = scanner.nextInt();
            } while (physicsMarks[i] < 0);

            do {
                System.out.print("Enter Chemistry marks: ");
                chemistryMarks[i] = scanner.nextInt();
            } while (chemistryMarks[i] < 0);

            do {
                System.out.print("Enter Maths marks: ");
                mathMarks[i] = scanner.nextInt();
            } while (mathMarks[i] < 0);
            percentages[i] = (physicsMarks[i] + chemistryMarks[i] + mathMarks[i]) / 3.0;
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
            System.out.println((i + 1) + "\t" + physicsMarks[i] + "\t" + chemistryMarks[i] + "\t" + mathMarks[i] + "\t" + 
                               String.format("%.2f", percentages[i]) + "%\t\t" + grades[i]);
        }
    }
}