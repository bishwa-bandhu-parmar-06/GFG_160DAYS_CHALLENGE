// Move All Zeroes to End
// Difficulty: EasyAccuracy: 45.51%Submissions: 426K+Points: 2Average Time: 15m
// You are given an array arr[] of non-negative integers. You have to move all the zeros in the array to the right end while maintaining the relative order of the non-zero elements. The operation must be performed in place, meaning you should not use extra space for another array.


class Solution {   
    private static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
    
    void pushZerosToEnd(int[] arr) {
        int n = arr.length;
        int start = 0;
        for(int i=0;i<n;i++) {
            if(arr[i]!=0) {
                swap(arr, i, start++);
            }
        }
    }
}