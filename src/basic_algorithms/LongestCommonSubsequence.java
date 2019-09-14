package basic_algorithms;

import java.util.Arrays;

public class LongestCommonSubsequence {

    public static String lcs(String a, String b) {
        int m = a.length();
        int n = b.length();

        int[][] dp = new int[m + 1][n + 1];

        for (int i = 0; i < m + 1; i++) {
            for (int j = 0; j < n + 1; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else if (a.charAt(i - 1) == b.charAt(j - 1)) {   // remember dp[i][j] represents char at a: i - 1, b: j - 1
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        int len = dp[m][n];
        int idx = len - 1;  // index pointer of char arr
        char[] arr = new char[len];
        int i = m; int j = n;

        while (idx >= 0) {                               // don't forget the last element( >=0 )
            if (a.charAt(i - 1) == b.charAt(j - 1)) {
                arr[idx--] = a.charAt(i - 1);
                i--; j--;
            } else if (dp[i][j] == dp[i - 1][j]) {
                i--;
            } else {
                j--;
            }
        }
        printArr(dp);
        return String.valueOf(arr);
    }

    private static void printArr(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(Arrays.toString(arr[i]));
        }
    }

    public static void main(String[] args) {
        String a = "MZJAMZU";
        String b = "MXJYAUZ";
        String res = lcs(a, b);
        System.out.println(res);
    }
}

