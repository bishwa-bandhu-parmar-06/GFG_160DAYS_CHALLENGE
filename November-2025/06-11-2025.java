// Ways To Tile A Floor
// Difficulty: MediumAccuracy: 32.31%Submissions: 57K+Points: 4
// Given a floor of dimensions 2 x n and tiles of dimensions 2 x 1, the task is to find the number of ways the floor can be tiled. A tile can either be placed horizontally i.e as a 1 x 2 tile or vertically i.e as 2 x 1 tile. 

// Note: Two tiling arrangements are considered different if the placement of at least one tile differs.

class Solution {
    public int numberOfWays(int n) {
        // code here
        // if(n==1 || n==0)
        // {
        //     return 1;
        // }
        // if(n<0)
        // {
        //     return 0;
        // }
        // return numberOfWays(n-1)+numberOfWays(n-2);
        
        int[] dp = new int[n+1];
        dp[0]=1;
        dp[1]=1;
        
        if(n==1 && n==0) return 1;
        
        for(int i=2; i<n+1; i++){
            dp[i] = dp[i-1]+dp[i-2];
        }
        
        return dp[n];
    }
};

