package practice;

public class BinarySearch {

    public static int binarySearch(int[] nums, int target) {
        int lo = 0;
        int hi = nums.length - 1;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;

            if (nums[mid] == target) return mid;
            if (nums[mid] > target) hi = mid - 1;
            if (nums[mid] < target) lo = mid + 1;
        }
        return -1;
    }

    public static boolean test(int[] nums, int target, int ans) {
        return binarySearch(nums, target) == ans;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3,5,7,9,10,12,15};
        int[] nums2 = new int[]{0};
        System.out.println(test(nums, 12, 5));
        System.out.println(test(nums, 11, -1));
        System.out.println(test(nums2, 0, 0));
    }
}
