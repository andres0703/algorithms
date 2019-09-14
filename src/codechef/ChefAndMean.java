package codechef;
import java.util.Arrays;
import java.util.Scanner;

public class ChefAndMean {

    private int[] coins;
    private int n;
    private double mean;

    public ChefAndMean(int n, String str) {
        this.n = n;
        coins = new int[n];
        fillCoins(str);
        this.mean = calculateMean();
    }

    public String getAns() {
        for (int i = 0; i < n; i++) {
            if (coins[i] == mean) return String.valueOf(i + 1);
        }
        return "Impossible";
    }

    private double calculateMean() {
        long sum = 0;
        for (int i = 0; i < n; i++) {
            sum += coins[i];
        }
        return sum * 1.0 / n;
    }

    private void fillCoins(String s) {
        String[] strArr = s.split("\\s+");
        for (int i = 0; i < n; i++) {
            coins[i] = Integer.parseInt(strArr[i]);
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();  // number of tests

        String[] results = new String[test];
        int count = 0;
        while (count < test) {

            // read input of a single test case
            int coinNum = sc.nextInt();
            sc.nextLine();
            String coinStr = sc.nextLine();

            // get result
            ChefAndMean cm = new ChefAndMean(coinNum, coinStr);
            results[count] = cm.getAns();

            count++;
        }
        sc.close();

        for (String res : results) {
            System.out.println(res);
        }
    }
}
