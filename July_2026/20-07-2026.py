# Shortest Unique Prefix for Every Word
# Difficulty: HardAccuracy: 50.02%Submissions: 22K+Points: 8Average Time: 30m
# Given an array of strings arr[ ], find the shortest prefix of each string that uniquely identifies it among all strings in the array. A prefix is unique if it is not a prefix of any other string in the array.

# Note: No string in the given array is a prefix of another string.

# Examples :

# Input: arr[] = {"zebra", "dog", "duck", "dove"}
# Output: z dog du dov
# Explanation: z => zebra, dog => dog, duck => du, dove => dov 
# Input: arr[] = {"geeksgeeks", "geeksquiz", "geeksforgeeks"}
# Output: geeksg geeksq geeksf
# Explanation: geeksgeeks => geeksg, geeksquiz => geeksq, geeksforgeeks => geeksf
# Constraints:
# 1 ≤ length of arr, length of each word ≤ 1000



class Solution:
    def findPrefixes(self, arr):
        root = {"count": len(arr)}
        for word in arr:
            trie = root
            for c in word:
                if c in trie:
                    trie = trie[c]
                    trie["count"] += 1
                else:
                    trie[c] = trie = {"count": 1}
        answers = []
        for word in arr:
            trie = root
            for i in range(len(word)):
                trie = trie[word[i]]
                if trie["count"] == 1:
                    answers.append(word[:i + 1])
                    break
            else:
                answers.append(word)
        return answers 