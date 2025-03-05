// Longest String Chain
// Difficulty: MediumAccuracy: 50.0%Submissions: 15K+Points: 4Average Time: 20m
// You are given an array of words where each word consists of lowercase English letters.
// wordA is a predecessor of wordB if and only if we can insert exactly one letter anywhere in wordA without changing the order of the other characters to make it equal to wordB. For example, "abc" is a predecessor of "abac", while "cba" is not a predecessor of "bcad".

// A word chain is a sequence of words [word1, word2, ..., wordk] with k >= 1, where word1 is a predecessor of word2, word2 is a predecessor of word3, and so on. A single word is trivially a word chain with k = 1.

// Return the length of the longest possible word chain with words chosen from the given list of words in any order.

class Solution {
    public int longestStringChain(String words[]) {
        Arrays.sort(words, (a, b) -> a.length() - b.length()); // Sort words by length
        
        HashMap<String, Integer> dp = new HashMap<>();
        int maxLength = 1; // At least one word is a chain
        
        for (String word : words) {
            int best = 1; // Each word is a chain of length 1 initially
            
            for (int i = 0; i < word.length(); i++) {
                String prev = word.substring(0, i) + word.substring(i + 1); // Remove one character
                if (dp.containsKey(prev)) {
                    best = Math.max(best, dp.get(prev) + 1); // Extend chain
                }
            }
            
            dp.put(word, best);
            maxLength = Math.max(maxLength, best); // Update global max
        }
        
        return maxLength;
    }
}
