// Minimum Deletions
// Difficulty: MediumAccuracy: 58.8%Submissions: 62K+Points: 4
// Given a string s, write a program to delete the minimum number of characters from the string so that the resultant string is a palindrome, while maintaining the order of characters.

class Solution {
    static int minDeletions(String s) {
        int n = s.length();
        return n - lcs(s, new StringBuilder(s).reverse().toString(), n);
    }
    
    static int lcs(String s1, String s2, int n) {
        int lcs[][] = new int[n + 1][n + 1];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (s1.charAt(i) == s2.charAt(j)) {
                    lcs[i + 1][j + 1] = lcs[i][j] + 1;
                } else {
                    lcs[i + 1][j + 1] = Math.max(lcs[i][j + 1], lcs[i + 1][j]);
                }
            }
        }
        
        return lcs[n][n];
    }
}