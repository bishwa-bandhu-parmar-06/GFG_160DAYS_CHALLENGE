// Count Pairs whose sum is less than target
// Difficulty: Easy        Accuracy: 54.69%       Submissions: 10K+        Points: 2
// Given an array arr[] and an integer target. You have to find the number of pairs in the array whose sum is strictly less than the target.


class Solution {
    int countPairs(int arr[], int target) {
        Arrays.sort(arr);
        
        int left = 0, right = arr.length - 1;
        int count = 0;
        
        // Two-pointer approach
        while (left < right) {
            if (arr[left] + arr[right] < target) {
                // All pairs from left to right are valid
                count += (right - left);
                left++; // Move the left pointer
            } else {
                right--; // Move the right pointer
            }
        }
        
        return count;
    }
}