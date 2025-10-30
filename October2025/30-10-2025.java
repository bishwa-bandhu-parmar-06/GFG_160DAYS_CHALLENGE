// Replace O's with X's
// Difficulty: MediumAccuracy: 34.0%Submissions: 129K+Points: 4Average Time: 20m
// You are given a grid[][] of size n*m, where every element is either 'O' or 'X'. You have to replace all 'O' or a group of 'O' with 'X' that are surrounded by 'X'.

// A 'O' (or a set of 'O') is considered to be surrounded by 'X' if there are 'X' at locations just below, just above, just left and just right of it.


class Solution {
    public void fill(char[][] grid) {
        // Code here
        for(int i=0;i<grid.length;i++){
            if(grid[i][0]=='O'){
                checkZero(grid, i, 0);
            }
        }
        for(int i=0;i<grid.length;i++){
            if(grid[i][grid[0].length-1]=='O'){
                checkZero(grid, i, grid[0].length-1);
            }
        }
        for(int i=0;i<grid[0].length;i++){
            if(grid[0][i]=='O'){
                checkZero(grid, 0, i);
            }
        }
        for(int i=0;i<grid[0].length;i++){
            if(grid[grid.length-1][i]=='O'){
                checkZero(grid, grid.length-1, i);
            }
        }
        
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]=='O'){
                    grid[i][j] = 'X';
                }
            }
        }
        
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]=='0'){
                    grid[i][j] = 'O';
                }
            }
        }
    }
    
    void checkZero(char[][] grid, int i, int j){
        if(grid[i][j]=='O'){
            grid[i][j] = '0';
        }
        
        if(j-1>=0 && grid[i][j-1]=='O'){
            checkZero(grid, i, j-1);
        }
        if(i-1>=0 && grid[i-1][j]=='O'){
            checkZero(grid, i-1, j);
        }
        if(i+1<grid.length && grid[i+1][j]=='O'){
            checkZero(grid, i+1, j);
        }
        if(j+1<grid[i].length && grid[i][j+1]=='O'){
            checkZero(grid, i, j+1);
        }
        
    }
}