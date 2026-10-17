# Convert One String to Another with Constraints
# Difficulty: EasyAccuracy: 49.91%Submissions: 27K+Points: 2
# Given two strings s1 and s2, consisting only of the characters 'A', 'B', and '#'. Determine whether s1 can be transformed into s2 by performing the following operations on s1:

# 'A' can move only towards the left. 
# 'B' can move only towards the right.
# Neither 'A' nor 'B' can cross each other.
# '#' represents an empty position through which 'A' and 'B' can move.
# Moving the character at index i one step to the left means swapping it with the character at index i - 1, provided i - 1 >= 0. Similarly, moving it one step to the right means swapping it with the character at index i + 1, provided i + 1 < s1.length().

# Return true if s1 can be transformed into s2; otherwise, return false.

# Examples:

# Input: s1 = #A#B#B#, s2 = A###B#B
# Output: true
# Explanation: The character 'A' in s1 can move one position towards the left to reach its position in s2, as there are no 'B' characters blocking its movement. Similarly, each 'B' can move towards the right to reach its corresponding position in s2 without crossing any other 'A' or 'B'. Therefore, s1 can be transformed into s2, so the answer is true.
# Input: s1 = #A#B#, s2 = #B#A#
# Output: false
# Explanation: The character 'A' in s1 is at index 1, whereas the corresponding 'A' in s2 is at index 3. Since 'A' can move only towards the left, it cannot reach a position to the right of its current position. Therefore, s1 cannot be transformed into s2, and hence, the answer is false.
# Constraints:

# 1 ≤ s1.size(), s2.size() ≤ 105


class Solution:
    # simple python solution 
        def isItPossible(self, s1: str, s2: str) -> bool:
            # code here
            if len(s1)!=len(s2):
                return False
            n=len(s1)
            a,b=0,0
            for i in range(n):
                if s1[i]=='A':
                    a+=1
                elif s1[i]=='B':
                    b+=1
                if s2[i]=='A':
                    a-=1
                elif s2[i]=='B':
                    b-=1
                if a>0 or b<0 or a*b<0:return False 
            return True