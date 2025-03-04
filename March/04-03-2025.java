// Longest Increasing Subsequence
// Difficulty: MediumAccuracy: 32.8%Submissions: 335K+Points: 4
// Given an array arr[] of non-negative integers, the task is to find the length of the Longest Strictly Increasing Subsequence (LIS).

// A subsequence is strictly increasing if each element in the subsequence is strictly less than the next element.


class Solution {
    static int lis(int arr[]) {
        int n = arr.length;
        if (n == 0) return 0;

        int dp[] = new int[n];
        int maxLen = 1;

        // Initialize all dp values as 1
        for (int i = 0; i < n; i++) dp[i] = 1;

        // Compute LIS for each element
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i] && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                }
            }
            maxLen = Math.max(maxLen, dp[i]);
        }

        return maxLen;
    }
}
