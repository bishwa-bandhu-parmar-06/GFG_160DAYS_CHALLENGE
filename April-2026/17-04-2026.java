// Anagram Palindrome
// Difficulty: BasicAccuracy: 44.28%Submissions: 46K+Points: 1
// Given a string s, determine whether its characters can be rearranged to form a palindrome. Return true if it is possible to rearrange the string into a palindrome; otherwise, return false.

// Examples

// Input: s = "baba"
// Output: true
// Explanation: Can be rearranged to form a palindrome "abba" 
// Input: s = "geeksogeeks"
// Output: true
// Explanation: The characters of the string can be rearranged to form the palindrome "geeksoskeeg".
// Input: s = "geeksforgeeks"
// Output: false
// Explanation: The given string can't be converted into a palindrome.
// Constraints:
// 1 ≤ s.length ≤ 106
// s consists of only lowercase English letters.


class Solution {
    boolean canFormPalindrome(String s) {
        // code here
        int n=s.length();
        int a[]=new int[26];
        int o=0;
        for(char x:s.toCharArray()){
            a[x-'a']++;
            if(a[x-'a']%2!=0)
                o++;
            else
                o--;
        }
        if(n%2!=0 && o==1 || n%2==0 && o==0)
            return true;
        return false;
    }
}