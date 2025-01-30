// N-Queen Problem
// Difficulty: Hard      Accuracy: 35.43%      Submissions: 98K+   Points: 8
// The n-queens puzzle is the problem of placing n queens on a (n × n) chessboard such that no two queens can attack each other. Note that two queens attack each other if they are placed on the same row, the same column, or the same diagonal.

// Given an integer n, find all distinct solutions to the n-queens puzzle.
// You can return your answer in any order but each solution should represent a distinct board configuration of the queen placements, where the solutions are represented as permutations of [1, 2, 3, ..., n]. In this representation, the number in the ith position denotes the row in which the queen is placed in the ith column.
// For eg. below figure represents a chessboard [3 1 4 2].

class Solution {
    public ArrayList<ArrayList<Integer>> nQueen(int n) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        int[] queens = new int[n]; // stores queen positions in each column
        solveNQueens(0, n, queens, result);
        return result;
    }

    private void solveNQueens(int col, int n, int[] queens, ArrayList<ArrayList<Integer>> result) {
        if (col == n) {
            ArrayList<Integer> solution = new ArrayList<>();
            for (int q : queens) {
                solution.add(q + 1); // Convert to 1-based index
            }
            result.add(solution);
            return;
        }

        for (int row = 0; row < n; row++) {
            if (isSafe(row, col, queens)) {
                queens[col] = row;
                solveNQueens(col + 1, n, queens, result);
            }
        }
    }

    private boolean isSafe(int row, int col, int[] queens) {
        for (int prevCol = 0; prevCol < col; prevCol++) {
            int prevRow = queens[prevCol];
            if (prevRow == row || Math.abs(prevRow - row) == Math.abs(prevCol - col)) {
                return false;
            }
        }
        return true;
    }
}
