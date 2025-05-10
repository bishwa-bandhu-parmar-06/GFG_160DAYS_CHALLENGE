// Longest Subarray with Majority Greater than K
// Difficulty: MediumAccuracy: 53.66%Submissions: 10K+Points: 4
// Given an array arr[] and an integer k, the task is to find the length of longest subarray in which the count of elements greater than k is more than the count of elements less than or equal to k.

class Solution {
    static int longestSubarray(int[] arr, int k) {
        // Code Here
        int n = arr.length;
        int prefixSum = 0;
        int maxLen = 0;
        
        Map<Integer , Integer> hm = new HashMap<>();
        hm.put(0 , -1);
        
        for (int i = 0 ; i < n ; i++) {
            prefixSum += (arr[i] > k)?1:-1;
            
            if (prefixSum > 0) maxLen = i + 1;    
            
            if (hm.containsKey(prefixSum - 1)){
                maxLen = Math.max(maxLen , i - hm.get(prefixSum - 1));
            }
            
            if (!hm.containsKey(prefixSum)) hm.put(prefixSum , i);
        }
        return maxLen;
    }
}