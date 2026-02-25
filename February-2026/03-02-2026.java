// Stock Buy and Sell – Max one Transaction Allowed
// Difficulty: EasyAccuracy: 49.33%Submissions: 127K+Points: 2Average Time: 10m
// Given an array prices[] of non-negative integers, representing the prices of the stocks on different days. The task is to find the maximum profit possible by buying and selling the stocks on different days when at most one transaction is allowed. Here one transaction means 1 buy + 1 Sell. If it is not possible to make a profit then return 0.

// Note: Stock must be bought before being sold.


class Solution {
    public int maxProfit(int prices[]) {
        // Handle edge cases where no transaction can happen
        if (prices == null || prices.length < 2) {
            return 0;
        }

        int right_max = prices[prices.length - 1];
        int res = 0;

        // Traverse from right to left to find the max price in the "future"
        for (int i = prices.length - 2; i >= 0; i--) {
            // Update the maximum price seen to the right of the current day
            if (prices[i] > right_max) {
                right_max = prices[i];
            }
            
            // Calculate potential profit: (Max future price - Current buy price)
            if (res < right_max - prices[i]) {
                res = right_max - prices[i];
            }
        }
        
        return res;
    }
}