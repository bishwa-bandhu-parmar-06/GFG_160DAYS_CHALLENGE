// Painting the Fence
// Difficulty: MediumAccuracy: 32.89%Submissions: 126K+Points: 4Average Time: 40m
// Given a fence with n posts and k colours, find out the number of ways of painting the fence so that not more than two consecutive posts have the same colours.
// Answers are guaranteed to be fit into a 32 bit integer.


class Solution {
        int solve(int n, int k) {
        int prev2 = k;
        int prev1 = k * k;
        int curr;
        
        if(n == 1)
            return prev2;
        if(n == 2)
            return prev1;
        
        for(int i = 3; i <= n; i++) {
            int ans = (prev1 + prev2)*(k - 1);
            curr = ans;
            // Shift
            prev2 = prev1;
            prev1 = curr;
        }
        return prev1;
    }
    
    int countWays(int n, int k) {
        int ans = solve(n, k);
        return ans;
    }

}
