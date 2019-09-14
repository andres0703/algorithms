package basic_algorithms;

public class BinarySearch {

    public static int search(int[] nums, int target) {
        int lo = 0;
        int hi = nums.length - 1;
        int res = -1;

        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (nums[mid] == target) {
                res = mid;
                break;
            } else if (nums[mid] < target) {
                lo = mid + 1;
            } else if (nums[mid] > target) {
                hi = mid - 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {3,6,19,45,46,59,77,87,122,144,146,189};
        int target = 122;
        System.out.println(search(nums, target));
    }
}
