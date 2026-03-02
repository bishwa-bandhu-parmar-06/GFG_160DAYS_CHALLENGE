// Trapping Rain Water
// Difficulty: HardAccuracy: 33.14%Submissions: 503K+Points: 8Average Time: 20m
// Given an array arr[] with non-negative integers representing the height of blocks. If the width of each block is 1, compute how much water can be trapped between the blocks during the rainy season. 


class Solution {
    public int maxWater(int arr[]) {
        
        int n = arr.length;
        int lh = arr[0], rh = arr[n-1];
        int l=0, r = n-1;
        
        int res = 0;
        while(l < r) {
            if(lh < rh) {
                if(lh < arr[l]) {
                    lh = arr[l];
                    continue;
                }
                res += (lh - arr[l]);
                l++;
            }
            else {
                if(rh < arr[r]) {
                    rh = arr[r];
                    continue;
                }
                res += (rh - arr[r]);
                r--;
            }
        }
        return res;
    }
}