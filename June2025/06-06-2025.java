// Search Pattern (Rabin-Karp Algorithm)
// Difficulty: MediumAccuracy: 34.53%Submissions: 81K+Points: 4Average Time: 20m
// Given two strings:

// A text string in which you want to search.

// A pattern string that you are looking for within the text.

// Return all positions (1-based indexing) where the pattern occurs as a substring in the text. If the pattern does not occur, return an empty list.

// All characters in both strings are lowercase English letters (a to z).



class Solution {
    
    ArrayList<Integer> search(String pattern, String text) {
        ArrayList<Integer> ls = new ArrayList<>();
        int m = pattern.length();
        int n = text.length();

        int[] lps = computeLPSArray(pattern); // Preprocess pattern
        
        int i = 0; // index for text
        int j = 0; // index for pattern

        while (i < n) {
            if (pattern.charAt(j) == text.charAt(i)) {
                i++;
                j++;
            }

            if (j == m) {
                ls.add(i - j + 1); // match found, 1-based index
                j = lps[j - 1];    // continue searching
            } else if (i < n && pattern.charAt(j) != text.charAt(i)) {
                if (j != 0) {
                    j = lps[j - 1]; // use lps to skip characters
                } else {
                    i++;
                }
            }
        }
        return ls;
    }

    private int[] computeLPSArray(String pattern) {
        int m = pattern.length();
        int[] lps = new int[m];
        int len = 0; // length of the previous longest prefix suffix
        int i = 1;

        while (i < m) {
            if (pattern.charAt(i) == pattern.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = lps[len - 1]; // fallback
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return lps;
    }
}
