# Coils in a Matrix
# Solved
# Difficulty: MediumAccuracy: 75.17%Submissions: 5K+Points: 4Average Time: 20m
# Given a positive integer n, consider a 4n * 4n matrix filled with integers from 1 to (4n) * (4n) in row-major order (left to right, top to bottom). Form two coils from the matrix:

# The first coil starts from the top-left cell (0, 0) and spirals inward.
# The second coil starts from the bottom-right cell (4n - 1, 4n - 1) and spirals inward in the opposite direction.
# Return these two coils in the same order.

# Examples:

# Input: n = 1
# Output: [[1, 5, 9, 13, 14, 15, 11, 7], [16, 12, 8, 4, 3, 2, 6, 10]] 
# Explanation: The matrix is 
 
# So, the two coils are as given in the Output.
# Input: n = 2
# Output:
# [[1, 9, 17, 25, 33, 41, 49, 57, 58, 59, 60, 61, 62, 63, 55, 47, 39, 31, 23, 15, 14, 13, 12, 11, 19, 27, 35, 43, 44, 45, 37, 29], 
#  [64, 56, 48, 40, 32, 24, 16, 8, 7, 6, 5, 4, 3, 2, 10, 18, 26, 34, 42, 50, 51, 52, 53, 54, 46, 38, 30, 22, 21, 20, 28, 36]]  
# Explanation:
 
# Constraints:

# 1 ≤ n ≤ 20


class Solution:
    def formCoils(self, n: int) -> list[list[int]]:
        # code here

        m = 4*n
        value = lambda r, c: r*m + c + 1
        dirs = [(1, 0), (0, 1), (-1, 0), (0, -1)]
        top, bottom = 0, m-1
        left, right = 0, m-1
        r0, c0, dir0 = -1, 0, 0
        r1, c1, dir1 = m, m-1, 2
        cnt = 0
        ret1, ret2 = [], []

        def walk(r, c, dir, ret):
            nonlocal top, bottom, left, right
            dr, dc = dirs[dir]
            cnt = 0
            match dir:
                case 0: 
                    while r + dr <= bottom:
                        r += dr
                        ret.append(value(r, c))
                        cnt += 1
                    left += 1
                case 1:
                    while c + dc <= right:
                        c += dc
                        ret.append(value(r, c))
                        cnt += 1
                    bottom -= 1
                case 2:
                    while r + dr >= top:
                        r += dr
                        ret.append(value(r, c))
                        cnt += 1
                    right -= 1
                case 3:
                    while c + dc >= left:
                        c += dc
                        ret.append(value(r, c))
                        cnt += 1
                    top += 1
            return r, c, (dir+1)%4, cnt
        cnt = 0
        while cnt < m*m:
            r0, c0, dir0, cnt0 = walk(r0, c0, dir0, ret1)
            cnt += cnt0
            r1, c1, dir1, cnt1 = walk(r1, c1, dir1, ret2)
            cnt += cnt1
        return [ret1, ret2]