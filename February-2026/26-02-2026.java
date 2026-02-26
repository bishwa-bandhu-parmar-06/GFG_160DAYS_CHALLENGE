// Isomorphic Strings
// Difficulty: EasyAccuracy: 34.21%Submissions: 228K+Points: 2Average Time: 30m
// Given two strings s1 and s2 consisting of only lowercase English letters and of equal length, check if these two strings are isomorphic to each other.
// If the characters in s1 can be changed to get s2, then two strings, s1 and s2 are isomorphic. A character must be completely swapped out for another character while maintaining the order of the characters. A character may map to itself, but no two characters may map to the same character.

// Examples:


class Solution {
     public boolean areIsomorphic(String s1, String s2) {
        // code here
        if(s1.length()!=s2.length()){
            return false;
        }
        HashMap<Character,Integer> hm1=new HashMap<Character,Integer>();
        HashMap<Character,Integer> hm2=new HashMap<Character,Integer>();
        int n=s1.length();
        for(int i=0;i<n;i++){
            char c1=s1.charAt(i);
            char c2=s2.charAt(i);
            hm1.putIfAbsent(c1,i);
            hm2.putIfAbsent(c2,i);
            if(!hm1.get(c1).equals(hm2.get(c2))){
                return false;
            }
        }
        return true;
    }
}