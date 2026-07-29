# Split Array into Minimum Subsets
# Difficulty: EasyAccuracy: 79.72%Submissions: 8K+Points: 2Average Time: 25m
# Given an array arr[] of distinct positive numbers. Split the array into the minimum number of subsets such that each subset contains consecutive numbers.

# Examples:

# Input: arr[] = [100, 56, 5, 6, 102, 58, 101, 57, 7, 103, 59]
# Output: 3
# Explanation: [5, 6, 7], [56, 57, 58, 59], [100, 101, 102, 103] are 3 subsequences in which numbers are consecutive.
# Input: arr[] = [10, 100, 105]
# Output: 3
# Explanation: [10], [100] and [105] are 3 subset in which numbers are consecutive.
# Constraints:
# 1 ≤ arr.size() ≤ 105
# 0 ≤ arr[i] ≤ 109


class Solution:
    def minSubsets(self, arr):
        from collections import Counter
        cnt=Counter(arr)
        lst=sorted(cnt)
        lth=len(lst)
        ix=0
        ret=0
        prv=None
        while ix<lth:
            mn=lst[ix]
            cnt[mn]-=1
            if cnt[mn]==0:
                ix+=1
            if not (prv==None or prv==mn-1):
                ret+=1
            prv=mn
        return ret+1