# Largest Zigzag Sequence
# Difficulty: EasyAccuracy: 42.24%Submissions: 8K+Points: 2Average Time: 20m
# Given a square matrix mat[][] of size n × n. A zigzag sequence starts from the top and ends at the bottom. Two consecutive elements of sequence cannot belong to the same column.

# Return the maximum sum of such a zigzag sequence.

# Examples:

# Input: mat[][] = [[3, 1, 2], [4, 8, 5], [6, 9, 7]]
# Output: 18
# Explanation:

# One optimal zigzag sequence is: 3 -> 8 -> 7, where the sum = 3 + 8 + 7 = 18.
# Input: mat[][] = [[1, 2, 4], [3, 9, 6], [11, 3, 15]]
# Output: 28
# Explanation:

# One optimal zigzag sequence is: 4 -> 9 -> 15, where the sum = 4 + 9 + 15 = 28.
# Constraints:
# 1 ≤ n ≤ 100
# 1 ≤ mat[i][j] ≤ 1000 



class Solution:
    def zigzagSequence(self, mat):
        # code here
        n = len(mat)
        for i in range(1, n):
            # Find top two values and their indices in the previous row
            row = mat[i - 1]
            # Get index of max element
            first_i = max(range(n), key=row.__getitem__)
            first = row[first_i]
            # Get second largest by checking all except first_i
            second = max((row[j] for j in range(n) if j != first_i), default=0)

            # Update current row
            for j in range(n):
                mat[i][j] += first if j != first_i else second

        return max(mat[-1])