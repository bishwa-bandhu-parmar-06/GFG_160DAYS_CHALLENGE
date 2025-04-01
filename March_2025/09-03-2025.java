// Palindrome SubStrings
// Difficulty: MediumAccuracy: 45.8%Submissions: 35K+Points: 4Average Time: 30m
// Given a string s, count all palindromic sub-strings present in the string. The length of the palindromic sub-string must be greater than or equal to 2. 



class Solution {
    public int countPS(String s) {
        int n = s.length();
        if (n < 2) return 0; // No valid substrings
        
        boolean[][] dp = new boolean[n][n];
        int count = 0;

        // Checking for substrings of length 1 (not needed as length >= 2)
        for (int i = 0; i < n; i++) dp[i][i] = true;

        // Checking for substrings of length 2
        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                dp[i][i + 1] = true;
                count++;
            }
        }

        // Checking for substrings of length >= 3
        for (int len = 3; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1;
                if (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1]) {
                    dp[i][j] = true;
                    count++;
                }
            }
        }

        return count;
    }
}
