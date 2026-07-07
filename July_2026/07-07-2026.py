# Largest Unblocked Submatrix
# Difficulty: MediumAccuracy: 52.99%Submissions: 16K+Points: 4
# You are given integers n and m, and an array arr[][] of size k, where arr[i] = [r, c] represents a blocked cell in an n × m grid.

# Each blocked cell blocks its entire row and column. Find the largest continuous unblocked area in the grid.

# Note: No two blocked cells are in the same row or the same column.

# Examples:

# Input: n = 2, m = 2, k = 1, arr[][] = [[2, 2]]
# Output: 1
# Explanation: Since only (1,1) cell is free from the enemy hence answer is 1.
# Input: n = 3, m = 3, k = 1, arr[][] = [[3, 3]]
# Output: 4
# Explanation: The cells (1,1), (1,2), (2,1) and (2,2) are free hence answer is 4.
# Constraints:
# 1 ≤ n, m ≤ 104



class Solution:
    def largestArea(self, n, m, k, arr):
        from itertools import pairwise
        rows = [row for row, _ in arr]
        rows.extend([0, n + 1])
        rows.sort()
        cols = [col for _, col in arr]
        cols.extend([0, m + 1])
        cols.sort()
        max_row_gap = max(b - a - 1 for a, b in pairwise(rows))
        max_col_gap = max(b - a - 1 for a, b in pairwise(cols))
        return max_row_gap * max_col_gap
        