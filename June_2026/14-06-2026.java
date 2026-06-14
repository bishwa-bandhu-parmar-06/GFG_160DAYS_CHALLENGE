// Exit Point in a Matrix
// Difficulty: MediumAccuracy: 50.0%Submissions: 65K+Points: 4Average Time: 10m
// Given a matrix mat[][] of size n × m consisting of 0s and 1s. You start at the top-left cell (0, 0) and initially move in the left-to-right direction (i.e., towards the right).

// While traversing the matrix, follow these rules:

// If the current cell contains 0, continue moving in the same direction.
// If the current cell contains 1, change your direction to the right (clockwise turn), and update the cell value to 0.
// You continue this process until you move outside the boundaries of the matrix. Your task is to determine the coordinates (row and column index) of the cell from which you exit the matrix.



class Solution {
    public List<Integer> exitPoint(int[][] mat) {
         int n = mat.length;
        int m = mat[0].length;

        // Directions: 0 = right, 1 = down, 2 = left, 3 = up
        int dir = 0;
        int i = 0, j = 0;

        while (true) {
            if (mat[i][j] == 1) {
                mat[i][j] = 0;       // flip to 0
                dir = (dir + 1) % 4; // turn clockwise
            }

            // Move in current direction
            if (dir == 0) { // right
                j++;
            } else if (dir == 1) { // down
                i++;
            } else if (dir == 2) { // left
                j--;
            } else { // up
                i--;
            }

            // Boundary check
            if (i < 0) {
                return Arrays.asList(0, j);
            } else if (j < 0) {
                return Arrays.asList(i, 0);
            } else if (i >= n) {
                return Arrays.asList(n - 1, j);
            } else if (j >= m) {
                return Arrays.asList(i, m - 1);
            }
        }
    }
}

