package Feb12;

import java.util.*;

public class PairWithGivenSum {
    public static boolean hasPairWithSum(int[] nums, int target) {
        Set<Integer> seen = new HashSet<>();
        
        for (int num : nums) {
            if (seen.contains(target - num)) {
                return true;
            }
            seen.add(num);
        }
        
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {10, 15, 3, 7};
        int target = 17;

        if (hasPairWithSum(nums, target)) {
            System.out.println("Pair with the given sum exists.");
        } else {
            System.out.println("No pair with the given sum exists.");
        }
    }
}
