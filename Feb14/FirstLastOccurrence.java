package Feb14;

public class FirstLastOccurrence {
    public static int findFirstOccurrence(int[] arr, int target) {
        int left = 0, right = arr.length - 1, first = -1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                first = mid;
                right = mid - 1;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return first;
    }

    public static int findLastOccurrence(int[] arr, int target) {
        int left = 0, right = arr.length - 1, last = -1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                last = mid;
                left = mid + 1;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return last;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 2, 2, 3, 4, 5, 5, 5, 6};
        int target = 2;

        int first = findFirstOccurrence(nums, target);
        int last = findLastOccurrence(nums, target);

        System.out.println("First occurrence index: " + first);
        System.out.println("Last occurrence index: " + last);
    }
}

