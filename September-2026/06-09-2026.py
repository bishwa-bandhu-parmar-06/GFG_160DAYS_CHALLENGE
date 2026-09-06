# Sum of Pairwise ANDs
# Difficulty: MediumAccuracy: 50.93%Submissions: 43K+Points: 4
# Given an array arr[] of integers, calculate the sum of bitwise AND for all pairs of elements such that the first index is less than the second index.

# Examples:

# Input: arr = [5, 10, 15]
# Output: 15
# Explanation: 
# Consider all pairs of elements where the first index is less than the second index (i < j).
# For the array [5, 10, 15], the valid pairs are:
# (5, 10)  -> 5 & 10  = 0
# (5, 15)  -> 5 & 15  = 5
# (10, 15) -> 10 & 15 = 10
# Now, add all these results: 0 + 5 + 10 = 15
# So, the total sum of bitwise ANDs for all such pairs is 15
# Input: arr = [10, 20, 30, 40]
# Output: 46
# Explanation: 
# Consider all pairs of elements where the first index is less than the second index (i < j).
# For the array [10, 20, 30, 40], the valid pairs are:
# (10, 20) -> 10 & 20 = 0
# (10, 30) -> 10 & 30 = 10
# (10, 40) -> 10 & 40 = 8
# (20, 30) -> 20 & 30 = 20
# (20, 40) -> 20 & 40 = 0
# (30, 40) -> 30 & 40 = 8
# Now, add all these results: 0 + 10 + 8 + 20 + 0 + 8 = 46
# So, the total sum of bitwise ANDs for all such pairs is 46
# Constraints:

# 1 ≤ arr.size() ≤ 105
# 1 ≤ arr[i] ≤ 108


class Solution:
    def pairAndSum(self, arr):
        # code here
        final = 0
        for i in range(32):
            count = 0
            for j in arr:
                if j & (1<<i):
                    count+=1
            
            new = count*(count-1)//2
            final += new*(1<<i)
                
                
        return final

