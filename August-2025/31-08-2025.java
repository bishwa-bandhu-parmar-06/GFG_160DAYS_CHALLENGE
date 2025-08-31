// Container With Most Water
// Difficulty: MediumAccuracy: 53.84%Submissions: 87K+Points: 4Average Time: 30m
// Given an array arr[] of non-negative integers, where each element arr[i] represents the height of the vertical lines, find the maximum amount of water that can be contained between any two lines, together with the x-axis.

// Note: In the case of a single vertical line it will not be able to hold water.


class Solution {
    public int maxWater(int arr[]) {
        int max =0;
        int i=0, j=arr.length-1;
        while(i<j){
            int k = (j-i)*(Math.min(arr[i], arr[j]));
            max=Math.max(max, k);
            if(arr[i]>arr[j]){
                j--;
            }
            else{
                i++;
            }
        }
        return max;
    }
}