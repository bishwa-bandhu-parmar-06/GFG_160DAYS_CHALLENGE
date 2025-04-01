// Stock Buy and Sell – Max 2 Transactions Allowed
// Difficulty: HardAccuracy: 50.13%Submissions: 64K+Points: 8Average Time: 20m
// In daily share trading, a trader buys shares and sells them on the same day. If the trader is allowed to make at most 2 transactions in a day, find out the maximum profit that a share trader could have made.

// You are given an array prices[] representing stock prices throughout the day. Note that the second transaction can only start after the first one is complete (buy->sell->buy->sell).




class Solution {
    public static int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) return 0;

        int n = prices.length;

        // Left to Right: Max profit achievable from 0 to i (1st transaction)
        int[] leftProfit = new int[n];
        int minPrice = prices[0];

        for (int i = 1; i < n; i++) {
            minPrice = Math.min(minPrice, prices[i]);
            leftProfit[i] = Math.max(leftProfit[i - 1], prices[i] - minPrice);
        }

        // Right to Left: Max profit achievable from i to n-1 (2nd transaction)
        int[] rightProfit = new int[n];
        int maxPrice = prices[n - 1];

        for (int i = n - 2; i >= 0; i--) {
            maxPrice = Math.max(maxPrice, prices[i]);
            rightProfit[i] = Math.max(rightProfit[i + 1], maxPrice - prices[i]);
        }

        // Compute the maximum profit by splitting at each point
        int maxProfit = 0;
        for (int i = 0; i < n; i++) {
            maxProfit = Math.max(maxProfit, leftProfit[i] + rightProfit[i]);
        }

        return maxProfit;
    }
}
