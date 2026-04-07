// Stable Marriage Problem
// Difficulty: MediumAccuracy: 77.25%Submissions: 1K+Points: 4
// You are given two arrays men[] and women[], each of length n, where:

// men[i] represents the preference list of the i-th man, ranking all women in order of preference.
// women[i] represents the preference list of the i-th woman, ranking all men in order of preference.
// The task is to form n pairs (marriages) such that:

// Each man is matched with exactly one woman, and each woman is matched with exactly one man.
// The matching is stable, meaning there is no pair (man, woman) who both prefer each other over their current partners.
// It is guaranteed that a stable matching always exists. Return the stable matching from the men’s perspective, i.e., the one where men are considered for the final output.
// Return an array result[] of size n, where result[i] denotes the index (0-based) of the woman matched with the i-th man.

// Examples: 

// Input: n = 2, men[] = [[0, 1], [0, 1], women[] = [[0, 1], [0, 1]]
// Output: [0, 1]
// Explanation:
// Man 0 is married to Woman 0 (his first choice and her first choice).
// Man 1 is married to Woman 1 (his second choice and her second choice).
// Input: n = 3, men[] = [[0, 1, 2], [0, 1, 2], [0, 1, 2]], women[] = [[2, 1, 0], [2, 1, 0], [2, 1, 0]]
// Output: [2, 1, 0]
// Explanation:
// Man 0 is married to Woman 2 (his third choice and her third choice).
// Man 1 is married to Woman 1 (his second choice and her second choice).
// Man 2 is married to Woman 0 (his first choice and her first choice).
// Constraints: 
// 2 ≤ n ≤ 103
// 0 ≤ men[i] ≤ n - 1
// 0 ≤ women[i] ≤ n - 1



class Solution {
    public int[] stableMarriage(int[][] men, int[][] women) {
        int n = men.length;

        int[][] womanRank = new int[n][n];
        for (int w = 0; w < n; w++) {
            for (int rank = 0; rank < n; rank++) {
                womanRank[w][women[w][rank]] = rank;
            }
        }

        int[] wife = new int[n];
        int[] husband = new int[n];
        for (int i = 0; i < n; i++) {
            wife[i] = -1;
            husband[i] = -1;
        }

        int[] nextProposal = new int[n];

        java.util.Queue<Integer> freeMen = new java.util.ArrayDeque<>();
        for (int m = 0; m < n; m++) {
            freeMen.offer(m);
        }

        while (!freeMen.isEmpty()) {
            int m = freeMen.poll();

            int w = men[m][nextProposal[m]];
            nextProposal[m]++;

            if (husband[w] == -1) {
                husband[w] = m;
                wife[m] = w;
            } else {
                int currentMan = husband[w];

                if (womanRank[w][m] < womanRank[w][currentMan]) {
                    husband[w] = m;
                    wife[m] = w;
                    wife[currentMan] = -1;
                    freeMen.offer(currentMan);
                } else {
                    freeMen.offer(m);
                }
            }
        }

        return wife;
    }
}