// Min Chars to Add for Palindrome
// Difficulty: Hard     Accuracy: 46.79%      Submissions: 54K+     Points: 8
// Given a string s, the task is to find the minimum characters to be added at the front to make the string palindrome.

// Note: A palindrome string is a sequence of characters that reads the same forward and backward.


class Solution {
    public static int minChar(String s) {
        // Write your code here
        String rev = new StringBuilder(s).reverse().toString();
        String concat = s + "$" + rev;
        int[] lps = new int[concat.length()];
        int j = 0;
        for(int i = 1; i < concat.length(); i++){
            while(j > 0 && concat.charAt(i) != concat.charAt(j)){
                j = lps[j - 1];
            }
            if(concat.charAt(i) == concat.charAt(j)){
                j++;
            }
            lps[i] = j;
        }
        return s.length() - lps[concat.length() - 1];
    }
}