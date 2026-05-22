// 1s Surrounded by 0s
// Difficulty: MediumAccuracy: 50.93%Submissions: 88K+Points: 4Average Time: 19m
// Given an n × m binary matrix grid[][], find the total count of all cells containing 1 that are unable to move out of the grid through a path of adjacent 1s.

// Adjacency means you can only move in four directions: Up, Down, Left, and Right. Diagonal moves are not allowed.
// Assume that the space immediately outside the grid is an open path. Any 1 located directly on the outer boundary of the grid (first row, last row, first column, or last column) can immediately step out, and any 1 connected to it can follow and also step out of the grid.
// Examples:

// Input: grid[][] = [[0, 0, 0, 0],
// 		[1, 0, 1, 0],
// 		[0, 1, 1, 0],
// 		[0, 0, 0, 0]]


class Solution {
      int[][] directions={
            {-1,0},
            {1,0},
            {0,-1},
            {0,1}
        };
        
    int cntOnes(int[][] grid) {
      
        int m=grid.length;
        int n=grid[0].length;
        boolean[][] visited=new boolean[m][n];
        
        //first row
        for(int i = 0; i < n; i++){
         
         if(grid[0][i]==1)
         {
            dfs(grid,visited,0,i,m,n);
         }
            
        }
        
        //last row
        for(int i = 0; i< n; i++){
           if(grid[m-1][i]==1)
         {
            dfs(grid,visited,m-1,i,m,n);
         }  
        }

        //first col
        for(int j = 0; j < m; j++){
          if(grid[j][0]==1)
         {
            dfs(grid,visited,j,0,m,n);
         }
        }
        
        //last col
        for(int j = 0; j < m; j++){
             if(grid[j][n-1]==1)
         {
            dfs(grid,visited,j,n-1,m,n);
         }
        }
        int count=0;
        
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(grid[i][j]==1 && !visited[i][j])
                {
                    count++;
                }
            }
        }
        return count;

    }
    private void dfs(int[][] grid,boolean[][] visited,int row,int col,int m,int n){
        visited[row][col]=true;
        
        for(int k=0;k<4;k++)
        {
            int newRow=row+directions[k][0];
            int newCol=col+directions[k][1];
            
            
            if(newRow>=0 && newCol>=0 && newRow<m && newCol<n){
                if(grid[newRow][newCol]==1 && !visited[newRow][newCol]){
                dfs(grid,visited,newRow,newCol,m,n);
                }
            }
        }
    }
    
};



