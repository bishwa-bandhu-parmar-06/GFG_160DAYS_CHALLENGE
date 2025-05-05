// Search in an almost Sorted Array
// Difficulty: MediumAccuracy: 55.44%Submissions: 14K+Points: 4Average Time: 20m
// Given a sorted integer array arr[] consisting of distinct elements, where some elements of the array are moved to either of the adjacent positions, i.e. arr[i] may be present at arr[i-1] or arr[i+1].
// Given an integer target.  You have to return the index ( 0-based ) of the target in the array. If target is not present return -1.

class Solution {
    public int findTarget(int arr[], int tar) {
        // code here
        int n = arr.length;
        
        int lo = 0, hi = n-1;
        while(lo <= hi){
            int mid = lo + (hi-lo)/2;
            
            if(arr[mid] == tar){
                return mid;
            }else if(arr[mid] < tar){
                //just add this condition for just sorted
                if(mid-1 >= 0 && arr[mid-1] == tar) return mid-1;
                lo = mid+1;
            }else{
                if(mid+1 < n && arr[mid+1] == tar) return mid+1;
                hi = mid-1;
            }
        }
        return -1;
    }
}