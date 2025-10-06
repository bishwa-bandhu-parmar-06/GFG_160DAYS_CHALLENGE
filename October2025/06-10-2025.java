// The Knight's tour problem
// Difficulty: MediumAccuracy: 57.75%Submissions: 7K+Points: 4
// You are given an integer n, there is a n × n chessboard with a Knight starting at the top-left corner (0, 0). Your task is to determine a valid Knight's Tour, where the Knight visits every square exactly once, following the standard movement rules of a chess Knight (two steps in one direction and one step perpendicular), for example if a Knight is placed at cell (2, 2), in one move it can move to any of the following cells: (4, 3), (4, 1), (0, 3), (0, 1), (3, 4), (3, 0), (1, 4) and (1, 0).

// You have to return the order in which each cell is visited. If a solution exists, return the sequence of numbers (starting from 0) representing the order of visited squares. If no solution is possible, return an empty list.

// Note: You can return any valid ordering, if it is correct the driver code will print true else it will print false.

import java.util.*;

class Solution {

    // All 8 possible knight moves
    private static final int[] dx = {2, 1, -1, -2, -2, -1, 1, 2};
    private static final int[] dy = {1, 2, 2, 1, -1, -2, -2, -1};

    public ArrayList<ArrayList<Integer>> knightTour(int n) {
        int[][] board = new int[n][n];
        for (int[] row : board) Arrays.fill(row, -1);

        // Start from (0, 0)
        board[0][0] = 0;

        // Try to find a solution using backtracking
        if (solve(board, n, 0, 0, 1)) {
            return convertToList(board);
        } else {
            return new ArrayList<>();
        }
    }

    private boolean solve(int[][] board, int n, int x, int y, int moveCount) {
        // Base case: if all squares are visited
        if (moveCount == n * n) return true;

        for (int i = 0; i < 8; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];

            if (isValid(board, n, nextX, nextY)) {
                board[nextX][nextY] = moveCount;
                if (solve(board, n, nextX, nextY, moveCount + 1))
                    return true;
                // Backtrack
                board[nextX][nextY] = -1;
            }
        }

        return false;
    }

    private boolean isValid(int[][] board, int n, int x, int y) {
        return (x >= 0 && x < n && y >= 0 && y < n && board[x][y] == -1);
    }

    private ArrayList<ArrayList<Integer>> convertToList(int[][] board) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        for (int[] row : board) {
            ArrayList<Integer> temp = new ArrayList<>();
            for (int val : row) temp.add(val);
            result.add(temp);
        }
        return result;
    }

    // For quick local testing
    public static void main(String[] args) {
        Solution sol = new Solution();
        int n = 5;
        ArrayList<ArrayList<Integer>> ans = sol.knightTour(n);
        if (ans.isEmpty()) {
            System.out.println("[]");
        } else {
            for (ArrayList<Integer> row : ans) {
                System.out.println(row);
            }
        }
    }
}