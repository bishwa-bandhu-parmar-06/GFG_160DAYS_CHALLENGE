// Cutting Binary String
// Difficulty: MediumAccuracy: 49.71%Submissions: 31K+Points: 4
// You are given a binary string s consisting only of characters '0' and '1'. Your task is to split this string into the minimum number of non-empty substrings such that:

// Each substring represents a power of 5 in decimal (e.g., 1, 5, 25, 125, ...).
// No substring should have leading zeros.
// Return the minimum number of such pieces the string can be divided into.
// Note: If it is not possible to split the string in this way, return -1.


class Solution {
    public int cuts(String s) {
        int n = s.length();
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0; // base case: empty string needs 0 cuts

        for (int i = 1; i <= n; i++) {
            for (int j = i - 1; j >= 0; j--) {
                String sub = s.substring(j, i);
                if (isValidPowerOf5(sub)) {
                    if (dp[j] != Integer.MAX_VALUE) {
                        dp[i] = Math.min(dp[i], dp[j] + 1);
                    }
                }
            }
        }

        return dp[n] == Integer.MAX_VALUE ? -1 : dp[n];
    }

    private boolean isValidPowerOf5(String s) {
        if (s.charAt(0) == '0') return false; // leading zero is not allowed
        int num = 0;
        for (char c : s.toCharArray()) {
            num = num * 2 + (c - '0');
            if (num > Integer.MAX_VALUE / 2) return false; // prevent overflow
        }
        return isPowerOfFive(num);
    }

    private boolean isPowerOfFive(int num) {
        if (num == 0) return false;
        while (num % 5 == 0) {
            num /= 5;
        }
        return num == 1;
    }
}
