// Optimal Strategy For A Game
// Difficulty: MediumAccuracy: 49.03%Submissions: 95K+Points: 4
// You are given an integer array arr[] of size n(even). The array elements represent n coins of values v1, v2, ....vn.
// You play against an opponent in an alternating way. In each turn, a player selects either the first or last coin from the row, removes it from the row permanently, and receives the coin's value.
// You need to determine the maximum possible amount of money you can win if you go first.
// Note: Both the players are playing optimally.



class Solution {
    public int maximumAmount(int arr[]) {
        int n = arr.length;
        long dp[][] = new long[n][n];
        for(int i=0;i<n;i++) dp[i][i] = arr[i];
        for(int len=2; len<=n; len++){
            for(int i=0; i+len-1<n; i++){
                int j = i + len - 1;
                long left = arr[i] + Math.min((i+2<=j ? dp[i+2][j] : 0),
                                              (i+1<=j-1 ? dp[i+1][j-1] : 0));
                long right = arr[j] + Math.min((i<=j-2 ? dp[i][j-2] : 0),
                                               (i+1<=j-1 ? dp[i+1][j-1] : 0));
                dp[i][j] = Math.max(left, right);
            }
        }
        return (int)dp[0][n-1];
    }
}