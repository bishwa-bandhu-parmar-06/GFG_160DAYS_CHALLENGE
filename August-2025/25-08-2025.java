// Maximize median after doing k addition operation
// Difficulty: MediumAccuracy: 40.87%Submissions: 10K+Points: 4Average Time: 20m
// Given an array arr[] consisting of positive integers and an integer k. You are allowed to perform at most k operations, where in each operation, you can increment any one element of the array by 1. Determine the maximum possible median of the array that can be achieved after performing at most k such operations.

// Note: The median of an array is defined as the middle element when the array (after sorting) has an odd size, or the average of the two middle elements when the array (after sorting) has an even size.





class Solution {
    public int maximizeMedian(int[] arr, int k) {
        Arrays.sort(arr);
        int n = arr.length;
        int md = (n-1)/2;
        long sm = k;
        int sz = 1,ans = k+arr[md];
        if(n%2==0){
            ans=(ans+arr[md+1])/2;
            sm+=arr[md++];
            sz++;
        }
        for(int i=md;i<n;i++){
            sm+=arr[i];
            int hf = (int)(sm/sz++);
            ans=Math.min(ans,hf);
        }
        return ans;
    }
}