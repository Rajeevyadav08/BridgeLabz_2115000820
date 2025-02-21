package Feb18;

import java.util.*;

public class BinaryNumbersQueue {
    public static List<String> generateBinaryNumbers(int N) {
        List<String> result = new ArrayList<>();
        Queue<String> queue = new LinkedList<>();
        
        queue.add("1"); // Start with "1"

        for (int i = 0; i < N; i++) {
            String current = queue.remove(); // Dequeue the front element
            result.add(current);

            // Generate next binary numbers and enqueue them
            queue.add(current + "0");
            queue.add(current + "1");
        }

        return result;
    }

    public static void main(String[] args) {
        int N = 5;
        System.out.println("Binary Numbers: " + generateBinaryNumbers(N));
    }
}
