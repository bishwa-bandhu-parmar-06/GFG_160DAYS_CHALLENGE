// Search in a row-wise sorted matrix
// Difficulty: Easy  Accuracy: 51.77%   Submissions: 22K+      Points: 2
// Given a row-wise sorted 2D matrix mat[][] of size n x m and an integer x, find whether element x is present in the matrix.
// Note: In a row-wise sorted matrix, each row is sorted in itself, i.e. for any i, j within bounds, mat[i][j] <= mat[i][j+1].

class Solution {
    // Function to search a given number in row-column sorted matrix.
    public boolean searchRowMatrix(int[][] mat, int x) {
        // code here
        int i,j;
        for(i=0;i<mat.length;i++)
        {
            for(j=0;j<mat[i].length;j++)
            {
                if(mat[i][j]==x)return true;
            }
        }
        return false;
    }
}