package algorithms.leetcode;

public class BestTimeSellStock {

    /**
     * Say you have an array for which the ith element is the price of a given stock on day i.
     * <p>
     * If you were only permitted to complete at most one transaction (i.e., buy one and sell one share of the stock), design an algorithm to find the maximum profit.
     * <p>
     * Note that you cannot sell a stock before you buy one.
     * <p>
     * Example 1:
     * <p>
     * Input: [7,1,5,3,6,4]
     * Output: 5
     * Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
     * Not 7-1 = 6, as selling price needs to be larger than buying price.
     * Example 2:
     * <p>
     * Input: [7,6,4,3,1]
     * Output: 0
     * Explanation: In this case, no transaction is done, i.e. max profit = 0.
     */

    public int maxProfit(int prices[]) {
        int minprice = Integer.MAX_VALUE;
        int maxprofit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minprice)
                minprice = prices[i];
            else if (prices[i] - minprice > maxprofit)
                maxprofit = prices[i] - minprice;
        }
        return maxprofit;
    }

    /**
     * Version 2
     * Say you have an array for which the ith element is the price of a given stock on day i.
     * <p>
     * Design an algorithm to find the maximum profit. You may complete as many transactions as you like (i.e., buy one and sell one share of the stock multiple times).
     * <p>
     * Note: You may not engage in multiple transactions at the same time (i.e., you must sell the stock before you buy again).
     * <p>
     * Example 1:
     * <p>
     * Input: [7,1,5,3,6,4]
     * Output: 7
     * Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
     * Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.
     * Example 2:
     * <p>
     * Input: [1,2,3,4,5]
     * Output: 4
     * Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
     * Note that you cannot buy on day 1, buy on day 2 and sell them later, as you are
     * engaging multiple transactions at the same time. You must sell before buying again.
     * Example 3:
     * <p>
     * Input: [7,6,4,3,1]
     * Output: 0
     * Explanation: In this case, no transaction is done, i.e. max profit = 0
     */
    //尽可能多的累加peak-valley，多个累加>=头尾的直接差
    public int maxProfitV2(int[] prices) {
        if (prices.length <= 1) return 0;
        int i = 0;
        int valley = prices[0];
        int peak = prices[0];
        int maxprofit = 0;
        while (i < prices.length - 1) {
            while (i < prices.length - 1 && prices[i] >= prices[i + 1])
                i++;
            valley = prices[i];
            while (i < prices.length - 1 && prices[i] <= prices[i + 1])
                i++;
            peak = prices[i];
            maxprofit += peak - valley;
        }
        return maxprofit;
    }

    //直接累加每次相邻两个元素抬升的差值
    public int maxProfitV3(int[] prices) {
        if (prices.length <= 1) return 0;
        int maxprofit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1])
                maxprofit += prices[i] - prices[i - 1];
        }
        return maxprofit;
    }

    //动态规划
    public int maxProfitV4(int[] prices) {
        if (prices.length == 0 || prices.length == 1) return 0;
        int dp[] = new int[prices.length];
        dp[0] = 0;
        for (int i = 1; i < prices.length; i++) {
            dp[i] = Math.max(prices[i] - prices[i - 1] + dp[i - 1], dp[i - 1]);
        }
        return dp[dp.length - 1];
    }

    /**
     * Version 3
     * Say you have an array for which the ith element is the price of a given stock on day i.
     * <p>
     * Design an algorithm to find the maximum profit. You may complete at most two transactions.
     * <p>
     * Note: You may not engage in multiple transactions at the same time (i.e., you must sell the stock before you buy again).
     * <p>
     * Example 1:
     * <p>
     * Input: [3,3,5,0,0,3,1,4]
     * Output: 6
     * Explanation: Buy on day 4 (price = 0) and sell on day 6 (price = 3), profit = 3-0 = 3.
     * Then buy on day 7 (price = 1) and sell on day 8 (price = 4), profit = 4-1 = 3.
     * Example 2:
     * <p>
     * Input: [1,2,3,4,5]
     * Output: 4
     * Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
     * Note that you cannot buy on day 1, buy on day 2 and sell them later, as you are
     * engaging multiple transactions at the same time. You must sell before buying again.
     * Example 3:
     * <p>
     * Input: [7,6,4,3,1]
     * Output: 0
     * Explanation: In this case, no transaction is done, i.e. max profit = 0.
     */
    //只允许最多买卖两次
    public int maxProfitV5(int[] prices) {
        int sell1 = 0, sell2 = 0, buy1 = Integer.MIN_VALUE, buy2 = Integer.MIN_VALUE;
        for (int i = 0; i < prices.length; i++) {
            buy1 = Math.max(buy1, -prices[i]);
            sell1 = Math.max(sell1, buy1 + prices[i]);
            buy2 = Math.max(buy2, sell1 - prices[i]);
            sell2 = Math.max(sell2, buy2 + prices[i]);
        }
        return sell2;
    }

    //动态规划 暴力法
    public int MaxProfitDp(int[] prices) {
        if (prices.length <= 1) return 0;
        int[][] dp = new int[3][prices.length];
        for (int k = 1; k <= 2; k++) {
            for (int i = 1; i < prices.length; i++) {
                int min = prices[0];
                for (int j = 1; j <= i; j++)
                    min = Math.min(min, prices[j] - dp[k - 1][j - 1]);
                dp[k][i] = Math.max(dp[k][i - 1], prices[i] - min);
            }
        }

        return dp[2][prices.length - 1];
    }

    /**
     * Version 4
     *
     * Design an algorithm to find the maximum profit. You may complete at most k transactions.
     *
     * 至多k次买卖交易，求出最大的利润
     */
    //直接使用动态规划
    public int maxProfit(int k, int[] prices) {
        if (prices.length <= 1 || k<=0) return 0;
        if (k >= prices.length / 2) return quickSolve(prices);//意味着可以买卖足够多的次数
        int[][] dp = new int[k+1][prices.length];
        for (int n = 1; n <= k; n++) {
            for (int i = 1; i < prices.length; i++) {
                int min = prices[0];
                for (int j = 1; j <= i; j++) {
                    min = Math.min(min, prices[j] - dp[n - 1][j - 1]);
                }
                dp[n][i] = Math.max(dp[n][i - 1], prices[i] - min);
            }
        }
        return dp[k][prices.length - 1];
    }

    private int quickSolve(int[] prices) {
        int len = prices.length, profit = 0;
        for (int i = 1; i < len; i++)
            // as long as there is a price gap, we gain a profit.
            if (prices[i] > prices[i - 1]) profit += prices[i] - prices[i - 1];
        return profit;
    }

    /**
     * 简化版的动态规划
     * dp[i, j] represents the max profit up until prices[j] using at most i transactions.
     * dp[i, j] = max(dp[i, j-1], prices[j] - prices[jj] + dp[i-1, jj]) { jj in range of [0, j-1] }
     *          = max(dp[i, j-1], prices[j] + max(dp[i-1, jj] - prices[jj]))
     * dp[0, j] = 0; 0 transactions makes 0 profit
     * dp[i, 0] = 0; if there is only one price data point you can't make any transaction.
     */
    public int maxProfitV2(int k, int[] prices) {
        int n = prices.length;
        if (n <= 1)
            return 0;

        //if k >= n/2, then you can make maximum number of transactions.
        if (k >=  n/2) {
            int maxPro = 0;
            for (int i = 1; i < n; i++) {
                if (prices[i] > prices[i-1])
                    maxPro += prices[i] - prices[i-1];
            }
            return maxPro;
        }

        int[][] dp = new int[k+1][n];
        for (int i = 1; i <= k; i++) {
            int localMax = dp[i-1][0] - prices[0];
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.max(dp[i][j-1],  prices[j] + localMax);
                localMax = Math.max(localMax, dp[i-1][j] - prices[j]);
            }
        }
        return dp[k][n-1];
    }


}
