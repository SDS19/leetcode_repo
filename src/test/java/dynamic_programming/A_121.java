package dynamic_programming;

import org.junit.jupiter.api.Test;

public class A_121 {
    /** brute force solution */
    public int maxProfit(int[] prices) {
        int max = 0;
        for (int i = 0; i < prices.length-1; i++)
            for (int j = i+1; j < prices.length; j++)
                max = Math.max(max, prices[j]-prices[i]);
        return Math.max(max, 0);
    }

    /** runtime: 2 ms 88.34%
     *  memory usage: 83.7 MB 39.34% */
    public int maxProfit_1(int[] prices) {
        int profit = 0, min = prices[0];
        for (int i = 1; i < prices.length; i++)
            if (min > prices[i]) min = prices[i];
            else profit = Math.max(profit, prices[i]-min);
        return profit;
    }

    /** runtime: 1 ms 100.00%
     *  memory usage: 84.3 MB 20.51% */
    public int maxProfit_2(int[] prices) {
        int buy = Integer.MAX_VALUE, profit = 0;
        for (int i = 0; i < prices.length; i++) {
            buy = Math.min(buy, prices[i]);
            profit = Math.max(profit, prices[i] - buy);
        }
        return profit;
    }

    /** runtime: 6 ms 6.42%
     *  memory usage: 85.7 MB 5.08% */
    public int maxProfit_3(int[] prices) {
        int min = prices[0];
        int[] minArr = new int[prices.length];
        for (int i = 0; i < prices.length; i++) {
            min = Math.min(min, prices[i]);
            minArr[i] = min;
        }

        int max = prices[prices.length-1];
        int profit = max-min;
        for (int i = prices.length-1; i >= 0; i--) {
            max = Math.max(max, prices[i]);
            profit = Math.max(profit, max-minArr[i]);
        }

        return profit;
    }

    @Test
    void test(){
        int[] a = {7,1,5,3,6,4};
        int[] b = {7,6,4,3,1};
        System.out.println(maxProfit_3(a));
    }
}
