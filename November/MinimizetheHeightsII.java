// Minimize the Heights II
// Difficulty: MediumAccuracy: 15.06%Submissions: 637K+Points: 4
// Given an array arr[] denoting heights of N towers and a positive integer K.

// For each tower, you must perform exactly one of the following operations exactly once.

// Increase the height of the tower by K
// Decrease the height of the tower by K
// Find out the minimum possible difference between the height of the shortest and tallest towers after you have modified each tower.

// You can find a slight modification of the problem here.
// Note: It is compulsory to increase or decrease the height by K for each tower. After the operation, the resultant array should not contain any negative integers.

// Examples :

// Input: k = 2, arr[] = {1, 5, 8, 10}
// Output: 5
// Explanation: The array can be modified as {1+k, 5-k, 8-k, 10-k} = {3, 3, 6, 8}.The difference between the largest and the smallest is 8-3 = 5.
// Input: k = 3, arr[] = {3, 9, 12, 16, 20}
// Output: 11
// Explanation: The array can be modified as {3+k, 9+k, 12-k, 16-k, 20-k} -> {6, 12, 9, 13, 17}.The difference between the largest and the smallest is 17-6 = 11. 
// Expected Time Complexity: O(n*logn)
// Expected Auxiliary Space: O(n)

// Constraints
// 1 ≤ k ≤ 107
// 1 ≤ n ≤ 105
// 1 ≤ arr[i] ≤ 107

class Solution {
    int getMinDiff(int[] arr, int k) {
        int n = arr.length;
        if (n == 1) {
            return 0;
        }

        // Sort the array
        Arrays.sort(arr);

        // Initialize the result as the difference between the largest and smallest
        int result = arr[n - 1] - arr[0];

        // Consider the tallest tower and the shortest tower after adding/subtracting k
        int smallest = arr[0] + k;
        int largest = arr[n - 1] - k;

        // Ensure smallest is always the smaller value
        if (smallest > largest) {
            int temp = smallest;
            smallest = largest;
            largest = temp;
        }

        // Traverse the array and update smallest and largest appropriately
        for (int i = 0; i < n - 1; i++) {
            int minHeight = Math.min(smallest, arr[i + 1] - k);
            int maxHeight = Math.max(largest, arr[i] + k);

            // Ensure the height remains non-negative
            if (minHeight < 0) {
                continue;
            }

            result = Math.min(result, maxHeight - minHeight);
        }

        return result;
    }
}
