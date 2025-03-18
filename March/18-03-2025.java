// Partition Equal Subset Sum
// Difficulty: MediumAccuracy: 30.24%Submissions: 257K+Points: 4
// Given an array arr[], determine if it can be partitioned into two subsets such that the sum of elements in both parts is the same.

// Note: Each element must be in exactly one subset.

class Solution {
    static boolean equalPartition(int arr[]) {
        int n = arr.length;
        int sum = 0;
        
        // Calculate the sum of all elements
        for (int num : arr) {
            sum += num;
        }
        
        // If sum is odd, it's not possible to partition into two equal subsets
        if (sum % 2 != 0) return false;
        
        int target = sum / 2;
        boolean dp[] = new boolean[target + 1];
        dp[0] = true; // Base case: sum 0 is always achievable
        
        for (int num : arr) {
            for (int j = target; j >= num; j--) {
                dp[j] = dp[j] || dp[j - num];
            }
        }
        
        return dp[target];
    }
}
