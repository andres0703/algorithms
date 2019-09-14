package basic_algorithms;

public class LongestCommonSubstring {

    public static String lcs(String a, String b) {
        int m = a.length();
        int n = b.length();
        int maxLen = 0;
        int endIdx = 0;  // last char idx of lcs in the first string

        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i < m + 1; i++) {
            for (int j = 0; j < n + 1; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else if (a.charAt(i - 1) != b.charAt(j - 1)) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    if (maxLen < dp[i][j]) {
                        maxLen = dp[i][j];
                        endIdx = j - 1;
                    }
                }
            }
        }
        return b.substring(endIdx - maxLen, endIdx);
    }

    public static void main(String[] args) {
        String a = "XYZAB";
        String b = "ABXYZAY";

        System.out.println(lcs(a, b));
    }
}
