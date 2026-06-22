// Maximum Area Between Bars
// Difficulty: MediumAccuracy: 39.48%Submissions: 15K+Points: 4
// Given an integer array height[], where height[i] represents the height of the ith bar arranged in a row, find the maximum rectangular area that can be formed by selecting any two bars. The area is calculated based on the original positions of the selected bars.


def maxArea(self, height):
        i, j = 0, len(height) - 1
        max_area = 0
        while i < j:
            if height[i] <= height[j]:
                h = height[i]
                i += 1
            else:
                h = height[j]
                j -= 1
            max_area = max(max_area, (j - i) * h)
        return max_area