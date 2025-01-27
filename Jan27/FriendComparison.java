package Jan27;

import java.util.Scanner;

public class FriendComparison {

    public static String findYoungest(int[] ages) {
        int youngestIndex = 0;
        for (int i = 1; i < ages.length; i++) {
            if (ages[i] < ages[youngestIndex]) {
                youngestIndex = i;
            }
        }
        String[] names = {"Amar", "Akbar", "Anthony"};
        return names[youngestIndex];
    }

    public static String findTallest(double[] heights) {
        int tallestIndex = 0;
        for (int i = 1; i < heights.length; i++) {
            if (heights[i] > heights[tallestIndex]) {
                tallestIndex = i;
            }
        }
        String[] names = {"Amar", "Akbar", "Anthony"};
        return names[tallestIndex];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] ages = new int[3];
        double[] heights = new double[3];

        System.out.println("Enter ages of Amar, Akbar, and Anthony:");
        for (int i = 0; i < 3; i++) {
            ages[i] = scanner.nextInt();
        }

        System.out.println("Enter heights of Amar, Akbar, and Anthony:");
        for (int i = 0; i < 3; i++) {
            heights[i] = scanner.nextDouble();
        }

        String youngest = findYoungest(ages);
        String tallest = findTallest(heights);

        System.out.println("Youngest friend: " + youngest);
        System.out.println("Tallest friend: " + tallest);

        scanner.close();
    }
}
