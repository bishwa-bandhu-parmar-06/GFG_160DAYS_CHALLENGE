# Range Vowel Count Queries
# Difficulty: MediumAccuracy: 84.58%Submissions: 705+Points: 4
# Given a string s and a 2D array queries[][], where each query consists of two integers l and r, find the number of vowels in the substring s[l....r] for each query. The substring includes both indices l and r.

# Return an array containing the answers to all queries in the order they are given.

# Examples:

# Input: s = "geeksforgeeks", queries[][] = [[1, 3], [2, 4], [1, 9]]
# Output: [2, 1, 4]
# Explanation:
# Query 1: "eek" has 2 vowels (e, e).
# Query 2: "eks" has 1 vowel (e).
# Query 3: "eeksforge" has 4 vowels (e, e, o, e).
# Input: s = "helloworld", queries[][] = [[0, 4], [5, 9], [0, 9]]
# Output: [2, 1, 3]
# Explanation:
# Query 1: "hello" has 2 vowels (e, o).
# Query 2: "world" has 1 vowel (o).
# Query 3: "helloworld" has 3 vowels (e, o, o).
# Constraints:

# 1 ≤ s.size(), queries.size() ≤ 105
# s consists only of lowercase English alphabets
# queries[i].size() = 2
# 0 ≤ queries[i][0] ≤ queries[i][1] < s.size()



class Solution:
    def countVowels(self, s: str, queries: list[list[int]]) -> list[int]:
        # code here
        n=len(s)
        ans=[]
        pref=[0]*(n+1)
        for i in range(n):
            k=0
            if s[i] in ('a','e','i','o','u'):
                k=1
            pref[i+1]=pref[i]+k
      
        
        for l,r in queries:
            ans.append(pref[r+1]-pref[l])
        return ans