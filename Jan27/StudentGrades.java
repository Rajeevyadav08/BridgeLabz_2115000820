package Jan27;

import java.util.Random;

public class StudentGrades {

    public static int[][] generateStudentScores(int numStudents) {
        Random rand = new Random();
        int[][] studentScores = new int[numStudents][3]; // 3 subjects: Physics, Chemistry, Math

        for (int i = 0; i < numStudents; i++) {
            studentScores[i][0] = rand.nextInt(101); // Physics
            studentScores[i][1] = rand.nextInt(101); // Chemistry
            studentScores[i][2] = rand.nextInt(101); // Math
        }

        return studentScores;
    }

    public static double[][] calculateResults(int[][] studentScores) {
        double[][] results = new double[studentScores.length][4]; // Total, Average, Percentage, Grade

        for (int i = 0; i < studentScores.length; i++) {
            int total = studentScores[i][0] + studentScores[i][1] + studentScores[i][2];
            double average = (double) total / 3;
            double percentage = (double) total / 300 * 100;

            results[i][0] = total;
            results[i][1] = Math.round(average * 100.0) / 100.0; // Round to 2 decimal places
            results[i][2] = Math.round(percentage * 100.0) / 100.0; // Round to 2 decimal places
            results[i][3] = determineGrade(percentage);
        }

        return results;
    }

    public static String determineGrade(double percentage) {
        if (percentage >= 80) {
            return "A (Level 4)";
        } else if (percentage >= 70) {
            return "B (Level 3)";
        } else if (percentage >= 60) {
            return "C (Level 2)";
        } else if (percentage >= 50) {
            return "D (Level 1)";
        } else if (percentage >= 40) {
            return "E (Level 1-)";
        } else {
            return "R (Remedial)";
        }
    }

    public static void displayScorecard(int[][] studentScores, double[][] results) {
        System.out.println("\nStudent\tPhysics\tChemistry\tMath\t\tTotal\tAverage\tPercentage\tGrade");
        for (int i = 0; i < studentScores.length; i++) {
            System.out.printf("%d\t\t%d\t\t%d\t\t%d\t\t%.2f\t\t%.2f\t\t%s\n",
                    i + 1, studentScores[i][0], studentScores[i][1], studentScores[i][2],
                    results[i][0], results[i][1], results[i][3]);
        }
    }

    public static void main(String[] args) {
        int numStudents = 5; // Number of students
        int[][] studentScores = generateStudentScores(numStudents);
        double[][] results = calculateResults(studentScores);
        displayScorecard(studentScores, results);
    }
}