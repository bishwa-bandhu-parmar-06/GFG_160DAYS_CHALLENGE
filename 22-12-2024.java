// Search in a Row-Column sorted matrix
// Difficulty: Easy      Accuracy: 41.62%         Submissions: 149K+           Points: 2
// Given a 2D integer matrix mat[][] of size n x m, where every row and column is sorted in increasing order and a number x, the task is to find whether element x is present in the matrix.


// Brute Force Approach (Unsorted Matrix):
// Steps:
// Traverse each element in the matrix using a nested loop:
// Outer loop iterates through rows.
// Inner loop iterates through columns of the current row.
// Compare each element with 
// 𝑥
// x.
// If 
// 𝑚
// 𝑎
// 𝑡
// [
// 𝑖
// ]
// [
// 𝑗
// ]
// =
// =
// 𝑥
// mat[i][j]==x, return true.
// If the traversal completes without finding 
// 𝑥
// x, return false.
// Time Complexity:
// Worst Case: 
// 𝑂(𝑛×𝑚)
// O(n×m), where 
// 𝑛
// n is the number of rows and 
// 𝑚
// m is the number of columns.
// Space Complexity:
// 𝑂(1)
// O(1), as no extra space is used.
// When to Use:
// When the matrix is not sorted.



class Solution {
    public static boolean matSearch(int mat[][], int x) {
    int rows = mat.length;
    int cols = mat[0].length;

    // Start from the top-right corner
    int i = 0, j = cols - 1;

    while (i < rows && j >= 0) {
        if (mat[i][j] == x) {
            return true;
        } else if (mat[i][j] > x) {
            j--; // Move left
        } else {
            i++; // Move down
        }
    }
    return false; // Element not found
}

}