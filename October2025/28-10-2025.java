// Distance of nearest cell having 1
// Difficulty: MediumAccuracy: 47.7%Submissions: 114K+Points: 4Average Time: 20m
// Given a binary grid[][], where each cell contains either 0 or 1, find the distance of the nearest 1 for every cell in the grid.
// The distance between two cells (i1, j1)  and (i2, j2) is calculated as |i1 - i2| + |j1 - j2|. 
// You need to return a matrix of the same size, where each cell (i, j) contains the minimum distance from grid[i][j] to the nearest cell having value 1.

// Note: It is guaranteed that there is at least one cell with value 1 in the grid.


class Solution {
    public ArrayList<ArrayList<Integer>> nearest(int[][] grid) {
        // code here
        int n = grid.length; int m = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 0) grid[i][j] = -1;
                else{
                    grid[i][j] = 0;
                    q.add(new int[]{i,j});
                }
            }
        }
        
        while(!q.isEmpty()){
            int r = q.peek()[0];
            int c = q.remove()[1];
            
            if(r+1 < n && grid[r+1][c] == -1){
                grid[r+1][c] = grid[r][c] + 1;
                q.add(new int[]{r+1,c});
            }
            if(r-1 >= 0 && grid[r-1][c] == -1){
                grid[r-1][c] = grid[r][c] + 1;
                q.add(new int[]{r-1,c});
            }
            if(c+1 < m && grid[r][c+1] == -1){
                grid[r][c+1] = grid[r][c] + 1;
                q.add(new int[]{r,c+1});
            }
            if(c-1 >= 0 && grid[r][c-1] == -1){
                grid[r][c-1] = grid[r][c] + 1;
                q.add(new int[]{r,c-1});
            }
        }
        
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        
        for(int i = 0; i < n; i++){
            ArrayList<Integer> list = new ArrayList<>();
            for(int j = 0; j < m; j++){
                list.add(grid[i][j]);
            }
            ans.add(list);
        }
        
        return ans;
    }
}