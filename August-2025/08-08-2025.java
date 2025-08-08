// Longest Prefix Suffix
// Difficulty: HardAccuracy: 27.91%Submissions: 157K+Points: 8
// Given a string s, of lowercase english alphabets, find the length of the longest proper prefix which is also a suffix.
// Note: Prefix and suffix can be overlapping but they should not be equal to the entire string.

// Examples :

class Solution {
    static int getLPSLength(String s) {
        // code here
         int n = s.length();
        int[] lps = new int[n];  // Longest Prefix Suffix table
        int len = 0; // length of the previous longest prefix suffix
        int i = 1;

        while (i < n) {
            if (s.charAt(i) == s.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = lps[len - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }

        return lps[n - 1];  // Last value of lps array is the answer
    }

   // public static void main(String[] args) {
        //System.out.println(longestPrefixSuffix("abab"));        // Output: 2
        //System.out.println(longestPrefixSuffix("aabcdaabc"));   // Output: 4
        //System.out.println(longestPrefixSuffix("aaaa"));        // Output: 3
    //}
}