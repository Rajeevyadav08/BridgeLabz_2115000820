package Jan27;

import java.util.Random;

public class FootballTeamHeights {

    public static int findSumOfHeights(int[] heights) {
        int sum = 0;
        for (int height : heights) {
            sum += height;
        }
        return sum;
    }

    public static double findMeanHeight(int[] heights) {
        int sum = findSumOfHeights(heights);
        return (double) sum / heights.length;
    }

    public static int findShortestHeight(int[] heights) {
        int shortest = heights[0];
        for (int i = 1; i < heights.length; i++) {
            if (heights[i] < shortest) {
                shortest = heights[i];
            }
        }
        return shortest;
    }

    public static int findTallestHeight(int[] heights) {
        int tallest = heights[0];
        for (int i = 1; i < heights.length; i++) {
            if (heights[i] > tallest) {
                tallest = heights[i];
            }
        }
        return tallest;
    }

    public static void main(String[] args) {
        Random random = new Random();
        int[] heights = new int[11];

        // Generate random heights for 11 players
        for (int i = 0; i < 11; i++) {
            heights[i] = random.nextInt(101) + 150; // Random height between 150cm and 250cm
        }

        int shortestHeight = findShortestHeight(heights);
        int tallestHeight = findTallestHeight(heights);
        double meanHeight = findMeanHeight(heights);

        System.out.println("Shortest height: " + shortestHeight + " cm");
        System.out.println("Tallest height: " + tallestHeight + " cm");
        System.out.println("Mean height: " + meanHeight + " cm");
    }
}
