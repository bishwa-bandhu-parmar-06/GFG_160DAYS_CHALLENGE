// Number of paths in a matrix with k coins
// Difficulty: MediumAccuracy: 16.96%Submissions: 63K+Points: 4
// You are given a matrix mat[][] of size n x m, where each of its cells contains some coins. Count the number of ways to collect exactly k coins while moving from the top left cell of the matrix to the bottom right cell.
// From a cell (i, j), you can only move to cell (i+1, j) or (i, j+1).

// Note: It is guaranteed that the answer will not exceed 32-bit integer limits.

class Solution {
    public int numberOfPath(int[][] mat, int k) {
        // code here
        int n= mat.length;
        int m= mat[0].length;
        int dp[][][]= new int[n][m][k+1];
        for (int[][] arr2D : dp) {
            for (int[] arr1D : arr2D) {
                Arrays.fill(arr1D, -1);
            }
        }
        return intPaths(mat,k,0,0,mat[0][0],n,m,dp);
    }
    public int intPaths(int[][] mat, int k, int i, int j, int coin, int n, int m, int[][][] dp){
        if (coin > k) return 0;
        if(i==n-1 && j==m-1){
            if(coin==k) return 1;
            else return 0;
        }
        if(dp[i][j][coin] != -1) return dp[i][j][coin];
        int right=0;
        int down=0;
        if(i+1<n) right=intPaths(mat,k,i+1,j,coin+mat[i+1][j],n,m,dp);
        if(j+1<m) down=intPaths(mat,k,i,j+1,coin+mat[i][j+1],n,m,dp);
        return dp[i][j][coin]= right+down;
    }
}