// Frog Jump
// Difficulty: MediumAccuracy: 49.55%Submissions: 175K+Points: 4Average Time: 15m
// Given an integer array height[] where height[i] represents the height of the i-th stair, a frog starts from the first stair and wants to reach the last stair. From any stair i, the frog has two options: it can either jump to the (i+1)th stair or the (i+2)th stair. The cost of a jump is the absolute difference in height between the two stairs. Determine the minimum total cost required for the frog to reach the last stair.


class Solution {
    public static int minCost(int[] height) {
        // code here
       
        int n = height.length;
        if (n == 1) return 0;

        int prev2 = 0; 
        int prev1 = Math.abs(height[1] - height[0]);

        for (int i = 2; i < n; i++) {
            int jumpOne = prev1 + Math.abs(height[i] - height[i - 1]);
            int jumpTwo = prev2 + Math.abs(height[i] - height[i - 2]);
            int curr = Math.min(jumpOne, jumpTwo);
            prev2 = prev1;
            prev1 = curr;
        }

        return prev1;
    }

    public static void main(String[] args) {
        int[] height1 = {20, 30, 40, 20};
        System.out.println(minCost(height1)); 

        int[] height2 = {30, 20, 50, 10, 40};
        System.out.println(minCost(height2)); 
    }
}

