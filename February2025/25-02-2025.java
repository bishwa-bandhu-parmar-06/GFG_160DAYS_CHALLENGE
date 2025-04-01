// Histogram Max Rectangular Area
// Difficulty: HardAccuracy: 32.12%Submissions: 185K+Points: 8
// You are given a histogram represented by an array arr, where each element of the array denotes the height of the bars in the histogram. All bars have the same width of 1 unit.

// Your task is to find the largest rectangular area possible in the given histogram, where the rectangle can be formed using a number of contiguous bars.



class Solution {
    public static int getMaxArea(int arr[]) {
        int n = arr.length;
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;

        for (int i = 0; i <= n; i++) {
            int height = (i == n) ? 0 : arr[i];

            while (!stack.isEmpty() && height < arr[stack.peek()]) {
                int h = arr[stack.pop()];
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                maxArea = Math.max(maxArea, h * width);
            }

            stack.push(i);
        }

        return maxArea;
    }
}