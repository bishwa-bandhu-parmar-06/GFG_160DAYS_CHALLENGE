// Count Subarray with k odds
// Difficulty: MediumAccuracy: 51.12%Submissions: 18K+Points: 4Average Time: 20m
// You are given an array arr[] of positive integers and an integer k. You have to count the number of subarrays that contain exactly k odd numbers.

class Solution {
    public int countSubarrays(int[] arr, int k) {
        // code here
        int n=arr.length;
        return solve(arr,n,k)-solve(arr,n,k-1);
    }
    private int solve(int[] arr, int n, int k){
        int i=0,j=0,odd=0,ans=0;
        while(i<n){
            if(arr[i]%2==1){
                odd++;
            }
            while(odd>k){
                if(arr[j]%2==1) odd--;
                j++;
            }
            ans+=(i-j+1);
            i++;
        }
        return ans;
    }
}