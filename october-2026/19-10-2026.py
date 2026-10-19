# Count Indices That Escape Array
# Difficulty: MediumAccuracy: 53.74%Submissions: 26K+Points: 4
# Given an array arr[], where arr[i] represents the exact number of steps to move from index i.  An index is considered good if repeatedly following the jumps eventually takes you outside the array. Otherwise, if the jumps result in an infinite loop, the index is considered bad.

# A positive value indicates a move to the right
# A negative value indicates a move to the left.
# A 0 value means no move and considered bad.
# Return the number of good indices.

# Examples:

# Input: [2, 3, -1, 2, -2, 4, 1]
# Output: 3
# Explanation: Indices 3, 5, and 6 are good because their jump sequences eventually leave the array. Indices 1, 2, and 4 form a cycle, while index 0 eventually enters this cycle through index 2. Hence, the total number of good indices is 3.
 
# Input: [1, 0, -3, 0, -5, 0]
# Output: 2
# Explanation: Indices 2 and 4 are good because their jumps take them outside the array. Indices 1, 3, and 5 are bad because their jumps are zero. Index 0 is also bad because it jumps to index 1, which is a dead end. Hence, the total number of good indices is 2.
  
# Constraints:

# 1 ≤ arr.size() ≤ 105
# -105 ≤ arr[i] ≤ 105


from collections import deque
class Solution:
    def goodIndices(self, arr):
        # code here
        n = len(arr)
        rev = {i: [] for i in range(n)}
        good_starts = []
        for i in range(n):
            nxt = i + arr[i]
            if 0 <= nxt < n:
                rev[nxt].append(i)
            else:
                good_starts.append(i)

        q = deque(good_starts)
        good = set(good_starts)
        while q:
            node = q.popleft()
            for parent in rev[node]:
                if parent not in good:
                    good.add(parent)
                    q.append(parent)
        return len(good)