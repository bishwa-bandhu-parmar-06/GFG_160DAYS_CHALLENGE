// Max Score from Subarray Mins
// Difficulty: MediumAccuracy: 43.26%Submissions: 125K+Points: 4
// You are given an array arr[] of integers. Your task is to find the maximum sum of the smallest and second smallest elements across all subarrays (of size >= 2) of the given array.


class Solution {
    public int maxSum(int arr[]) {
        int ans=Integer.MIN_VALUE;
        for(int i=1;i<arr.length;i++){
            ans=Math.max(ans,arr[i]+arr[i-1]);
        }
        return ans;
    }
}