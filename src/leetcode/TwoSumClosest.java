package leetcode;

import java.util.Arrays;

public class TwoSumClosest {
    public int[] closest(int[] nums, int target) {
        int minDiff = Integer.MAX_VALUE;
        int i = 0, j = nums.length - 1;
        int[] res = new int[2];
        Arrays.sort(nums);
        while (i < j) {
            int sum = nums[i] + nums[j];
            if (sum == target) {
                return new int[]{nums[i], nums[j]};
            }
            if (sum > target) j--;
            if (sum < target) {
                if (target - sum < minDiff) {
                    minDiff = target - sum;
                    res[0] = nums[i];
                    res[1] = nums[j];
                }
                i++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {60, 125, 155, 75, 85, 90, 70};
        TwoSumClosest tsc = new TwoSumClosest();
        System.out.println(Arrays.toString(tsc.closest(nums, 234)));
    }
}
