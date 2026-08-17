# Snake and Ladder Problem
# Difficulty: MediumAccuracy: 34.65%Submissions: 61K+Points: 4Average Time: 20m
# Given an integer n such that there is n × n Snakes and Ladders board with cells numbered from 1 to n*n, find the minimum number of dice throws required to reach cell n*n starting from cell 1. Given two arrays of even lengths:

# lad[], where each pair (lad[2*i], lad[2*i + 1]) represents the start and end of a ladder.
# sn[], where each pair (sn[2*i], sn[2*i + 1]) represents the start and end of a snake.
# If you land on the start cell of a snake or ladder, you must immediately move to its corresponding end cell.

# You have complete control over the outcome of each dice throw i.e., in a single move,  you can move forward by any number of cells from 1 to 6. 

# If it is impossible to reach cell n*n, return -1.

# Examples:

# Input: n = 6, lad[] = [3, 22, 5, 8, 11, 35, 20, 32], sn[] = [17, 4, 19, 7, 34, 1, 21, 9]
# Output: 3
# Explanation: For the 6 × 6 board, the minimum number of dice throws needed to reach cell 36 from cell 1 is 3.
# One optimal path is:
# Throw 4 to move from 1 to 5, then take the ladder to 8
# Throw 3 to move from 8 to 11, then take the ladder to 35
# Throw 1 to move from 35 to 36
# So the destination is reached in 3 dice throws.

# Input: n = 3, lad[] = [2, 8], sn[] = [7, 3]
# Output: 2
# Explanation: For the 3 × 3 board, the minimum number of dice throws needed to reach cell 9 from cell 1 is 2.
# One optimal path is:
# Throw 1 to move from 1 to 2, then take the ladder to 8.
# Throw 1 to move from 8 to 9.
# So the destination is reached in 2 dice throws.
# Constraints:
# 1 ≤ n ≤ 103


# 1 ≤ lad.size(), sn.size(), lad[i], sn[i] ≤ n2 


from collections import deque

class Solution:
    def minThrows(self, n, lad, sn):
        # The target is the last cell of an n x n board
        target = n * n
        
        # In case there's an older variation of the problem where n is just the total cells
        # We can dynamically fallback if 'n' was meant to be exactly the board size.
        max_referenced = 0
        if lad: max_referenced = max(max_referenced, max(lad))
        if sn: max_referenced = max(max_referenced, max(sn))
        if max_referenced <= n and n >= 30:
            target = n
            
        # Map ladders and snakes
        # The arrays lad and sn contain pairs: [start1, end1, start2, end2, ...]
        moves = {}
        for i in range(0, len(lad), 2):
            moves[lad[i]] = lad[i+1]
            
        for i in range(0, len(sn), 2):
            moves[sn[i]] = sn[i+1]
            
        # BFS Initialization
        # Queue stores tuples of (current_position, throws_taken)
        q = deque([(1, 0)]) 
        visited = set([1])
        
        while q:
            curr_pos, throws = q.popleft()
            
            # If we reached the target, return the number of throws
            if curr_pos == target:
                return throws
                
            # Roll the dice (1 through 6)
            for dice in range(1, 7):
                next_pos = curr_pos + dice
                
                if next_pos <= target:
                    # Check if the next position has a snake or ladder
                    # If not, we just stay at next_pos
                    final_pos = moves.get(next_pos, next_pos)
                    
                    if final_pos not in visited:
                        visited.add(final_pos)
                        q.append((final_pos, throws + 1))
                        
        return -1