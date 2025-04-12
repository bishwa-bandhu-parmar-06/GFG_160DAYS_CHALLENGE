// Flood fill Algorithm
// Difficulty: MediumAccuracy: 41.11%Submissions: 134K+Points: 4Average Time: 15m
// You are given a 2D grid image[][] of size n*m, where each image[i][j] represents the color of a pixel in the image. Also provided a coordinate(sr, sc) representing the starting pixel (row and column) and a new color value newColor.

// Your task is to perform a flood fill starting from the pixel (sr, sc), changing its color to newColor and the color of all the connected pixels that have the same original color. Two pixels are considered connected if they are adjacent horizontally or vertically (not diagonally) and have the same original color.


class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int originalColor = image[sr][sc];

        // If the newColor is the same as the original color, return the image directly
        if (originalColor == newColor) return image;

        dfs(image, sr, sc, originalColor, newColor);
        return image;
    }

    private void dfs(int[][] image, int row, int col, int originalColor, int newColor) {
        // Check boundaries and color match
        if (row < 0 || col < 0 || row >= image.length || col >= image[0].length) return;
        if (image[row][col] != originalColor) return;

        // Change the color
        image[row][col] = newColor;

        // Recurse in all 4 directions (up, down, left, right)
        dfs(image, row - 1, col, originalColor, newColor); // up
        dfs(image, row + 1, col, originalColor, newColor); // down
        dfs(image, row, col - 1, originalColor, newColor); // left
        dfs(image, row, col + 1, originalColor, newColor); // right
    }
}
