// Strings Rotations of Each Other
// Difficulty: MediumAccuracy: 43.83%Submissions: 330K+Points: 4Average Time: 15m
// You are given two strings s1 and s2, of equal lengths. The task is to check if s2 is a rotated version of the string s1.

// Note: A string is a rotation of another if it can be formed by moving characters from the start to the end (or vice versa) without rearranging them.


class Solution {
    public boolean areRotations(String s1, String s2) {
        // code here 
         if(s1.length() != s2.length()) return false;
        s1=s1+s1;
        return s1.lastIndexOf(s2)>=0;
    }  
}