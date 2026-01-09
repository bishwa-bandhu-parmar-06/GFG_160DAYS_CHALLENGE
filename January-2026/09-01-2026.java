// Subarrays With At Most K Distinct Integers
// Difficulty: MediumAccuracy: 62.09%Submissions: 21K+Points: 4
// You are given an array arr[] of positive integers and an integer k, find the number of subarrays in arr[] where the count of distinct integers is at most k.

// Note: A subarray is a contiguous part of an array.


class Solution {
    public int countAtMostK(int arr[], int k) {
        // code here
        HashMap<Integer, Integer> map=new HashMap<>();
        int cnt=0,l=0,r=0;
        while(l<arr.length){
            map.put(arr[l], map.getOrDefault(arr[l], 0)+1);
            while(map.size()>k){
                map.put(arr[r], map.getOrDefault(arr[r], 0)-1);
                if(map.get(arr[r])==0) map.remove(arr[r]);
                r++;
            }
            cnt += l-r+1;
            l++;
        }
        return cnt;
    }
}