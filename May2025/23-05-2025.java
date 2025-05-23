// Dice throw
// Difficulty: MediumAccuracy: 36.52%Submissions: 42K+Points: 4Average Time: 30m
// Given n dice each with m faces. Find the number of ways to get sum x which is the summation of values on each face when all the dice are thrown.


class Solution {

    // Main method to calculate number of ways to get sum 'x' with 'n' dice, each having 'm' faces
    static int noOfWays(int m, int n, int x) {
        // Initialize a memoization table with dimensions [n+1][x+1]
        // dp[diceUsed][currentSum] stores the number of ways to reach 'currentSum' using 'diceUsed' dice
        int[][] dp = new int[n + 1][x + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1); // Fill with -1 to denote uncomputed states
        }

        // Start recursive computation from 0 dice used and sum 0
        return countWays(0, 0, dp, x, n, m);
    }

    // Recursive helper method with memoization
    static int countWays(int diceUsed, int currentSum, int[][] dp, int targetSum, int totalDice, int faces) {
        // Base Case: If we've used all dice
        if (diceUsed == totalDice) {
            // Check if we reached the desired sum
            return currentSum == targetSum ? 1 : 0;
        }

        // Prune paths where currentSum already exceeds targetSum
        if (currentSum > targetSum) return 0;

        // If this subproblem is already solved, return stored result
        if (dp[diceUsed][currentSum] != -1) return dp[diceUsed][currentSum];

        int ways = 0;

        // Try all face values from 1 to m for the current die
        for (int face = 1; face <= faces; face++) {
            // Recur for the next die with updated sum
            ways += countWays(diceUsed + 1, currentSum + face, dp, targetSum, totalDice, faces);
        }

        // Store the computed result in dp table and return it
        dp[diceUsed][currentSum] = ways;
        return ways;
    }
}