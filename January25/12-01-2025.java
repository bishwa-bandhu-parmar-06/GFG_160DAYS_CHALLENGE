// Trapping Rain Water
// Difficulty: Hard       Accuracy: 33.14%        Submissions: 444K+       Points: 8
// Given an array arr[] with non-negative integers representing the height of blocks. If the width of each block is 1, compute how much water can be trapped between the blocks during the rainy season. 


class Solution {
    public int maxWater(int arr[]) 
    {
        int n = arr.length;
        int pre_max[] = new int[n];
        int suff_max[] = new int[n];
        
        int maximum_till_now = 0;
        
        for(int i=0; i<n; i++)
        {
            maximum_till_now = Math.max(maximum_till_now, arr[i]);
            pre_max[i] = maximum_till_now;
        }
        
        maximum_till_now = 0;
        
        for(int i=n-1; i>=0; i--)
        {
            maximum_till_now = Math.max(maximum_till_now, arr[i]);
            suff_max[i] = maximum_till_now;
        }
        
        int total_water = 0;
        
        for(int i=0; i<n; i++)
        {
            int curr_water = Math.min(pre_max[i], suff_max[i]) - arr[i];
            total_water += curr_water;
        }
        
        return total_water;
        
    }
}