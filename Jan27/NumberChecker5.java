package Jan27;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NumberChecker5 {

    public static int[] findFactors(int number) {
        List<Integer> factorsList = new ArrayList<>();
        for (int i = 1; i <= number / 2; i++) {
            if (number % i == 0) {
                factorsList.add(i);
            }
        }
        int[] factors = new int[factorsList.size()];
        for (int i = 0; i < factorsList.size(); i++) {
            factors[i] = factorsList.get(i);
        }
        return factors;
    }

    public static int findGreatestFactor(int number) {
        int[] factors = findFactors(number);
        int greatestFactor = factors[factors.length - 1];
        return greatestFactor;
    }

    public static int sumOfFactors(int number) {
        int[] factors = findFactors(number);
        int sum = 0;
        for (int factor : factors) {
            sum += factor;
        }
        return sum;
    }

    public static int productOfFactors(int number) {
        int[] factors = findFactors(number);
        int product = 1;
        for (int factor : factors) {
            product *= factor;
        }
        return product;
    }

    public static int productOfCubesOfFactors(int number) {
        int[] factors = findFactors(number);
        int product = 1;
        for (int factor : factors) {
            product *= Math.pow(factor, 3);
        }
        return product;
    }

    public static boolean isPerfectNumber(int number) {
        return sumOfFactors(number) == number;
    }

    public static boolean isAbundantNumber(int number) {
        return sumOfFactors(number) > number;
    }

    public static boolean isDeficientNumber(int number) {
        return sumOfFactors(number) < number;
    }

    public static boolean isStrongNumber(int number) {
        int temp = number;
        int sum = 0;
        while (temp > 0) {
            int digit = temp % 10;
            int factorial = 1;
            for (int i = 1; i <= digit; i++) {
                factorial *= i;
            }
            sum += factorial;
            temp /= 10;
        }
        return sum == number;
    }

    public static void main(String[] args) {
        int number = 6; // Example number

        System.out.println("Factors: " + Arrays.toString(findFactors(number)));
        System.out.println("Greatest Factor: " + findGreatestFactor(number));
        System.out.println("Sum of Factors: " + sumOfFactors(number));
        System.out.println("Product of Factors: " + productOfFactors(number));
        System.out.println("Product of Cubes of Factors: " + productOfCubesOfFactors(number));

        System.out.println("Is Perfect: " + isPerfectNumber(number));
        System.out.println("Is Abundant: " + isAbundantNumber(number));
        System.out.println("Is Deficient: " + isDeficientNumber(number));
        System.out.println("Is Strong: " + isStrongNumber(number));
    }
}