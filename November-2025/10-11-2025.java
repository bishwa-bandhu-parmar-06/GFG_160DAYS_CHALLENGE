// Stock Buy and Sell with Cooldown
// Difficulty: MediumAccuracy: 51.65%Submissions: 13K+Points: 4Average Time: 20m
// Given an array arr[], where the ith element of arr[] represents the price of a stock on the ith day (all prices are non-negative integers). Find the maximum profit you can make by buying and selling stocks such that after selling a stock, you cannot buy again on the next day (i.e., there is a one-day cooldown).


class Solution {
    public int maxProfit(int arr[]) {
        // Code here
        int n = arr.length;
        if (n == 0) return 0;

        long dp0 = 0;           
        long dp1 = -arr[0];     
        long dp2 = 0;           
        
        for (int i = 1; i < n; ++i) {
            long price = arr[i];
            long prev0 = dp0, prev1 = dp1, prev2 = dp2;
            
            dp0 = Math.max(prev0, prev2);            
            dp1 = Math.max(prev1, prev0 - price);    
            dp2 = prev1 + price;
        }
        
        return (int)Math.max(dp0, dp2);
    }
}