// Longest Substring with K Uniques
// Difficulty: MediumAccuracy: 34.65%Submissions: 271K+Points: 4
// You are given a string s consisting only lowercase alphabets and an integer k. Your task is to find the length of the longest substring that contains exactly k distinct characters.

// Note : If no such substring exists, return -1. 


class Solution {
    public int longestKSubstr(String s, int k) {
        // code here
        HashMap<Character , Integer> map = new HashMap<>();
        int n = s.length();
        int i = 0;
        int j = 0;
        int maxLen = -1;
        
        while(j < n){
            char ch_j = s.charAt(j);
            map.put(ch_j , map.getOrDefault(ch_j , 0) + 1);
            while(map.size() > k){
                char ch_i = s.charAt(i);
                map.put(ch_i , map.getOrDefault(ch_i , 0) - 1);
                if(map.get(ch_i) <= 0){
                    map.remove(ch_i);
                }
                i++;
            }
            if(map.size() == k){
                maxLen = Math.max(maxLen , (j - i + 1));
            }
            j++;
        }
        return maxLen;
    }
}