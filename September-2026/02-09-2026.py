# Unoccupied Computers
# Difficulty: EasyAccuracy: 51.47%Submissions: 12K+Points: 2Average Time: 20m
# A cafe has n computers. The customer events are represented by a string s of uppercase English letters, where each distinct letter appears exactly twice:

# The first occurrence denotes the customer's arrival.
# The second occurrence denotes the customer's departure.
# A customer is assigned a computer only if one is available at the time of arrival, otherwise the customer is rejected and does not use a computer.

# Return the number of customers who could not be assigned a computer upon arrival.

# Examples:

# Input: n = 3, s = "GACCBDDBAGEE"
# Output: 1
# Explanation: Only D will not be able to get any computer. So the answer is 1.
# Input: n = 1, s = "ABCBAC"
# Output: 2
# Explanation: B and C will not be able to get any computers. So the answer is 2.
# Constraints:

# 1 ≤ n ≤ 26
# 1 ≤ s.size() ≤ 52
# s consists of uppercase English letters and each letter occurs exactly 2 times.


class Solution:
    def solve(self, n, s):
        using = set()
        rejected = set()
    
        for ch in s:
            if ch in using:
                # Customer leaves
                using.remove(ch)
    
            elif ch in rejected:
                # Rejected customer's departure - do nothing
                pass
    
            else:
                # Customer arrives
                if len(using) < n:
                    using.add(ch)
                else:
                    rejected.add(ch)
    
        return len(rejected) 