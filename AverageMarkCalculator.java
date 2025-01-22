public class AverageMarkCalculator {
    public static void main(String[] args) {

        int maths = 94;
        int physics = 95;
        int chemistry = 96;

        int totalMarks = maths + physics + chemistry;
        double averageMarks = totalMarks / 3.0;

        System.out.printf("Sam’s average mark in PCM is %.2f%n", averageMarks);
    }
}

