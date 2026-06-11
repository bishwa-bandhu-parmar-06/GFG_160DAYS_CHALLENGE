// Equal Point in Brackets
// Difficulty: EasyAccuracy: 40.8%Submissions: 29K+Points: 2
// Given a string s of opening and closing brackets '(' and ')' only, find an equal point in the string. An equal point is a position k (0-based) such that the number of opening brackets before position k is equal to the number of closing brackets from position k to the end of the string. If multiple such points exist, return the first valid position.

// The string can be split at any position from 0 to n, where n is the length of the string.
// If we split at 0, it means there is an empty string on left.
// If we split at n, it means there is an empty string on right.



class Solution {
    public int findIndex(String s) {
        int n = s.length();

        int closeRemaining = 0;
        for (char ch : s.toCharArray()) {
            if (ch == ')') {
                closeRemaining++;
            }
        }

        int openCount = 0;

        for (int i = 0; i < n; i++) {
            if (openCount == closeRemaining) {
                return i;
            }

            if (s.charAt(i) == '(') {
                openCount++;
            } else {
                closeRemaining--;
            }
        }

        // Check split position at n
        if (openCount == closeRemaining) {
            return n;
        }

        return n;
    }
}