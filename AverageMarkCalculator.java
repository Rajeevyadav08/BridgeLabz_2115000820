public class AverageMarkCalculator {
    public static void main(String[] args) {
        // Sam's marks in subjects
        int maths = 94;
        int physics = 95;
        int chemistry = 96;

        // Calculate total and average
        int totalMarks = maths + physics + chemistry;
        double averageMarks = totalMarks / 3.0;

        // Output the result
        System.out.printf("Sam’s average mark in PCM is %.2f%n", averageMarks);
    }
}

