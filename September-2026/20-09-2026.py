# Largest Subsquare Surrounded by X
# Difficulty: MediumAccuracy: 50.31%Submissions: 45K+Points: 4
# Given a square matrix mat[][] of size n × n, where each cell contains either 'X' or 'O'. Find the size of the largest square submatrix whose boundary is completely surrounded by 'X'. The cells inside the submatrix can contain either 'X' or 'O'. Only the four sides of the submatrix must contain 'X'.

# Return side length of the largest such square submatrix.


# Note: A square of size 1 is valid if its only cell is 'X'. If no such square submatrix exists, return 0.

# Examples:

# Input: mat[][] = [[X,X,X,O],[X,O,X,X],[X,X,X,O],[X,O,X,X]]
 
# Output: 3
# Explanation: Here, the input represents following matrix of size 4 x 4
 
# The square submatrix starting at (0,0) and ending at (2,2) is the largest submatrix surrounded by X. Therefore, size of that matrix would be 3.
# Input: mat[][] = [[X,X],[X,X]]
 
# Output: 2
# Explanation: The largest square submatrix surrounded by X is the whole input matrix.
# Constraints:

# 1 ≤ n, mat.size(), mat[i].size() ≤ 1000


class Solution:
    def largestSubsquare(self, mat):
        n = len(mat)
        right = [[0] * n for _ in range(n)]
        down = [[0] * n for _ in range(n)]

        ans = 0

        for i in range(n - 1, -1, -1):
            for j in range(n - 1, -1, -1):
                if mat[i][j] == 'X':
                    right[i][j] = 1 + (right[i][j + 1] if j + 1 < n else 0)
                    down[i][j] = 1 + (down[i + 1][j] if i + 1 < n else 0)

        for i in range(n):
            for j in range(n):
                size = min(right[i][j], down[i][j])

                while size > ans:
                    if (right[i + size - 1][j] >= size and
                        down[i][j + size - 1] >= size):
                        ans = size
                        break
                    size -= 1

        return ans