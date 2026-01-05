// Max Sum Subarray of size K
// Difficulty: EasyAccuracy: 49.6%Submissions: 236K+Points: 2
// Given an array of integers arr[]  and a number k. Return the maximum sum of a subarray of size k.

// Note: A subarray is a contiguous part of any given array.

class Solution {
    public int maxSubarraySum(int[] arr, int k) {
        int L = 0;
        int currentSum = 0;
        int result = 0;
        
        for(int R=0; R < arr.length; R++){
            currentSum += arr[R];
            
            if(R - L + 1 == k){
                result = Math.max(result, currentSum);
                currentSum -= arr[L];
                L++;
            }
            
        }
        
       return result;
       
    }
}