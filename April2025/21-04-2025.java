// Missing in Array
// Difficulty: EasyAccuracy: 29.59%Submissions: 1.4MPoints: 2Average Time: 15m
// You are given an array arr[] of size n - 1 that contains distinct integers in the range from 1 to n (inclusive). This array represents a permutation of the integers from 1 to n with one element missing. Your task is to identify and return the missing element.

class Solution {
    int missingNum(int arr[]) {
        int n = arr.length + 1;  // Since one number is missing
        int total = n * (n + 1) / 2;

        int sum = 0;
        for (int num : arr) {
            sum += num;
        }

        return total - sum;
    }
}
