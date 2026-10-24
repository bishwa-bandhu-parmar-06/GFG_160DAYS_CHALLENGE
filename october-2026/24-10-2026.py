# Trace Path
# Difficulty: EasyAccuracy: 50.66%Submissions: 36K+Points: 2Average Time: 10m
# Given a rectangular grid with n rows and m columns, and a string s representing a sequence of movement commands. Geek can start from any cell of the grid and follows all the commands in s in the same order.

# The string s consists only of the characters L, R, D, and U, where:

# L: Move one cell left, from (i, j) to (i, j - 1).
# R: Move one cell right, from (i, j) to (i, j + 1).
# D: Move one cell up, from (i, j) to (i - 1, j).
# U: Move one cell down, from (i, j) to (i + 1, j).
# Determine whether there exists at least one starting cell such that Geek remains within the grid while following all the commands in s.

# Examples:

# Input: n = 1, m = 1, s = "R"
# Output: false
# Explanation: There is only one cell(1, 1). So Geek can only start from (1, 1). On taking right(R) Geek moves to (1, 2), which is out of grid. Therefore, there is no cell from where Geek can start and remain inside the grid after tracing the route. 
# Input: n = 2, m = 3, s = "LLRU"
# Output: true
# Explanation: One possible cell is (1, 3). (1, 3) -> (1, 2) -> (1, 1) -> (1, 2) -> (2, 2). Thus, there is a cell from where if Geek starts, it remains inside the grid throughout tracing the route.
# frame_3972
# Constraints:

# 1 ≤ n, m, s.size() ≤ 104
# s consists only of the characters L R D and U.


class Solution:
    def isPossible(self, n: int, m: int, s: str) -> bool:
        # code here
        mx_r = 0
        mn_r = 0
        mx_c = 0
        mn_c = 0
        
        curr_x = 0
        curr_y = 0
        for i in s:
            if i == 'L':
                curr_y -= 1
            elif i == 'R':
                curr_y += 1
            elif i == 'D':
                curr_x -= 1
            else:
                curr_x += 1
                
            mx_r = max(mx_r, curr_x)
            mn_r = min(mn_r, curr_x)
            mx_c = max(mx_c, curr_y)
            mn_c = min(mn_c, curr_y)
            
        pn = mx_r - mn_r + 1
        pm = mx_c - mn_c + 1
        
        return pn <= n and pm <= m