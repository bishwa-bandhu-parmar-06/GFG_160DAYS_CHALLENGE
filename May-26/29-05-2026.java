// Count Sorted Digit Groupings
// Difficulty: MediumAccuracy: 59.38%Submissions: 39K+Points: 4
// Given a string s consisting of digits, you can split it into contiguous substrings (sub-groups). For example, the string "112" can be split as: ["1","1","2"], ["11","2"], ["1","12"], and ["112"].

// A grouping is considered valid if the sums of digits of the sub-groups form a non-decreasing sequence from left to right.

// Determine the total number of such valid groupings for the given string.


class Solution {
    public int validGroups(String s) {
        int n = s.length();
        // dp[i][prev] = number of ways starting at index i with previous sum = prev
        // prev can go up to 900 (since max sum of 100 digits '9' = 900)
        Integer[][] dp = new Integer[n+1][901];
        return dfs(s, 0, 0, dp);
    }
    
    private int dfs(String s, int idx, int prevSum, Integer[][] dp) {
        if (idx == s.length()) return 1; // reached end, valid grouping
        
        if (dp[idx][prevSum] != null) return dp[idx][prevSum];
        
        int ways = 0;
        int sum = 0;
        
        // try all possible substrings starting at idx
        for (int j = idx; j < s.length(); j++) {
            sum += s.charAt(j) - '0';
            if (sum >= prevSum) {
                ways += dfs(s, j+1, sum, dp);
            }
        }
        
        return dp[idx][prevSum] = ways;
    }
}