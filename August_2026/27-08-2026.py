# Largest Rectangle with Column Swaps
# Difficulty: HardAccuracy: 62.88%Submissions: 8K+Points: 8
# Given a binary matrix mat[][] of size n × m containing only 0s and 1s, any pair of columns may be swapped any number of times. Return the maximum area of a rectangle consisting entirely of 1's that can be formed after performing the column swaps.

# Examples:

# Input: mat[][] = [[0, 1, 0, 1, 0], [0, 1, 0, 1, 1], [1, 1, 0, 1, 0]]
# Output: 6
# Explanation: After swapping the 2nd and 3rd columns, the largest rectangle of 1s has an area of 6.
 
# Input: mat[][] = [[0, 1, 1, 0, 0], [1, 1, 1, 0, 1], [1, 1, 1, 0, 1], [1, 1, 1, 1, 1]]
# Output: 12
# Explanation: After swapping the 4th and 5th columns, the largest rectangle of 1s has an area of 12.

# Constraints:

# 1 ≤ n, m ≤ 103
# 0 ≤ mat[i][j] ≤ 1
# mat.rows = n
# mat.cols = m


class Solution:
    def maxArea(self, mat: list[list[int]]) -> int:
        n = len(mat[0])
        heights = [0] * n
        max_area = 0
        for row in mat:
            for i in range(n):
                heights[i] = heights[i] + 1 if row[i] else 0
            sheights = sorted(filter(None, heights), reverse=True)
            for j in range(len(sheights)):
                max_area = max(max_area, sheights[j] * (j + 1))
        return max_area