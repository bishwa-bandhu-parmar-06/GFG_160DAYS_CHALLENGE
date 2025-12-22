// Row with max 1s
// Difficulty: MediumAccuracy: 33.09%Submissions: 370K+Points: 4
// You are given a 2D binary array arr[][] consisting of only 1s and 0s. Each row of the array is sorted in non-decreasing order. Your task is to find and return the index of the first row that contains the maximum number of 1s. If no such row exists, return -1.

// Note:

// The array follows 0-based indexing.
// The number of rows and columns in the array are denoted by n and m respectively.
// Examples:


class Solution {
    public int rowWithMax1s(int arr[][]) {
        // code here
        int n = arr.length;
        int j = arr[0].length-1;
        int ans = -1;
        for(int i=0; i<n; i++){
            while(j>=0 && arr[i][j]==1){
               ans = i; 
               j--;
            }
        
        if(j==-1) return i;
        }
        return ans;
    }
    
}