// Chocolates Pickup
// Difficulty: HardAccuracy: 50.36%Submissions: 46K+Points: 8Average Time: 30m
// You are given a 2D matrix grid[][] of size n*m, where each cell grid[i][j] represents the number of chocolates available at position (i, j).

// Two robots are collecting chocolates from this grid:

// Robot 1 starts at the top-left corner (0, 0)
// Robot 2 starts at the top-right corner (0, m - 1)
// Your task is to determine the maximum total number of chocolates both robots can collect while following these rules:

// From a cell (i, j), robots can move to cell (i + 1, j - 1), (i + 1, j), or (i + 1, j + 1).
// When a robot visits a cell, it collects all the chocolates there.
// If both robots land on the same cell, the chocolates in that cell are collected only once.
// Robots cannot move outside the boundaries of the grid.
// Both robots must continue moving until they reach the bottom row of the grid.


class Solution {
    public int maxChocolate(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int dp[][] = new int[m][m];

        for(int j1 = 0; j1 < m; j1++){
            for(int j2 = 0; j2 < m; j2++){
                if(j1 == j2) dp[j1][j2] = grid[n-1][j1];
                else dp[j1][j2] = grid[n-1][j1] + grid[n-1][j2];
            }
        }

        for(int i = n-2; i >= 0; i--){
            int curr[][] = new int[m][m];

            for(int j1 = 0; j1 < m; j1++){
                for(int j2 = 0; j2 < m; j2++){
                    int max = Integer.MIN_VALUE;

                    for(int dj1 = -1; dj1 <= 1; dj1++){
                        for(int dj2 = -1; dj2 <= 1; dj2++){
                            int value;

                            if(j1 == j2) value = grid[i][j1];
                            else value = grid[i][j1] + grid[i][j2];

                            if(j1 + dj1 >= 0 && j1 + dj1 < m &&
                               j2 + dj2 >= 0 && j2 + dj2 < m){
                                value += dp[j1 + dj1][j2 + dj2];
                            } else {
                                value += -(int)1e8;
                            }

                            max = Math.max(max, value);
                        }
                    }

                    curr[j1][j2] = max;
                }
            }
            dp = curr;
        }

        return dp[0][m-1];
    }
}