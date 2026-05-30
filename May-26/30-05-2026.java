// Replace with XOR of Adjacent
// Difficulty: EasyAccuracy: 75.8%Submissions: 71K+Points: 2Average Time: 20m
// Given an array arr[] of n integers, modify the array in-place such that each element is replaced with the XOR of its adjacent elements.

// For the first element, update arr[0] = arr[0] ^ arr[1].
// For the last element, update arr[n-1] = arr[n-2] ^ arr[n-1].
// For all other elements, update arr[i] = arr[i-1] ^ arr[i+1].
// Note: Here, a ^ b represents the XOR operation between a and b. 

class Solution {
    public void replaceElements(int[] arr) {
        // code here
        int n = arr.length;
        
        int first = arr[0] ^ arr[1];
        int last = arr[n - 2] ^ arr[n - 1];
        int prev = arr[0];
        
        for (int i = 1; i < n - 1; i++) {
            int curr = arr[i];
            arr[i] = prev ^ arr[i + 1];    
            prev = curr;
        }
    
        arr[0] = first;
        arr[n - 1] = last;
    }
}