// Unique Paths in a Grid
// Difficulty: MediumAccuracy: 50.47%Submissions: 47K+Points: 4
// You are given a 2d list grid[][] of size n x m consisting of values 0 and 1.
// A value of 0 means that you can enter that cell and 1 implies that entry to that cell is not allowed.
// You start at the upper-left corner of the grid (1, 1) and you have to reach the bottom-right corner (n, m) such that you can only move in the right or down direction from every cell.
// Your task is to calculate the total number of ways of reaching the target.

// Note: The first (1, 1) and last (n, m) cell of the grid can also be 1.
// It is guaranteed that the total number of ways will fit within a 32-bit integer.


class Solution {
    static int possiblePath(int row,int col,int [][] grid,int [][] temp){
        // base case
        if(row==grid.length-1 && col==grid[0].length-1){
            return 1;
        }
        if(temp[row][col]!=-1){
            return temp[row][col];
        }
        // subproblems
        int goRight=0;
        if(row<grid.length && col<grid[0].length-1 && grid[row][col+1]==0){
          goRight=possiblePath(row,col+1,grid,temp);
        }
        int goDown=0;
        if(row<grid.length-1 && col<grid[0].length && grid[row+1][col]==0){
            goDown=possiblePath(row+1,col,grid,temp);
        }
        return temp[row][col]=goRight+goDown;
    }
    public int uniquePaths(int[][] grid) {
        // code here
        int rw=grid.length;
        int column=grid[0].length;
        int [][] temp=new int[rw+1][column+1];
        for(int i=0;i<=rw;i++){
            for(int j=0;j<=column;j++){
                temp[i][j]=-1;
            }
        }
        if(grid[0][0]==1 || grid[rw-1][column-1]==1) return 0;
        return possiblePath(0,0,grid,temp);
    }
};