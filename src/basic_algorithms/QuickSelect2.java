package basic_algorithms;

public class QuickSelect2 {

//    public static int quickselect2(int[] nums, int k) {
//        return find(nums, nums.length - k, 0, nums.length);
//    }
//
//    private static int find(int[] nums, int n, int lo, int hi) {
//        if (hi == lo) return nums[lo];
//
//        int pivot = partition(nums, lo, hi);
//        if (pivot == n - 1) return nums[pivot];
//        if (pivot > n - 1) return find(nums, n, lo, pivot - 1);
//        return find(nums, n, pivot + 1, hi);
//    }

//    private static int partition2(int[] nums, int lo, int hi) {
//        int i = lo, j = hi + 1;
//
//        while (true) {
//            int pivot = nums[lo];
//
//            while (nums[++i] < pivot) {
//                if (i == hi) break;
//            }
//
//            while (nums[--j] > pivot)  {}
//
//            if (i >= j) break;
//
//            swap(nums, i, j);
//        }
//        swap(nums, lo, j);
//    }
//
//    private static void swap(int[] nums, int a, int b) {
//        int temp = nums[a];
//        nums[a] = nums[b];
//        nums[b] = temp;
//    }
//
//    public static void main(String[] args) {
//        int[] nums = new int[]{1,3,5,2,9,4,7,6,8};
//        for (int i = 1; i < 10; i++) {
//            System.out.println(quickselect2(nums, i));
//        }
//    }
}
