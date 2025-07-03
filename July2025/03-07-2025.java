// Longest Substring with K Uniques
// Difficulty: MediumAccuracy: 34.65%Submissions: 206K+Points: 4
// You are given a string s consisting only lowercase alphabets and an integer k. Your task is to find the length of the longest substring that contains exactly k distinct characters.

// Note : If no such substring exists, return -1. 


class Solution {
    public int longestKSubstr(String s, int k) {
        if (s == null || s.length() == 0 || k == 0) {
            return -1;
        }

        HashMap<Character, Integer> map = new HashMap<>();
        int left = 0, maxLen = -1;

        for (int right = 0; right < s.length(); right++) {
            char currentChar = s.charAt(right);
            map.put(currentChar, map.getOrDefault(currentChar, 0) + 1);

            while (map.size() > k) {
                char leftChar = s.charAt(left);
                map.put(leftChar, map.get(leftChar) - 1);
                if (map.get(leftChar) == 0) {
                    map.remove(leftChar);
                }
                left++;
            }

            if (map.size() == k) {
                maxLen = Math.max(maxLen, right - left + 1);
            }
        }

        return maxLen;
    }
}