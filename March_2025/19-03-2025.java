// Stock Buy and Sell – Max K Transactions Allowed
// Difficulty: HardAccuracy: 48.35%Submissions: 48K+Points: 8
// In the stock market, a person buys a stock and sells it on some future date. You are given an array prices[] representing stock prices on different days and a positive integer k, find out the maximum profit a person can make in at-most k transactions.

// A transaction consists of buying and subsequently selling a stock and new transaction can start only when the previous transaction has been completed.




class Solution {
    static int maxProfit(int prices[], int k) {
        int n = prices.length;
        if (n == 0 || k == 0) return 0;

        // If k >= n/2, problem reduces to unlimited transactions
        if (k >= n / 2) {
            int profit = 0;
            for (int i = 1; i < n; i++) {
                if (prices[i] > prices[i - 1])
                    profit += prices[i] - prices[i - 1];
            }
            return profit;
        }

        int[][] dp = new int[k + 1][n];
        
        for (int i = 1; i <= k; i++) {
            int maxDiff = -prices[0];
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.max(dp[i][j - 1], prices[j] + maxDiff);
                maxDiff = Math.max(maxDiff, dp[i - 1][j] - prices[j]);
            }
        }
        return dp[k][n - 1];
    }
}
