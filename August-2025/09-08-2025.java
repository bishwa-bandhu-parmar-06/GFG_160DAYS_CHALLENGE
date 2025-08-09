// Longest Periodic Proper Prefix
// Difficulty: HardAccuracy: 43.66%Submissions: 9K+Points: 8
// Given a string s, find the length of longest periodic proper prefix of s. If no such prefix exists, return -1.
// A periodic proper prefix is a non empty prefix of s (but not the whole string), such that repeating this prefix enough times produces a string that starts with s.


class Solution {
    int getLongestPrefix(String s) {
        int n = s.length();
        int i=0;
        int j=n-1;
        int pos = n-1;
        int ans = 0;
        while(j<n && pos>0){
            if(s.charAt(i)==s.charAt(j)){
                i++;
                j++;
                ans++;
            }
            else{
                i=0;
                pos--;
                j=pos;
                ans = 0;
            }
        }
        if(pos==0) return -1;
        return n-ans;
    }
}