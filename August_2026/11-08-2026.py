# Largest Odd Squares with Limited 1s
# Difficulty: MediumAccuracy: 47.75%Submissions: 10K+Points: 4Average Time: 20m
# Given a binary matrix mat[][] of size n*m and an integer k, process a list of queries queries[][]. Each query contains coordinates [i, j] of the center of a square.

# For every query, find the side length of the largest odd-sized square centered at cell (i, j) such that the square contains at most k ones.
#  A square centered at (i, j) expands outward symmetrically in all four directions by the same number of cells, so its side length is always odd.
# Examples:

# Input: mat[][] = [[1, 0, 1, 0, 0], [1, 0, 1, 1, 1], [1, 1, 1, 1, 1], [1, 0, 0, 1, 0]], queries[][] = [[1, 2]], k = 9
# Output: [3]
# Explanation: The largest odd-sized square centered at (1, 2) is the 3 × 3 square spanning rows 0 to 2 and columns 1 to 3. 
# It contains 6 ones, which is at most k = 9. Hence, the answer is 3.
# Input: mat[][] = [[1, 1, 1], [1, 1, 1], [1, 1, 1]], queries[][] = [[1, 1], [2, 2]], K = 9
# Output: [3, 1]
# Explanation: For query (1, 1), the largest valid square is the entire 3 × 3 matrix, which contains 9 ones. Hence, the answer is 3.
# For query (2, 2), no expansion is possible without going outside the matrix, so only the 1 × 1 square centered at (2, 2) is valid. Hence, the answer is 1.
# Constraints:
# 1 ≤ mat.size(), mat[0].size() ≤ 500
# 1 ≤ queries.size() ≤ 104
# 0 ≤ queries[q][0] < mat.size()
# 0 ≤ queries[q][1] < mat[0].size()
# 0 ≤ k ≤ mat.size() * mat[0].size()



class Solution:
    def largestSquare(self, mat: list[list[int]], queries: list[list[int]], k: int) -> list[int]:
        n = len(mat)
        m = len(mat[0])
        
        # 1. Build 2D Prefix Sum Matrix
        pref = [[0] * (m + 1) for _ in range(n + 1)]
        for i in range(n):
            for j in range(m):
                pref[i + 1][j + 1] = mat[i][j] + pref[i][j + 1] + pref[i + 1][j] - pref[i][j]
                
        def get_sum(r1, c1, r2, c2):
            return pref[r2 + 1][c2 + 1] - pref[r1][c2 + 1] - pref[r2 + 1][c1] + pref[r1][c1]
        
        ans = []
        
        # 2. Process each query using Binary Search
        for r, c in queries:
            # Check if even the center cell itself violates the limit 'k'
            if mat[r][c] > k:
                ans.append(-1)
                continue
            
            # Maximum allowed radius such that square stays within matrix boundaries
            max_d = min(r, n - 1 - r, c, m - 1 - c)
            
            low, high = 0, max_d
            best_d = 0
            
            while low <= high:
                mid = (low + high) // 2
                
                # Check sum of 1s in square centered at (r, c) with radius `mid`
                ones_count = get_sum(r - mid, c - mid, r + mid, c + mid)
                
                if ones_count <= k:
                    best_d = mid
                    low = mid + 1  # Try expanding further
                else:
                    high = mid - 1 # Reduce square size
            
            # Side length = 2 * radius + 1
            ans.append(2 * best_d + 1)
            
        return ans

