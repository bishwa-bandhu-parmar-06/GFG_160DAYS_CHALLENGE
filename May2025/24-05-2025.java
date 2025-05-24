// Sum of all substrings of a number
// Difficulty: MediumAccuracy: 38.11%Submissions: 63K+Points: 4
// Given an integer s represented as a string, the task is to get the sum of all possible sub-strings of this string.

// Note: The number may have leading zeros.
// It is guaranteed that the total sum will fit within a 32-bit signed integer.


class Solution {
    public static int sumSubstrings(String s) {
        int n = s.length();
        long sum = 0;
        long prev = 0;
        int mod = 1000000007;

        for (int i = 0; i < n; i++) {
            int num = s.charAt(i) - '0';
            prev = (prev * 10 + (long)(num) * (i + 1)) % mod;
            sum = (sum + prev) % mod;
        }
        return (int) sum;
    }
}
