// All Subsets Xor Sum
// Difficulty: MediumAccuracy: 64.9%Submissions: 8K+Points: 4
// Given an array arr[], return the sum of the XOR of all elements for every possible subset of the array. Subsets with the same elements should be counted multiple times.

// An array a is a subset of an array b if a can be obtained from b by deleting some (possibly zero) elements of b.

// Note: The answer is guaranteed to fit within a 32-bit integer.


class Solution {
    int subsetXORSum(int arr[]) {
        // code here
          int or = 0;
        for (int x : arr) {
            or |= x;    
        }
        int n = arr.length;
        return or * (1 << (n - 1));
    }
}