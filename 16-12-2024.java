// K-th element of two Arrays
// Difficulty: MediumAccuracy: 37.4%Submissions: 295K+Points: 4
// Given two sorted arrays a[] and b[] and an element k, the task is to find the element that would be at the kth position of the combined sorted array.

// Examples :

class Solution {
    public int kthElement(int a[], int b[], int k) {
        // code here
        int n = a.length;
        int m = b.length;
        int[] mergedArray = new int[n + m];
        
        int i = 0, j = 0, l = 0;
        
        // Merge elements from both arrays
        while (i < n && j < m) {
            if (a[i] <= b[j]) {
                mergedArray[l++] = a[i++];
            } else {
                mergedArray[l++] = b[j++];
            }
        }
        
        // Copy remaining elements from arr1 (if any)
        while (i < n) {
            mergedArray[l++] = a[i++];
        }
        
        // Copy remaining elements from arr2 (if any)
        while (j < m) {
            mergedArray[l++] = b[j++];
        }
        
        return mergedArray[k-1];
    }
}