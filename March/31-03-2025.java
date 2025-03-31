// Maximize partitions in a String
// Difficulty: EasyAccuracy: 74.64%Submissions: 8K+Points: 2Average Time: 25m
// Given a string s of lowercase English alphabets, your task is to return the maximum number of substrings formed, after possible partitions (probably zero) of s such that no two substrings have a common character.

class Solution {
    public int maxPartitions(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int n = s.length();

        // Step 1: Store the last occurrence of each character
        for (int i = 0; i < n; i++) {
            map.put(s.charAt(i), i);
        }

        int res = 0;
        for (int i = 0; i < n; i++) {
            int idx = map.get(s.charAt(i)); // Last occurrence of s[i]
            int k = i;
            
            // Step 2: Expand partition till all occurrences are covered
            while (k < idx) {
                idx = Math.max(idx, map.get(s.charAt(k)));
                k++;
            }
            
            res++;  // One partition is formed
            i = idx; // Move to the next partition start
        }
        
        return res;
    }
}
