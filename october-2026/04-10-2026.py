# Perimeter of Shapes in Binary Matrix
# Difficulty: EasyAccuracy: 61.53%Submissions: 2K+Points: 2
# Given a binary matrix mat[][] of size n × m, where each cell contains either 0 or 1, find the total perimeter of all figures formed by cells containing 1s. Two cells are considered adjacent if they share a common side.

# A single cell containing 1 has a perimeter of 4, whereas two adjacent cells containing 1 (i.e., 11) together have a perimeter of 6.

 

# Examples :

# Input: mat[][] = [[0,1,0,0,0], [1,1,1,0,0], [1,0,0,0,0]]
# Output: 12
# Explanation: The five cells form a single figure. Hence, the perimeter of the figure is 12.     

# Input: mat[][] = [[1,0], [1,1]]
# Output: 8
# Explanation: The two adjacent cells share one common side. Hence, the perimeter of the figure is 6.  

# Constraints:

# 1 ≤ n, m ≤ 1000



from typing import List

class Solution:
    def findPerimeter(self, mat: List[List[int]]) -> int:
        n = len(mat)
        if n == 0:
            return 0
        m = len(mat[0])
        
        perimeter = 0
        for i in range(n):
            row = mat[i]
            for j in range(m):
                if row[j] == 1:
                    perimeter += 4
                    # shared side with the cell below
                    if i + 1 < n and mat[i + 1][j] == 1:
                        perimeter -= 2
                    # shared side with the cell to the right
                    if j + 1 < m and row[j + 1] == 1:
                        perimeter -= 2
        return perimeter