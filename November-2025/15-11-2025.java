// Minimum Cost to Cut a Stick of length N
// Difficulty: HardAccuracy: 81.19%Submissions: 4K+Points: 8
// You are given a wooden stick of length n, labeled from 0 to n. You are also given an integer array cuts[], where each element cuts[i] represents a position along the stick at which you can make a cut.
// Each cut costs an amount equal to the length of the stick being cut at that moment. After performing a cut, the stick is divided into two smaller sticks.
// You can perform the cuts in any order. Your task is to determine the minimum total cost required to perform all the cuts.


class Solution {
    public int minCutCost(int n, int[] cuts) {
        int c = cuts.length;
        int[] allCuts = new int[c + 2];
        System.arraycopy(cuts, 0, allCuts, 1, c);
        allCuts[0] = 0;
        allCuts[c + 1] = n;
        Arrays.sort(allCuts);

        int[][] dp = new int[c + 2][c + 2];

        for (int len = 2; len <= c + 1; len++) {
            for (int i = 0; i + len <= c + 1; i++) {
                int j = i + len;
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = i + 1; k < j; k++) {
                    dp[i][j] = Math.min(dp[i][j],
                        dp[i][k] + dp[k][j] + allCuts[j] - allCuts[i]);
                }
            }
        }

        return dp[0][c + 1];
    }
}