// Maximum Product Subarray
// Difficulty: Medium       Accuracy: 18.09%       Submissions: 398K+     Points: 4
// Given an array arr[] that contains positive and negative integers (may contain 0 as well). Find the maximum product that we can get in a subarray of arr.

// Note: It is guaranteed that the output fits in a 32-bit integer.


class Solution {
    // Function to find maximum product subarray
    int maxProduct(int[] arr) {
        int n = arr.length;
        int fpro = 1;
        int bpro = 1;
        int max = Integer.MIN_VALUE;
        for(int i =0,j=n-1;i<n;i++,j--){
            fpro *=arr[i];
            bpro *=arr[j];
            if(bpro>max){
                max = bpro;
                
            }
            if(fpro>max){
                max = fpro;
            }
              if(fpro==0){
                fpro = 1;
            }
            if(bpro==0){
                bpro = 1;
            }

        }
        return max;
    }
}