// Chocolate Pickup II
// Difficulty: HardAccuracy: 72.44%Submissions: 5K+Points: 8
// You are given a square matrix mat[][] of size n × n, where each cell represents either a blocked cell or a cell containing some chocolates. If mat[i][j] equals -1, then the cell is blocked and cannot be visited. Otherwise, mat[i][j] represents the number of chocolates present in that cell.
// The task is to determine the maximum number of chocolates a robot can collected by starting from the top-left cell (0, 0), moving to the bottom-right cell (n-1, n-1), and then returning back to (0, 0).
// While moving from (0, 0) to (n-1, n-1), the robot can move only in the right (i, j+1) or downward (i+1, j) directions. On the return journey from (n-1, n-1) to (0, 0), it can move only in the left (i, j-1) or upward (i-1, j) directions.

// Note: After collecting chocolates from a cell (i, j), that cell becomes empty, meaning mat[i][j] becomes 0 for next visit. If there is no valid path from (0, 0) to (n-1, n-1) or for the return trip, the result should be 0.


class Solution {
    public int toDest(int[][] mat, int i1, int j1, int i2, int[][][] dp){
        
        // j2 is calculated because total steps taken are same → i1+j1 = i2+j2
        int j2 = i1 + j1 - i2;
        
        // If any pointer goes out of grid → invalid path
        if(i1>=mat.length || j1>=mat[0].length || i2>=mat.length || j2>=mat[0].length){
            return Integer.MIN_VALUE/2;
        }
        
        // If any cell is blocked → invalid
        if(mat[i1][j1]==-1 || mat[i2][j2]==-1) return Integer.MIN_VALUE/2; // blocked
        
        // If first pointer reached destination → this is the final step
        if(i1==mat.length-1 && j1==mat[0].length-1){
            return mat[i1][j1]; // destination cell chocolate counted once
        }
        
        if(dp[i1][j1][i2]!=-2){ // if already evaluated
            return dp[i1][j1][i2]; // directly return it 
        }
        
        
        int currChoc = mat[i1][j1]; // Chocolates collected from positions of both pointers
        if(i1!=i2 || j1!=j2){
            // If both pointers are not at same cell → add second cell chocolate too
            currChoc += mat[i2][j2];
        }
        
        int best = Integer.MIN_VALUE;
        
        // Move combinations:
        // Person 1: Down, Person 2: Down
        int option1 = toDest(mat, i1+1, j1, i2+1, dp);
        best = Math.max(best, option1);
    
        // Person 1: Down, Person 2: Right
        int option2 = toDest(mat, i1+1, j1, i2, dp);
        best = Math.max(best, option2);
    
        // Person 1: Right, Person 2: Down
        int option3 = toDest(mat, i1, j1+1, i2+1, dp);
        best = Math.max(best, option3);
    
        // Person 1: Right, Person 2: Right
        int option4 = toDest(mat, i1, j1+1, i2, dp);
        best = Math.max(best, option4);
        
        // Store result = chocolates collected here + best future result
        return dp[i1][j1][i2] = currChoc + best;
    }
    public int chocolatePickup(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        
        
        int[][][] dp = new int[n][m][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                Arrays.fill(dp[i][j], -2);
            }
        }
        
        // Start both persons from (0,0)
        int ans = toDest(mat, 0, 0, 0, dp);
        
        return Math.max(ans, 0);
    }
}