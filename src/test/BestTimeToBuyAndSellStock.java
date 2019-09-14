package test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BestTimeToBuyAndSellStock {

    public static int[] bestTimeToBuyAndSell(double[] prices) {
        if (prices == null || prices.length < 2) {
            throw new IllegalArgumentException("Not enough stock data.");
        }

        double minSoFar = prices[0];
        double maxProfit = Double.MIN_VALUE;
        int minIdx = 0;

        int buyIdx = 0;
        int sellIdx = 0;

        for (int i = 1; i < prices.length; i++) {
            if (maxProfit < prices[i] - minSoFar) {
                maxProfit = prices[i] - minSoFar;
                buyIdx = minIdx;
                sellIdx = i;
            }
            if (prices[i] < minSoFar) {
                minSoFar = prices[i];
                minIdx = i;
            }
        }

        return new int[]{buyIdx, sellIdx};
    }

    private static void constructDateArray(Date[] dates) {
        SimpleDateFormat sdf = new SimpleDateFormat("mm/dd/yyyy, HH:mm:ss");
        try {
            dates[0] = sdf.parse("10/01/2018, 09:30:00");
        } catch (ParseException e) {
            System.out.println("Invalid Input");
        }
        long tenMinutesInMilliseconds = 600000;
        for (int i = 1; i < dates.length; i++) {
            dates[i] = new Date(dates[i - 1].getTime() + tenMinutesInMilliseconds);
        }
    }

    public static void main(String[] args) {
        BestTimeToBuyAndSellStock b = new BestTimeToBuyAndSellStock();
        double[] prices = new double[]{227.95,224.79,223.82,221,219.75,216.82,220.78,220.24,218.5,217.79,222.15,225.75,223.52,224.94,218.01,220.95,221.85,226.23,228.99,228.41,226.51,226.51,223.25,220.15,219.01,217.15,216.6,214.65,214.1,216.8,218.1,213.44,211.75,209.22,210.16,207.7,207.36,207.28,206.05,209.32};
        Date[] dates = new Date[prices.length];
        constructDateArray(dates);

        int[] res = bestTimeToBuyAndSell(prices);
        String buyTime = dates[res[0]].toString().split("\\s+")[3];
        String sellTime = dates[res[1]].toString().split("\\s+")[3];
        System.out.println("Buy stock at " + buyTime + " at $" + prices[res[0]] + ".");
        System.out.println("Sell stock at " + sellTime + " at $" + prices[res[1]] + ".");
        System.out.printf("Maximum profit: $%.2f", (prices[res[1]] - prices[res[0]]));
    }
}
