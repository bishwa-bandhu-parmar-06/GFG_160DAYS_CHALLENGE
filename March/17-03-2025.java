
// Subset Sum Problem
// Difficulty: MediumAccuracy: 32.0%Submissions: 327K+Points: 4
// Given an array of positive integers arr[] and a value sum, determine if there is a subset of arr[] with sum equal to given sum. 



class Solution {
    static Boolean isSubsetSum(int arr[], int sum) {
        int n = arr.length;
        Boolean[][] dp = new Boolean[n + 1][sum + 1];

        return subsetSumUtil(arr, n, sum, dp);
    }

    static Boolean subsetSumUtil(int arr[], int n, int sum, Boolean[][] dp) {
        if (sum == 0) return true;
        if (n == 0) return false;

        if (dp[n][sum] != null) return dp[n][sum];

        if (arr[n - 1] > sum) {
            return dp[n][sum] = subsetSumUtil(arr, n - 1, sum, dp);
        } else {
            return dp[n][sum] = subsetSumUtil(arr, n - 1, sum, dp) || subsetSumUtil(arr, n - 1, sum - arr[n - 1], dp);
        }
    }
}
