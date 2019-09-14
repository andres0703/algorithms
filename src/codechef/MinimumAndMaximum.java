package codechef;

import java.math.BigInteger;
import java.util.Scanner;

public class MinimumAndMaximum {

    private int res;

    // N: number of people, K: number of chocolate
    public MinimumAndMaximum(int N, BigInteger K) {
        BigInteger A = K.mod(BigInteger.valueOf(N));  // a = K % N
        int a = A.intValue();
        int b = N - a;
        this.res = calculate(a, b);
    }

    private int calculate(int a, int b) {
        if (a == 0) return 0;

        if (a == b) return Math.min(a, b) * 2 - 1;
        return Math.min(a, b) * 2;
    }

    public int getResult() {
        return res;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int test = sc.nextInt();

        while (test > 0) {

            int N = sc.nextInt();
            BigInteger K = sc.nextBigInteger();

            MinimumAndMaximum mm = new MinimumAndMaximum(N, K);
            System.out.println(mm.getResult());

            test--;
        }
    }
}
