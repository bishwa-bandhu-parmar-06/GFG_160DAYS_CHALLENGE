// Max Circular Subarray Sum
// Difficulty: Hard       Accuracy: 29.37%    Submissions: 117K+     Points: 8
// Given an array of integers arr[] in a circular fashion. Find the maximum subarray sum that we can get if we assume the array to be circular.





class Solution {

    // a: input array
    // n: size of array
    // Function to find maximum circular subarray sum.
    public int circularSubarraySum(int arr[]) {

        // Your code here
        
        int cmins = 0,mins = arr[0];
        int cmaxs = 0,maxs = arr[0],ts = 0;
        
        for(int i = 0;i<arr.length;i++){
            
            cmaxs = Math.max(cmaxs + arr[i],arr[i]);
            maxs = Math.max(cmaxs,maxs);
            
            cmins = Math.min(cmins + arr[i],arr[i]);
            mins = Math.min(cmins,mins);
            
            ts = ts + arr[i];
        }
        
        if(mins == ts) return maxs;
        
        int cirs = ts - mins;
        return Math.max(cirs,maxs);
    }
}