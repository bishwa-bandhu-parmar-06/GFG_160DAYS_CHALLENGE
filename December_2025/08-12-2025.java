// Brackets in Matrix Chain Multiplication
// Difficulty: HardAccuracy: 59.66%Submissions: 38K+Points: 8Average Time: 25m
// Given an array arr[] of length n used to denote the dimensions of a series of matrices such that the dimension of i'th matrix is arr[i] * arr[i+1]. There are a total of n-1 matrices. Find the most efficient way to multiply these matrices together. 
// Your task is to return the string which is formed of A - Z (only Uppercase) denoting matrices & Brackets( "(" ")" ) denoting multiplication symbols. For example, if n = 11, the matrixes can be denoted as A - K as n <= 26 & multiplication of A and B is denoted as (AB).

// NOTE:

// Each multiplication is denoted by putting open & closed brackets to the matrices multiplied & also, please note that the order of matrix multiplication matters, as matrix multiplication is non-commutative A*B != B*A
// As there can be multiple possible answers, the console would print "true" for the correct string and "false" for the incorrect string. You need to only return a string that performs a minimum number of multiplications.


class Solution {
    String build(int i, int j, int[][] br) {
        if (i == j) return String.valueOf((char)('A' + i - 1));
        int k = br[i][j];
        return "(" + build(i, k, br) + build(k + 1, j, br) + ")";
    }

    public String matrixChainOrder(int arr[]) {
        int n = arr.length;
        int m = n - 1;

        long[][] dp = new long[m + 2][m + 2];
        int[][] br = new int[m + 2][m + 2];

        for (int len = 2; len <= m; len++) {
            for (int i = 1; i + len - 1 <= m; i++) {
                int j = i + len - 1;
                dp[i][j] = Long.MAX_VALUE;

                for (int k = i; k < j; k++) {
                    long cost = dp[i][k] + dp[k + 1][j] + (long) arr[i - 1] * arr[k] * arr[j];
                    if (cost < dp[i][j]) {
                        dp[i][j] = cost;
                        br[i][j] = k;
                    }
                }
            }
        }

        return build(1, m, br);
    }
}