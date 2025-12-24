// Count elements less than or equal to k in a sorted rotated array
// Difficulty: MediumAccuracy: 63.7%Submissions: 8K+Points: 4Average Time: 15m
// Given a sorted array arr[] containing distinct positive integers that has been rotated at some unknown pivot, and a value x. Your task is to count the number of elements in the array that are less than or equal to x.

// Examples:


class Solution {
    public int countLessEqual(int[] arr, int x) {
        // code here
         int count = 0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]<=x){
                count++;
            }
        }
        return count;
        
    }
}