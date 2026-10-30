# Subsets with MEX in Range
# Difficulty: HardAccuracy: 80.64%Submissions: 4K+Points: 8
# Given an array arr[] of integers and a range [l, r], count the number of subsets whose Minimum Excluded (MEX) value lies within the given range, inclusive.

# Minimum Excluded (or MEX) of a subset is the smallest non-negative integer that is not present in the subset.
# An empty subset has Minimum Excluded as zero.
# Since the answer can be very large, return the answer modulo 109 + 7.

# Examples:

# Input: arr[] = [2, 0, 1, 0], l = 1, r = 2
# Output: 9
# Explanation: The subsets whose MEX lies in the range [1, 2] are counted as follows:
# MEX = 1: The subsets must contain at least one 0 and must not contain 1. These subsets are [0] (2 ways), [2, 0] (2 ways), [0, 0] (1 way), and [2, 0, 0] (1 way). Total = 6.
# MEX = 2: The subsets must contain both 0 and 1 but must not contain 2. These subsets are [0, 1] (2 ways) and [0, 1, 0] (1 way). Total = 3.
# The subsets [2, 0, 1] and [2, 0, 1, 0] have MEX = 3, which is outside the given range. Therefore, the total number of valid subsets is 6 + 3 = 9.
# Input: arr[] = [2, 0, 1], l = 1, r = 2
# Output: 3
# Explanation: The subsets whose MEX lies in the range [1, 2] are [0] (MEX = 1), [2, 0] (MEX = 1), and [0, 1] (MEX = 2). Hence, the answer is 3.
# Constraints:

# 2 ≤ arr.size() ≤ 105
# 0 ≤ arr[i], r ≤ arr.size()
# 0 ≤ l ≤ r


from typing import List

class Solution:
    def cntSubsets(self, arr: List[int], l: int, r: int) -> int:
        MOD = 10**9 + 7
        n = len(arr)

        maxv = n  # since 0 ≤ arr[i] ≤ n
        cnt = [0] * (maxv + 1)
        for x in arr:
            cnt[x] += 1

        # prefix sums of counts
        pref = [0] * (maxv + 1)
        pref[0] = cnt[0]
        for i in range(1, maxv + 1):
            pref[i] = pref[i - 1] + cnt[i]

        # powers of 2 up to n
        pow2 = [1] * (n + 1)
        for i in range(1, n + 1):
            pow2[i] = (pow2[i - 1] * 2) % MOD

        # productBelow[x] = Π (2^cnt[i] − 1) for i = 0..x−1
        # valid[x] = True iff all cnt[0..x−1] > 0
        productBelow = [1] * (maxv + 2)
        valid = [False] * (maxv + 2)
        valid[0] = True

        prod = 1
        for i in range(maxv + 1):
            if cnt[i] == 0:
                break
            prod = (prod * (pow2[cnt[i]] - 1)) % MOD
            productBelow[i + 1] = prod
            valid[i + 1] = True

        def ways(x: int) -> int:
            # number of subsets with MEX exactly x
            if x == 0:
                # MEX 0 ⇒ no 0 in subset; all non-zero elements are free
                nonzero = n - cnt[0]
                return pow2[nonzero]

            if x > maxv or not valid[x]:
                return 0

            # elements with value > x
            greater = n - pref[x]
            return (productBelow[x] * pow2[greater]) % MOD

        ans = 0
        for x in range(l, r + 1):
            ans = (ans + ways(x)) % MOD

        return ans % MOD