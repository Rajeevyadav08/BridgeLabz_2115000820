package Feb14;

public class PeakElementSearch {
    public static int findPeakElement(int[] arr) {
        int left = 0, right = arr.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] > arr[mid + 1]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 7, 8, 5, 2, 6, 4};

        int peakIndex = findPeakElement(nums);
        System.out.println("Peak element index: " + peakIndex);
        System.out.println("Peak element: " + nums[peakIndex]);
    }
}
