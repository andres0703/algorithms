package practice;

public class Quicksort {

    public static void sort(int[] nums) {
        sort(nums, 0, nums.length - 1);
    }

    private static void sort(int[] nums, int lo, int hi) {
        if (lo >= hi) return;
        int pivot = partition(nums, lo, hi);
        sort(nums, lo, pivot - 1);
        sort(nums, pivot + 1, hi);
    }

    // use the first element (nums[lo]) as the partition element
    private static int partition(int[] nums, int lo, int hi) {
        int i = lo, j = hi + 1;

        while (true) {

            while (nums[++i] < nums[lo]) {
                if (i == hi) break;  // stop if it hits right bound
            }
            while (nums[--j] > nums[lo]) {
                if (j == lo) break;  // optional because it'll stop when it hits lo
            }

            swap(nums, i, j);

            if (i >= j) break;  // stop if two pointers cross
        }

        swap(nums, lo, j);
        return j;
    }

    private static void swap(int[] nums, int a, int b) {

    }
}
