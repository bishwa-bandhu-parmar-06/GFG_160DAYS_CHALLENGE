
// Sum of Subarrays
// Difficulty: MediumAccuracy: 23.85%Submissions: 40K+Points: 4
// Given an array arr[], find the sum of all the subarrays of the given array.

// Note: It is guaranteed that the total sum will fit within a 32-bit integer range.





class Solution {
    public int subarraySum(int[] arr) 
    {
        int len = arr.length;
        int sum  = 0;
        for(int i=0;i<len;i++)
        {
            sum+=arr[i]*(i+1)*(len-i);
        }
        return sum;
        
    }
}

