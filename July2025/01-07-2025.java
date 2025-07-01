// Substrings of length k with k-1 distinct elements
// Difficulty: MediumAccuracy: 57.85%Submissions: 25K+Points: 4Average Time: 15m
// Given a string s consisting only lowercase alphabets and an integer k. Find the count of all substrings of length k which have exactly k-1 distinct characters.



class Solution {
    public int substrCount(String s, int k) {
        if (s.length() < k) return 0;
        
        int count = 0;

        for (int i = 0; i <= s.length() - k; i++) {
            String sub = s.substring(i, i + k);
            HashMap<Character, Integer> map = new HashMap<>();

            for (char c : sub.toCharArray()) {
                map.put(c, map.getOrDefault(c, 0) + 1);
            }

            if (map.size() == k - 1) {
                count++;
            }
        }

        return count;
    }
}