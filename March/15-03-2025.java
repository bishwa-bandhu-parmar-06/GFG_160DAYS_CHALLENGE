// Coin Change (Minimum Coins)
// Difficulty: MediumAccuracy: 26.74%Submissions: 242K+Points: 4
// You are given an array coins[], where each element represents a coin of a different denomination, and a target value sum. You have an unlimited supply of each coin type {coins1, coins2, ..., coinsm}.

// Your task is to determine the minimum number of coins needed to obtain the target sum. If it is not possible to form the sum using the given coins, return -1.



class Solution {
    public int minCoins(int coins[], int sum) {
        int n = coins.length;
        int dp[] = new int[sum + 1];
        
        // Initialize dp array with a large value
        for (int i = 1; i <= sum; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        
        dp[0] = 0; // Base case: 0 coins required to make sum 0

        for (int i = 1; i <= sum; i++) {
            for (int coin : coins) {
                if (i >= coin && dp[i - coin] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        
        return dp[sum] == Integer.MAX_VALUE ? -1 : dp[sum];
    }
}
