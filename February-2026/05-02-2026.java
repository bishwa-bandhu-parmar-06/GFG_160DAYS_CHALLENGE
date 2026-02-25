// Maximize Number of 1's
// Difficulty: MediumAccuracy: 39.46%Submissions: 77K+Points: 4Average Time: 20m
// Given a binary array arr[] containing only 0s and 1s and an integer k, you are allowed to flip at most k 0s to 1s. Find the maximum number of consecutive 1's that can be obtained in the array after performing the operation at most k times.

class Solution {
    public int maxOnes(int arr[], int k) {
        int l=0,zeroes=0,maxlen=0,n=arr.length;
        for(int r=0;r<n;r++) {
            if(arr[r]==0) zeroes++;
            while(zeroes>k) {
                if(arr[l]==0) zeroes--;
                l++;
            }
            maxlen=Math.max(maxlen,r-l+1);
        }
        return maxlen;
    }
}