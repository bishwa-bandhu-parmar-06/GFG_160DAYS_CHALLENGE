// Find the number of islands
// Difficulty: MediumAccuracy: 42.12%Submissions: 234K+Points: 4Average Time: 20m
// Given a grid of size n*m (n is the number of rows and m is the number of columns in the grid) consisting of 'W's (Water) and 'L's (Land). Find the number of islands.

// Note: An island is either surrounded by water or the boundary of a grid and is formed by connecting adjacent lands horizontally or vertically or diagonally i.e., in all 8 directions.


class Solution {
    public int countIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        
        int n = grid.length;
        int m = grid[0].length;
        int count = 0;
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 'L') {
                    dfs(grid, i, j, n, m);
                    count++;
                }
            }
        }
        
        return count;
    }
    
    private void dfs(char[][] grid, int i, int j, int n, int m) {
        if (i < 0 || i >= n || j < 0 || j >= m || grid[i][j] != 'L') {
            return;
        }
        
        grid[i][j] = 'V'; // Mark as visited
        
        // Check all 8 directions
        dfs(grid, i-1, j, n, m);   // up
        dfs(grid, i+1, j, n, m);   // down
        dfs(grid, i, j-1, n, m);   // left
        dfs(grid, i, j+1, n, m);   // right
        dfs(grid, i-1, j-1, n, m); // top-left
        dfs(grid, i-1, j+1, n, m); // top-right
        dfs(grid, i+1, j-1, n, m); // bottom-left
        dfs(grid, i+1, j+1, n, m); // bottom-right
    }
}