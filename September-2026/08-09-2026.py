# Word in Grid - All Occurrences
# Difficulty: MediumAccuracy: 22.88%Submissions: 90K+Points: 4Average Time: 15m
# Given a 2D grid mat[][] of size n × m consisting of characters and a string word, find all starting positions where the word occurs in the grid.

# The word can be formed from any cell by moving in any of the 8 directions (2 horizontal, 2 vertical, and 4 diagonal) in a straight line without changing direction.
# Each cell can be used at most once per occurrence.
# Return all unique starting coordinates in lexicographically smallest order.
# Examples :

# Input: mat[][] = {{a,b,a,b},{a,b,e,b},{e,b,e,b}}, word = "abe"
# Output: {{0,0}, {0,2}, {1,0}}
# Explanation: From (0,0) we can find "abe" in right-down diagonal. From (0,2) we can find "abe" in left-down diagonal. From (1,0) we can find "abe" in horizontally right direction.

# Input: mat[][] = {{G,E,E,K,S,F,O,R,G,E,E,K,S}, {G,E,E,K,S,Q,U,I,Z,G,E,E,K}, {I,D,E,Q,A,P,R,A,C,T,I,C,E}}, word = "GEEKS"
# Output: {{0,0}, {0,8}, {1,0}}
# Explanation: From (0,0) we can find "GEEKS" horizontally right. From (0,8) we can find "GEEKS" horizontally right. From (1,0) we can find "GEEKS" horizontally right. 

# Constraints:
# 1 <= n <= m <= 50
# 1 <= |word| <= 20


class Solution:
    def searchWord(self, mat, word):
        # code here
        n=len(mat)
        m=len(mat[0])
        ans=[]
        dirs={0:[0,1],1:[0,-1],2:[1,0],3:[-1,0],4:[-1,1],5:[-1,-1],6:[1,-1],7:[1,1]}
        def find(i,j,dir,k):
            if k>=len(word):
                return True

            if i<0 or i>=n or j<0 or j>=m or mat[i][j]!=word[k]:
                return False
                
            x=i+dirs[dir][0]
            y=j+dirs[dir][1]
            return find(x,y,dir,k+1)
            
            
        for i in range(n):
            for j in range(m):
                if mat[i][j]==word[0]:
                    for dir in range(8):
                        if find(i,j,dir,0):
                            ans.append([i,j])
                            break
        return ans