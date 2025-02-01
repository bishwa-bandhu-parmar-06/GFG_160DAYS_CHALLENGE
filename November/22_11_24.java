// Stock Buy and Sell – Max one Transaction Allowed
// Difficulty: Easy       Accuracy: 49.33%        Submissions: 26K+     Points: 2
// Given an array prices[] of length n, representing the prices of the stocks on different days. The task is to find the maximum profit possible by buying and selling the stocks on different days when at most one transaction is allowed. Here one transaction means 1 buy + 1 Sell. If it is not possible to make a profit then return 0.

// Note: Stock must be bought before being sold.

class Solution {

    public int maximumProfit(int prices[]) {

        int min = prices[0];

        int res = 0;

        for (int i = 0; i < prices.length; i++)

        {

            res = Math.max(res, prices[i] - min);

            min = Math.min(min, prices[i]);

        }

        return res;
    }
}