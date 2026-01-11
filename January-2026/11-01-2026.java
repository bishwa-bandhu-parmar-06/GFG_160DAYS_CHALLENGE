// Minimum Window Subsequence
// Difficulty: MediumAccuracy: 49.43%Submissions: 23K+Points: 4Average Time: 45m
// You are given two strings, s1 and s2. Your task is to find the smallest substring in s1 such that s2 appears as a subsequence within that substring.

// The characters of s2 must appear in the same sequence within the substring of s1.
// If there are multiple valid substrings of the same minimum length, return the one that appears first in s1.
// If no such substring exists, return an empty string.
// Note: Both the strings contain only lowercase english letters.


class Solution {
    public String minWindow(String s1, String s2) {
        // code here
        String smallest=s1+'*';
        int n=s1.length();
        int m=s2.length();
        
        for(int i=0;i<n;i++)
        {
            int p1=i;
            int p2=0;
            
            while(p1<n && p2<m)
            {
                if(s1.charAt(p1)==s2.charAt(p2))
                {
                    p1++;
                    p2++;
                }
                else p1++;
            }
            
            if(p2==m)
            {
                
                
                if(p1-i<smallest.length())
                {
                    smallest=s1.substring(i,p1);
                }
            }
        }
        if(smallest.equals(s1+'*'))return "";
        return smallest;
    }
}