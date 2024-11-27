// Smallest Positive Missing Number
// Difficulty: Medium       Accuracy: 25.13%      Submissions: 365K+        Points: 4
// You are given an integer array arr[]. Your task is to find the smallest positive number missing from the array.

// Note: Positive number starts from 1. The array can have negative integers too.

class Solution {
    // Function to find the smallest positive number missing from the array.
    public int missingNumber(int[] arr) {
        // Your code here
        HashSet<Integer> ar = new HashSet<>();
        Arrays.stream(arr).forEach(ar::add);
        for(int i=0;i<arr.length;i++)
        {
            if(!ar.contains(i+1))
            {
                return i+1;
            }
        }
        return arr.length+1;
    }
}