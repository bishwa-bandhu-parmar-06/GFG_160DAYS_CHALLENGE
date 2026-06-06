// Non-Attacking Black and White Knights
// Difficulty: MediumAccuracy: 51.2%Submissions: 32K+Points: 4
// Given two integers n and m representing the dimensions of a chessboard, find the number of ways to place one black knight and one white knight on the chessboard such that they cannot attack each other.

// Note:

// The knights have to be placed on different squares.
// A knight can move two squares horizontally and one square vertically (L shaped), or two squares vertically and one square horizontally (L shaped).
// The knights attack each other if one can reach the other in one move.



class Solution {
    public long numOfWays(int n, int m) {

        long cells = 1L * n * m;

        long totalWays = cells * (cells - 1);

        long attackingWays = 4L *
                ((long)(n - 1) * Math.max(0, m - 2)
                + (long)Math.max(0, n - 2) * (m - 1));

        return totalWays - attackingWays;
    }
}

