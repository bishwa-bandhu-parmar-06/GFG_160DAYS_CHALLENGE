// Word Break
// Difficulty: MediumAccuracy: 40.86%Submissions: 135K+Points: 4
// You are given a string s and a list dictionary[] of words. Your task is to determine whether the string s can be formed by concatenating one or more words from the dictionary[].

// Note: From dictionary[], any word can be taken any number of times and in any order.






class Solution {
    public boolean wordBreak(String s, String[] dictionary) {
        Set<String> wordSet = new HashSet<>(Arrays.asList(dictionary));
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;

        int maxWordLen = 0;
        for (String word : dictionary) {
            maxWordLen = Math.max(maxWordLen, word.length()); // Find max word length
        }

        for (int i = 1; i <= n; i++) {
            for (int j = Math.max(0, i - maxWordLen); j < i; j++) {
                if (dp[j] && wordSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break; // Stop early once a valid break is found
                }
            }
        }

        return dp[n];
    }
}
