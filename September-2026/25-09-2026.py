# Box Stacking
# Difficulty: HardAccuracy: 41.0%Submissions: 36K+Points: 8
# Given three arrays height[], width[], and length[] of size n, where height[i], width[i], and length[i] represent the dimensions of the ith box, find the maximum possible height of a stack formed using these boxes.

# A box can be rotated so that any of its dimensions becomes its height.
#  A box can be placed on top of another only if both dimensions of its base are strictly smaller than those of the box below. 
# Multiple instances of the same box can be used.
# Examples:

# Input: height[] = [4, 1, 4, 10], width[] = [6, 2, 5, 12], length[] = [7, 3, 6, 32]
# Output: 60
# Explanation: One possible arrangement of the boxes from bottom to top is shown below. Note that there can be multiple instances of a box type.
 
# Hence, the total height of this stack is 10 + 32 + 4 + 4 + 6 + 1 + 3 = 60. No other combination of boxes produces a height greater than this.
# Input: height[] = [1, 4, 3], width[] = [2, 5, 4], length[] = [3, 6, 1]
# Output: 15
# Explanation: One possible arrangement of the boxes from bottom to top is shown below: 

# Hence, the total height of this stack is 4 + 6 + 1 + 1 + 3 = 15 No other combination of boxes produces a height greater than this.
# Constraints:

# 1 ≤ height.size(), width.size(), length.size() ≤ 100
# 1 ≤ height[i], width[i], length[i] ≤ 106


class Solution:
    def maxHeight(self, height, width, length):
        # Step 1: Generate all rotations of the boxes
        boxes = []
        n = len(height)
        
        for i in range(n):
            h, w, l = height[i], width[i], length[i]
            boxes.append((max(l, w), min(l, w), h))  # l >= w
            boxes.append((max(w, h), min(w, h), l))
            boxes.append((max(l, h), min(l, h), w))
        
        # Step 2: Sort boxes by base area in descending order
        boxes.sort(key=lambda box: box[0] * box[1], reverse=True)
        
        # Step 3: Initialize DP array
        total_boxes = len(boxes)
        dp = [0] * total_boxes
        
        for i in range(total_boxes):
            dp[i] = boxes[i][2]  # Initial height is the height of the box itself
        
        # Step 4: Compute max stack height using DP
        for i in range(total_boxes):
            for j in range(i):
                if boxes[i][0] < boxes[j][0] and boxes[i][1] < boxes[j][1]:  # Strictly smaller base
                    dp[i] = max(dp[i], dp[j] + boxes[i][2])
        
        return max(dp)