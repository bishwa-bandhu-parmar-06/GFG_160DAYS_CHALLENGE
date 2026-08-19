# Secret Cipher
# Difficulty: HardAccuracy: 49.98%Submissions: 16K+Points: 8Average Time: 30m
# Geek wants to send a secret message to his friend Keeg. Instead of sending the original message directly, he encrypts it by inserting the character '*'.

# Keeg decodes the message as follows:

# Traverse the encoded string from left to right and initialize the original string as empty.
# Whenever a normal character appears, append it to the current original string.
# Whenever '*' is encountered, remove it and append all characters before it to the end of the current original string.
# Repeat until no '*' remains.

# Given the original string s, find the shortest encrypted string that decodes to s. If multiple encrypted strings have the same minimum length, return the lexicographically smallest encrypted string among them.

# Examples :

# Input: s = "ababcababcd"
# Output: ab*c*d
# Explanation: We can encrypt the string in following way : "ababcababcd" -> "ababc*d" -> "ab*c*d"
# Input: s = "zzzzzzz"
# Output: z*z*z
# Explanation: The string can be encrypted in 2 ways: "z*z*z" and "z**zzz". Out of the two "z*z*z" is smaller in length.
# Constraints:

# 1 ≤ s.size() ≤ 105



#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    string compress(string s) {
        int n = s.length();
        if (n == 0) return "";

        // Compute KMP prefix function array
        vector<int> pi(n, 0);
        for (int i = 1; i < n; i++) {
            int j = pi[i - 1];
            while (j > 0 && s[i] != s[j]) {
                j = pi[j - 1];
            }
            if (s[i] == s[j]) {
                j++;
            }
            pi[i] = j;
        }

        string result = "";
        int i = n - 1;

        while (i >= 0) {
            int len = i + 1;

            // If prefix s[0...i] has an even length, check if first half matches second half
            if (len % 2 == 0) {
                int half = len / 2;
                int k = pi[i];
                while (k > half) {
                    k = pi[k - 1];
                }

                if (k == half) {
                    result += '*';
                    i = half - 1;
                    continue;
                }
            }

            result += s[i];
            i--;
        }

        reverse(result.begin(), result.end());
        return result;
    }
};

