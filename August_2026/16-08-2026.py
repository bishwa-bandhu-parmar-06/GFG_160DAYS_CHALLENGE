# Min Product Subset
# Difficulty: MediumAccuracy: 50.0%Submissions: 14K+Points: 4
# Given an integer array arr[], find the minimum possible product that can be obtained by multiplying the elements of any non-empty subset of the array.

# Examples:

# Input: arr[] = [1, 2, 3]
# Output: 1
# Explanation: The possible subset products are 1, 2, 3, 2, 3, 6, and 6. The minimum product is 1, obtained by selecting the subset [1].
# Input: arr[] = [4, -2, 5]
# Output: -40
# Explanation: The minimum product is -40, obtained by selecting the subset [4, -2, 5].

# Constraints:

# 1 ≤ arr.size() ≤ 10
# -10 ≤ arr[i] ≤ 10


class Solution:
    def minProd(self, arr):
        mxgl=arr[0]
        mngl=arr[0]
        for ix in range(1,len(arr)):
            n=arr[ix]
            mngl,mxgl=min(mngl,mngl*n,mxgl*n,n),max(mxgl,mxgl*n,mngl*n,n)
        return mngl


