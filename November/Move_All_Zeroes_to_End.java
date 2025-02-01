// Date : 16/11/2024
// Move All Zeroes to End
// Given an array arr[]. Push all the zeros of the given array to the right end of the array while maintaining the order of non-zero elements. Do the mentioned change in the array in place

class Solution {
    void pushZerosToEnd(int[] arr) {
        // code here
        int n = arr.length;
        int j = 0; // Index for placing non-zero elements

        // Traverse the array
        for (int i = 0; i < n; i++) {
            if (arr[i] != 0) {
                arr[j] = arr[i];
                j++;
            }
        }

        // Fill remaining positions with zeros
        while (j < n) {
            arr[j] = 0;
            j++;
        }
    }
}