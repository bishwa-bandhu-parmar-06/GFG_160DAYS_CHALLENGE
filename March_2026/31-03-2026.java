// Buy Stock with Transaction Fee
// Difficulty: MediumAccuracy: 57.41%Submissions: 15K+Points: 4Average Time: 20m
// You are given an array arr[], in which arr[i] is the price of a given stock on the ith day and an integer k represents a transaction fee. Find the maximum profit you can achieve. You may complete as many transactions as you like, but you need to pay the transaction fee for each transaction.

// Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).


class Solution {
    public int maxProfit(int arr[], int k) {
        int n = arr.length;
        
        if (n == 0) return 0;
        
        int cash = 0;          // profit when not holding stock
        int hold = -arr[0];    // profit when holding stock
        
        for (int i = 1; i < n; i++) {
            int prevCash = cash;
            
            // Sell stock
            cash = Math.max(cash, hold + arr[i] - k);
            
            // Buy stock
            hold = Math.max(hold, prevCash - arr[i]);
        }
        
        return cash;
    }
}