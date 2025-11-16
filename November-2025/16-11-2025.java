// Longest Common Increasing Subsequence
// Difficulty: MediumAccuracy: 40.62%Submissions: 18K+Points: 4
// Given two arrays, a[] and b[], find the length of the longest common increasing subsequence(LCIS).

// Note:  LCIS refers to a subsequence that is present in both arrays and strictly increases.



class Solution {
    public int LCIS(int[] a, int[] b) {
        // code here
         int n = a.length, m = b.length;
        int[] dp = new int[m];
        for (int i = 0; i < n; i++) {
            int currentMax = 0;
            for (int j = 0; j < m; j++) {
                if (a[i] == b[j]) {
                    dp[j] = currentMax + 1;
                } 
                else if (b[j] < a[i]) {
                    currentMax = Math.max(currentMax, dp[j]);
                }
            }
        }
        int ans = 0;
        for (int v : dp) ans = Math.max(ans, v);
        return ans;
    }
}