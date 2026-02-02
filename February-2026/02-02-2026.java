// Max Circular Subarray Sum
// Difficulty: HardAccuracy: 29.37%Submissions: 189K+Points: 8Average Time: 25m
// You are given a circular array arr[] of integers, find the maximum possible sum of a non-empty subarray. In a circular array, the subarray can start at the end and wrap around to the beginning. Return the maximum non-empty subarray sum, considering both non-wrapping and wrapping cases.


class Solution {
    public int maxCircularSum(int arr[]) {
        // code here
        int maxSoFar = arr[0];
        int max = arr[0];
        int minSoFar = arr[0];
        int min = arr[0];
        
        int total = arr[0];
        
        for(int i=1;i<arr.length;i++)
        {
            max = Math.max(arr[i],arr[i]+max);
            maxSoFar = Math.max(maxSoFar,max);
            
            min = Math.min(arr[i],arr[i]+min);
            minSoFar = Math.min(minSoFar,min);
            
            total+=arr[i];
        }
        
        if(maxSoFar<0)
        return maxSoFar;
        
        return Math.max(maxSoFar,total-minSoFar);
        
    }
}