package Feb12;

import java.util.*;

public class ZeroSumSubarrays {
    static class Pair {
        int start, end;
        Pair(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static List<Pair> findZeroSumSubarrays(int[] nums) {
        List<Pair> result = new ArrayList<>();
        Map<Integer, List<Integer>> sumMap = new HashMap<>();
        int sum = 0;

        // Add an initial entry for sum = 0 at index -1 to handle subarrays starting at index 0
        sumMap.put(0, new ArrayList<>());
        sumMap.get(0).add(-1);

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];

            if (sumMap.containsKey(sum)) {
                for (int start : sumMap.get(sum)) {
                    result.add(new Pair(start + 1, i));
                }
            }

            sumMap.putIfAbsent(sum, new ArrayList<>());
            sumMap.get(sum).add(i);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {6, 3, -1, -3, 4, -2, 2, 4, 6, -12, -7};
        List<Pair> result = findZeroSumSubarrays(nums);

        System.out.println("Subarrays with sum zero:");
        for (Pair p : result) {
            System.out.println("Start: " + p.start + ", End: " + p.end);
        }
    }
}
