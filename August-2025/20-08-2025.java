// Search in fully rotated sorted 2D matrix
// Difficulty: MediumAccuracy: 72.69%Submissions: 6K+Points: 4Average Time: 20m
// You are given a 2D matrix mat[][] of size n x m that was initially filled in the following manner:


// Each row is sorted in increasing order from left to right.
// The first element of every row is greater than the last element of the previous row.

// This implies that if the matrix is flattened row-wise, it forms a strictly sorted 1D array.
// Later, this sorted 1D array was rotated at some unknown pivot. The rotated array was then written back into the matrix row-wise to form the current matrix.


// Given such a matrix mat[][] and an integer x, determine whether x exists in the matrix.




class Solution {
    
    static boolean f(int arr[], int x){
        int l=0;
        int h=arr.length-1;
          
        while(l<=h){
            int mid=(l+h)>>1;
            
            if(arr[mid]==x)return true;
            
            if(arr[l]<=arr[mid]){
                if(arr[l]<=x && x<=arr[mid]){
                    h=mid-1;
                }else {
                    l=mid+1;
                }
                
            }else {
                if(arr[mid]<=x && x<=arr[h]){
                    l=mid+1;
                }else {
                    h=mid-1;
                }
            }
        }
        
        return false;
    }
    
    
    public boolean searchMatrix(int[][] mat, int x) {
        int m=mat[0].length;
        for(int i=0;i<mat.length;i++){
            if(mat[i][0]<=x && x<=mat[i][m-1]){
                if(f(mat[i],x))return true;
            }else if(mat[i][0]>mat[i][m-1]){
                if(f(mat[i],x))return true;
            }
        }
        
        return false;
    }
}