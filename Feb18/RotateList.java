package Feb18;
import java.util.*;

public class RotateList {
    public static void rotateList(List<Integer> list, int k) {
        int n = list.size();
        k = k % n; // Handle cases where k > n
        
        if (k == 0) return; // No rotation needed
        
        reverse(list, 0, k - 1);
        reverse(list, k, n - 1);
        reverse(list, 0, n - 1);
    }

    private static void reverse(List<Integer> list, int left, int right) {
        while (left < right) {
            int temp = list.get(left);
            list.set(left, list.get(right));
            list.set(right, temp);
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(10, 20, 30, 40, 50));
        int k = 2;
        
        rotateList(list, k);
        System.out.println("Rotated List: " + list);
    }
}

