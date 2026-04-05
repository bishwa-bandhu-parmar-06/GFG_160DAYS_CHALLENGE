// Target Sum
// Difficulty: MediumAccuracy: 31.52%Submissions: 36K+Points: 4
// Given an array of integers arr[] and an integer target. We need to build an expression out of arr[] by adding one of the symbols '+' or  '-' before each integer in arr[] and then concatenate all the integers. 
// For example : if arr[] = [2, 1], you can add a '+' before 2 and a '-' before 1 and concatenate them to build the expression "+2-1".
// Return the number of different expressions that can be built, which evaluates to target.

// Note : An expression is considered different from another if the placement of '+' and '-' operators differs, even if the resulting value is the same. 



class Solution {
    public int totalWays(int[] arr, int target) {
        int totalSum = 0;
        for (int num : arr) totalSum += num;

        // Edge cases
        if (Math.abs(target) > totalSum) return 0;
        if ((target + totalSum) % 2 != 0) return 0;

        int subsetSum = (target + totalSum) / 2;

        return countSubsets(arr, subsetSum);
    }

    private int countSubsets(int[] arr, int sum) {
        int[] dp = new int[sum + 1];
        dp[0] = 1; // One way to make sum 0

        for (int num : arr) {
            for (int j = sum; j >= num; j--) {
                dp[j] += dp[j - num];
            }
        }

        return dp[sum];
    }
}