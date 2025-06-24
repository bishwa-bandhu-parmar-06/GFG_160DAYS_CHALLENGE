// Lexicographically Largest String After Deleting K Characters
// Difficulty: MediumAccuracy: 66.25%Submissions: 1K+Points: 4Average Time: 15m
// Given a string s consisting of lowercase English letters and an integer k, your task is to remove exactly k characters from the string. The resulting string must be the largest possible in lexicographical  order, while maintain the relative order of the remaining characters.


class Solution {
    public static String maxSubseq(String s, int k) {
        int n = s.length();
        int keep = n - k; // Number of characters to keep
        StringBuilder stack = new StringBuilder();

        for (char c : s.toCharArray()) {
            while (stack.length() > 0 && k > 0 && stack.charAt(stack.length() - 1) < c) {
                stack.deleteCharAt(stack.length() - 1); // Pop
                k--;
            }
            stack.append(c);
        }

        // Return only the first (n - k) characters
        return stack.substring(0, keep);
    }
}
