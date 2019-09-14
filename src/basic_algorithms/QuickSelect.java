package basic_algorithms;

// return the kth smallest number of the array
public class QuickSelect {

    public static int quickselect(int[] nums, int k) {
        return select(nums, k, 0, nums.length - 1);
    }

    private static int select(int[] nums, int k, int lo, int hi) {
        if (lo == hi) return nums[lo];

        int pivot = partition(nums, lo, hi);

        if (pivot == k - 1) return nums[pivot];

        if (k - 1 < pivot) return select(nums, k, lo, pivot - 1);
        return select(nums, k, pivot + 1, hi);
    }

    private static int partition(int[] nums, int lo, int hi) {
        int i = lo, j = hi + 1;

        while (true) {

            int pivot = nums[lo];

            while (nums[++i] < pivot) {
                if (i == hi) break;
            }
            while (nums[--j] > pivot) {}

            if (i >= j) break;

            swap(nums, i, j);
        }

        swap(nums, lo, j);
        return j;
    }

    private static void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,3,5,2,9,4,7,6,8};
        for (int i = 1; i < 10; i++) {
            System.out.println(quickselect(nums, i));
        }
    }
}
