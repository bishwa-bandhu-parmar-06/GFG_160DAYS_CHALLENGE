// Sequences where Adjacent Divide
// Difficulty: MediumAccuracy: 69.24%Submissions: 8K+Points: 4
// Given two positive integer n and m. Find the number of arrays of size n that can be formed such that:

// Each element is in the range [1, m].
// All adjacent are such that one of them divide the another i.e element Ai divides Ai + 1 or Ai+1 divides Ai.
// Examples:

// Input: n = 3, m = 3
// Output : 17
// Explanation: The possible arrays are [1, 1, 1], [1, 1, 2], [1, 1, 3], [1, 2, 1], [1, 2, 2], [1, 3, 1], [1, 3, 3], [2, 1, 1], [2, 1, 2], [2, 1, 3], [2, 2, 1], [2, 2, 2], [3, 1, 1], [3, 1, 2], [3, 1, 3], [3, 3, 1] and [3, 3, 3].
// Input: n = 1, m = 10 
// Output: 10
// Explanation: The possible arrays are [1], [2], [3], [4], [5], [6], [7], [8], [9] and [10].

// Constraints:

// 1 ≤ n ≤ 11
// 1 ≤ m ≤ 11



class Solution:
    def count(self, n: int, m: int) -> int:
        # code here
        dp = [[0 for _ in range(m + 1)] for _ in range(n + 1)]
        
        for i in range(1, m + 1):
            dp[1][i] = 1
            
        for i in range(2, n + 1):
            for j in range(1, m + 1):
                for k in range(1, m + 1):
                    if j % k == 0 or k % j == 0:
                        dp[i][j] += dp[i - 1][k]
                        
        return sum(dp[n][1:m + 1])