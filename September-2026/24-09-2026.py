# Maximum Height Disc Stack
# Difficulty: HardAccuracy: 36.87%Submissions: 2K+Points: 8
# Given two arrays r[] and h[] of size n, where r[i] and h[i] represent the radius and height of the i-th circular disc, respectively.

# A disc can be placed above another disc only if both its radius and height are strictly smaller than those of the disc below it.

# Find the maximum possible height of a stack that can be formed using the given discs. Each disc can be used at most once.

# Examples:

# Input: r[] = [5, 7, 3], h[] = [6, 5, 4]
# Output: 10
# Explanation: The discs (3, 4) and (5, 6) form a valid stack. Therefore, the maximum possible height is 4 + 6 = 10.
# Input: r[] = [3, 7], h[] = [7, 4]
# Output: 7
# Explanation: Neither disc can be placed above the other because both required dimensions are not strictly smaller. Therefore, the maximum possible height is 7.
# Constraints:

# 1 ≤ r.size(), h.size() ≤ 105
# 1 ≤ r[i], h[i] ≤ 1000


class Solution:
    def maxStackHeight(self, r, h):
        a = sorted(zip(r, h))
        bit = [0] * 1002
        ans = 0

        def query(x):
            z = 0
            while x:
                z = max(z, bit[x])
                x -= x & -x
            return z

        def update(x, v):
            while x <= 1000:
                bit[x] = max(bit[x], v)
                x += x & -x

        i = 0
        while i < len(a):
            j = i
            while j < len(a) and a[j][0] == a[i][0]:
                j += 1

            v = []
            for k in range(i, j):
                height = a[k][1]
                v.append((height, query(height - 1) + height))

            for x, val in v:
                update(x, val)
                ans = max(ans, val)

            i = j

        return ans