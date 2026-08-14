# Subset Sum on Generated Sequence
# Difficulty: MediumAccuracy: 37.44%Submissions: 14K+Points: 4Average Time: 15m
# There are n children standing in a queue, each assigned a number arr[i]. The teacher writes s on a paper and gives it to the first child.

# Each child writes the sum of all numbers already on the paper and arr[i], then passes it to the next child.

# Return true if x can be formed by adding some of the numbers written on the paper: else return false.

# Input: arr[] = [1, 2, 4, 2], s = 1, x = 7
# Output: true
# Explanation: The first student gets 1 on paper and writes 2. The second student gets [1, 2] and writes 5. The third student gets [1, 2, 5] and writes 12. The final sequence of numbers on the paper is 1, 2, 5, 12, 22. Using 2 and 5 we can form 7. 
# Input: arr[] = [51, 88], s = 100, x = 500
# Output: false
# Explanation: The final sequence of numbers on the paper is 100, 151, 339. Using these numbers we cannot form 500. 
# Constraints:

# 1 ≤ arr.size() ≤ 105
# 1 ≤ arr[i] ≤ 109
# 1 ≤ s ≤ 109
# 0 ≤ x ≤ 109


class Solution:
    def isPossible(self, arr, s, x):
        # code here 
        numbers = [s]
        if x== 0:
            return True
        total = s
        for i in range(len(arr)):
            numbers.append(arr[i]+total)
            total += arr[i]+total
        for n in range(len(numbers)-1, -1, -1):
            if numbers[n] < x:
                x -=numbers[n]
            elif numbers[n] ==x:
                return True
        return False