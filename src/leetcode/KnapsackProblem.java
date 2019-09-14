package leetcode;

import java.util.Arrays;

public class KnapsackProblem {

    public int knapsack(int[][] values, int limit) {
        int items = values.length;
        int[][] dp = new int[items][limit + 1];

        for (int i = 0; i < limit + 1; i++) {
            if (values[0][0] <= i) {
                dp[0][i] = values[0][1];
            }
        }

        for (int i = 1; i < items; i++) {
            for (int j = 0; j < limit + 1; j++) {
                if (j < values[i][0]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], values[i][1] + dp[i - 1][j - values[i][0]]);
                }
            }
        }
        printArray(dp);
        return dp[items - 1][limit];
    }

    public void printArray(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(Arrays.toString(arr[i]));
        }
    }

    public static void main(String[] args) {
        int[][] values = {{5, 60}, {3, 50}, {4, 70}, {2, 30}};
        KnapsackProblem kp = new KnapsackProblem();
        System.out.print(kp.knapsack(values, 5));
    }
}
