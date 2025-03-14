// Coin Change (Count Ways)
// Difficulty: MediumAccuracy: 43.1%Submissions: 287K+Points: 4
// Given an integer array coins[ ] representing different denominations of currency and an integer sum, find the number of ways you can make sum by using different combinations from coins[ ]. 
// Note: Assume that you have an infinite supply of each type of coin. Therefore, you can use any coin as many times as you want.
// Answers are guaranteed to fit into a 32-bit integer. 


class Solution {
    public int count(int coins[], int sum) {
        int n = coins.length;
        int dp[] = new int[sum + 1];
        dp[0] = 1; // There is 1 way to make sum = 0 (by choosing nothing)
        
        for (int coin : coins) { // Iterate over each coin
            for (int j = coin; j <= sum; j++) { 
                dp[j] += dp[j - coin]; // Add ways by including current coin
            }
        }
        
        return dp[sum];
    }
}
