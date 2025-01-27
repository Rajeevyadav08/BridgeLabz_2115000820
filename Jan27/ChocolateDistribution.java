package Jan27;

import java.util.Scanner;

public class ChocolateDistribution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of chocolates: ");
        int numberOfChocolates = scanner.nextInt();

        System.out.print("Enter the number of children: ");
        int numberOfChildren = scanner.nextInt();

        int[] result = findChocolatesPerChildAndRemainder(numberOfChocolates, numberOfChildren);

        System.out.println("Number of chocolates each child gets: " + result[0]);
        System.out.println("Number of remaining chocolates: " + result[1]);

        scanner.close();
    }
    public static int[] findChocolatesPerChildAndRemainder(int numberOfChocolates, int numberOfChildren) {
        int chocolatesPerChild = numberOfChocolates / numberOfChildren;
        int remainingChocolates = numberOfChocolates % numberOfChildren;

        int[] result = {chocolatesPerChild, remainingChocolates};
        return result;
    }
}