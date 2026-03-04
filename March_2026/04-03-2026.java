// Max Xor Subarray of size K
// Difficulty: MediumAccuracy: 55.63%Submissions: 24K+Points: 4Average Time: 15m
// Given an array of integers arr[]  and a number k. Return the maximum xor of a subarray of size k.

// Note: A subarray is a contiguous part of any given array.


class Solution {
    public int maxSubarrayXOR(int[] arr, int k) {
        // code here
        int ans=0;
        int xor=0;
        
        for(int i=0;i<arr.length;i++){
             if(i<k){
                 xor=xor^arr[i];
                 if(i==k-1)ans=Math.max(ans,xor);
                 continue;
             }
               xor=xor^arr[i-k]^arr[i];
               ans=Math.max(ans,xor);
        }
        
        return ans;
    }
}