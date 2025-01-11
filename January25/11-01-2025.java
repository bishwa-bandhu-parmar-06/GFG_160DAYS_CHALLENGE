// Longest substring with distinct characters
// Difficulty: Easy       Accuracy: 31.32%    Submissions: 132K+       Points: 2
// Given a string s, find the length of the longest substring with all distinct characters.


class Solution {
    public int longestUniqueSubstr(String s) {
        int freq[] = new int[26];
        int n = s.length(),i = 0,j = 0,max = 0;
        while(j<n){
            freq[s.charAt(j)-'a']++;
            while(i<j && freq[s.charAt(j)-'a']>1){
                freq[s.charAt(i)-'a']--;
                i++;
            }
            max = Math.max(max,j-i+1);
            j++;
        }
        return max;
    }
}