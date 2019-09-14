package test;

import java.util.Random;

public class FormTriangle {

    public static double p() {
        final int TEST_TIMES = 100000000;

        Random rand = new Random();
        int count = 0;
        for (int i = 0; i < TEST_TIMES; i++) {
            double p1 = rand.nextDouble();
            double p2 = rand.nextDouble();

            double a = p1, b = Math.abs(p1 - p2), c = 1 - a - b;

            if (formsTriangle(a, b, c)) {
                count++;
            }
        }
        return count * 1.0 / TEST_TIMES;
    }

    private static boolean formsTriangle(double a, double b, double c) {
        if (b < c) {
            double temp = b;
            b = c;
            c = temp;
        }
        if (a < b) {
            double temp = a;
            a = b;
            b = temp;
        }

        if (a >= b + c) return false;
        return true;
    }

    public static void main(String[] args) {
        System.out.println(p());
        //System.out.println(formsTriangle(0.5,0.3,0.3));
    }
}
