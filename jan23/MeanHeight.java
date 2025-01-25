import java.util.Scanner;
public class MeanHeight {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double[] heights = new double[11]; 
        System.out.println("Enter heights of 11 players (in meters):");
        for (int i = 0; i < 11; i++) {
            System.out.print("Player " + (i + 1) + ": ");
            heights[i] = scanner.nextDouble();
        }
        double sum = 0;
        for (double height : heights) { 
            sum += height;
        }
        double meanHeight = sum / 11;
        System.out.println("Mean height of players: " + meanHeight + " meters");
    }
}