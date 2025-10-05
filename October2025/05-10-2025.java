// Rat in a Maze
// Difficulty: MediumAccuracy: 35.75%Submissions: 381K+Points: 4Average Time: 25m
// Consider a rat placed at position (0, 0) in an n x n square matrix maze[][]. The rat's goal is to reach the destination at position (n-1, n-1). The rat can move in four possible directions: 'U'(up), 'D'(down), 'L' (left), 'R' (right).

// The matrix contains only two possible values:

// 0: A blocked cell through which the rat cannot travel.
// 1: A free cell that the rat can pass through.
// Your task is to find all possible paths the rat can take to reach the destination, starting from (0, 0) and ending at (n-1, n-1), under the condition that the rat cannot revisit any cell along the same path. Furthermore, the rat can only move to adjacent cells that are within the bounds of the matrix and not blocked.
// If no path exists, return an empty list.

// Note: Return the final result vector in lexicographically smallest order.










class Solution {
    public ArrayList<String> ratInMaze(int[][] maze) {
        // code here
    
        int n = maze.length;
        ArrayList<String> paths = new ArrayList<>();

        if (maze[0][0] == 0 || maze[n - 1][n - 1] == 0)
            return paths;

        boolean[][] visited = new boolean[n][n];
        solve(0, 0, maze, n, visited, "", paths);

        Collections.sort(paths); // Sort in lexicographical order
        return paths;
    }

    private void solve(int i, int j, int[][] maze, int n, boolean[][] visited, String path, ArrayList<String> paths) {
        if (i == n - 1 && j == n - 1) {
            paths.add(path);
            return;
        }

        
        visited[i][j] = true;

  
        if (isSafe(i + 1, j, maze, n, visited))
            solve(i + 1, j, maze, n, visited, path + "D", paths);

       
        if (isSafe(i, j - 1, maze, n, visited))
            solve(i, j - 1, maze, n, visited, path + "L", paths);

     
        if (isSafe(i, j + 1, maze, n, visited))
            solve(i, j + 1, maze, n, visited, path + "R", paths);

   
        if (isSafe(i - 1, j, maze, n, visited))
            solve(i - 1, j, maze, n, visited, path + "U", paths);

      
        visited[i][j] = false;
    }
    
    
      private boolean isSafe(int i, int j, int[][] maze, int n, boolean[][] visited) {
        return (i >= 0 && j >= 0 && i < n && j < n && maze[i][j] == 1 && !visited[i][j]);
    }
}