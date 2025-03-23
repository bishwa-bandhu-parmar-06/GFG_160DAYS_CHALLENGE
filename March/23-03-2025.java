// Total Decoding Messages
// Difficulty: MediumAccuracy: 15.79%Submissions: 146K+Points: 4Average Time: 20m
// A message containing letters A-Z is being encoded to numbers using the following mapping:

// 'A' -> 1
// 'B' -> 2
// ...
// 'Z' -> 26

// You are given a string digits. You have to determine the total number of ways that message can be decoded.

class Solution {
    public int countWays(String digits) {
        int n = digits.length();
        if (n == 0 || digits.charAt(0) == '0') return 0;
        
        int[] dp = new int[n + 1]; 
        dp[0] = 1; // Empty string case
        dp[1] = 1; // Single character case (already checked it’s not '0')

        for (int i = 2; i <= n; i++) {
            int oneDigit = digits.charAt(i - 1) - '0'; // Single digit
            int twoDigits = Integer.parseInt(digits.substring(i - 2, i)); // Two digits
            
            if (oneDigit >= 1) {
                dp[i] += dp[i - 1]; // If the last single digit is valid
            }
            if (twoDigits >= 10 && twoDigits <= 26) {
                dp[i] += dp[i - 2]; // If the last two digits form a valid character
            }
        }
        return dp[n];
    }
}
