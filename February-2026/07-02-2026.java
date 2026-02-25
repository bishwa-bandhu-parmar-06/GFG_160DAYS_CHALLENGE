// Max sum in the configuration
// Difficulty: MediumAccuracy: 36.56%Submissions: 119K+Points: 4Average Time: 30m
// Given an integer array arr[]. Find the maximum value of the sum of i*arr[i] for all 0 ≤ i ≤ arr.size()-1. The only operation allowed is to rotate(clockwise or counterclockwise) the array any number of times.

class Solution {
    int maxSum(int[] arr) {
        // code here
        int n=arr.length;
         int arrSum = 0;
        int curr = 0;

        // Calculate array sum and initial i * arr[i]
        for (int i = 0; i < n; i++) {
            arrSum += arr[i];
            curr += i * arr[i];
        }

        int maxValue = curr;

        // Compute values for remaining rotations
        for (int i = 1; i < n; i++) {
            curr = curr + arrSum - n * arr[n - i];
            maxValue =Math.max(maxValue, curr);
        }

        return maxValue;
    }
}