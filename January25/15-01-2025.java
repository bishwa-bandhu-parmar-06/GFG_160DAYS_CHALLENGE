// Longest Subarray with Sum K
// Difficulty: Medium    Accuracy: 24.64%     Submissions: 552K+    Points: 4
// Given an array arr[] containing integers and an integer k, your task is to find the length of the longest subarray where the sum of its elements is equal to the given value k. If there is no subarray with sum equal to k, return 0.



class Solution {
    public int longestSubarray(int[] arr, int k) {
        HashMap<Integer, Integer> hmap=new HashMap<>();
        int sum=0, fans=0;
        for(int i=0;i<arr.length;i++)
        {
            sum+=arr[i];
            if(sum==k)
                fans=Math.max(fans, i+1);
            if(!hmap.containsKey(sum))
                hmap.put(sum,i);
            if(hmap.containsKey(sum-k))
                fans=Math.max(fans, i-hmap.get(sum-k));
        }
        return fans;
    }
}

