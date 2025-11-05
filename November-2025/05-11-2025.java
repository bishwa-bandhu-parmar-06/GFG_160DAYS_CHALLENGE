// Get Minimum Squares
// Difficulty: MediumAccuracy: 45.22%Submissions: 48K+Points: 4
// Given a positive integer n, find the minimum number of perfect squares (square of an integer) that sum up to n.

// Note: Every positive integer can be expressed as a sum of square numbers since 1 is a perfect square, and any number can be represented as 1*1 + 1*1 + 1*1 + ....



class Solution {
    public int recursion(int n, int[] dp){
        if(n==0) return 0; // base case

        if(dp[n] != Integer.MAX_VALUE){ // if already evaluated
            return dp[n]; // immediately return it
        }

        for(int i=1; i*i<=n; i++){
            // check upto i^2 <= n
            int steps = 1 + recursion(n-(i*i), dp); // count this step and decrease the n by i^2 and then go for remaing
            dp[n] = Math.min(steps, dp[n]); // update dp[n]
        }
        return dp[n]; // min number of perfect squares
    }
    public int minSquares(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        return recursion(n, dp);
    }
}