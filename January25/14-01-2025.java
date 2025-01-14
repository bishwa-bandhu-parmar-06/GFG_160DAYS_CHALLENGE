// Equilibrium Point
// Difficulty: Easy        Accuracy: 28.13%        Submissions: 603K+        Points: 2
// Given an array arr[] of non-negative numbers. The task is to find the first equilibrium point in the array.

// The equilibrium point in an array is an index (0-based indexing) such that the sum of all elements before that index is the same as the sum of elements after it. Return -1 if no such point exists. 



class Solution {
    // Function to find equilibrium point in the array.
    public static int findEquilibrium(int arr[]) {
        // code here
        int n = arr.length;
        // int TotalSum = 0;
        int RightSum = 0;
        int LeftSum = 0;
        for(int i = 0; i < n; i++){
            RightSum += arr[i];
        }
        
        for(int i = 0; i < n; i++){
            RightSum -= arr[i];
            
            if(RightSum == LeftSum){
                return i;
            }
            LeftSum += arr[i];
        }
        return -1;
    }
}