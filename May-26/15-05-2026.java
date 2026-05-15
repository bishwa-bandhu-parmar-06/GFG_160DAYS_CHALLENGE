// Special Keyboard
// Difficulty: MediumAccuracy: 28.66%Submissions: 60K+Points: 4
// Given a special keyboard that contains only four keys:

// Key 1: Prints a single character 'A' on the screen.
// Key 2 (Ctrl + A): Selects all the characters currently present on the screen.
// Key 3 (Ctrl + C): Copies the selected characters to a buffer.
// Key 4 (Ctrl + V): Pastes the content of the buffer onto the screen, appending it to the existing text.
// Initially, the screen is empty and the buffer is also empty.

// Determine the maximum number of 'A' characters that can be displayed on the screen after performing exactly n key presses.


class Solution {
    public int optimalKeys(int n) {
        int[] dp=new int[n+1];
        Arrays.fill(dp,-1);
        return func(n,dp);
    }
    private int func(int n,int[] dp){
        if(n<=0) return 0;
        
        if(dp[n]!=-1) return dp[n];
        int addA=func(n-1,dp)+1;
        
        for(int j=1;j<=n-3;j++){
            int current=func(j,dp)*func(n-j-1,dp);
            
            addA=Math.max(addA,current);
        }
        return dp[n]= addA;
    }
}