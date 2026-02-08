// Maximum Product Subarray
// Difficulty: MediumAccuracy: 18.09%Submissions: 497K+Points: 4
// Given an array arr[] that contains positive and negative integers (may contain 0 as well). Find the maximum product that we can get in a subarray of arr[].

// Note: It is guaranteed that the answer fits in a 32-bit integer.


class Solution {
    int maxProduct(int[] arr) {
        
        int prd = Integer.MIN_VALUE;
        int pre = 1, suf = 1;
        int n = arr.length;
        
        for(int i=0; i<n; i++){
            if(pre == 0) pre = 1;
            if(suf == 0) suf = 1;
            
            pre *= arr[i];
            suf *= arr[n-1-i];
            prd = Math.max(prd, Math.max(pre, suf));
        }
        return prd;
    }
}

