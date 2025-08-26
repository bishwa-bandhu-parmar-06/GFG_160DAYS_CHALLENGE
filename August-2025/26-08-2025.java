// Check if a String is Subsequence of Other
// Difficulty: EasyAccuracy: 51.68%Submissions: 22K+Points: 2
// Given two strings s1 and s2. You have to check that s1 is a subsequence of s2 or not.
// Note: A subsequence is a sequence that can be derived from another sequence by deleting some elements without changing the order of the remaining elements.

class Solution {
    public boolean isSubSeq(String s1, String s2) {
        int i = 0, j = 0;
        
        while (i < s1.length() && j < s2.length()) {
            if (s1.charAt(i) == s2.charAt(j)) {
                i++; // match found, move s1 pointer
            }
            j++; // always move s2 pointer
        }
        
        return i == s1.length();
    }
}
