// Solve the Sudoku
// Difficulty: HardAccuracy: 37.98%Submissions: 105K+Points: 8
// Given an incomplete Sudoku configuration in terms of a 9x9  2-D interger square matrix, mat[][], the task is to solve the Sudoku. It is guaranteed that the input Sudoku will have exactly one solution.

// A sudoku solution must satisfy all of the following rules:

// Each of the digits 1-9 must occur exactly once in each row.
// Each of the digits 1-9 must occur exactly once in each column.
// Each of the digits 1-9 must occur exactly once in each of the 9 3x3 sub-boxes of the grid.
// Note: Zeros represent blanks to be filled with numbers 1-9, while non-zero cells are fixed and cannot be changed.

class Solution {
    // Function to find a solved Sudoku.
    static boolean isSafe(int[][] mat, int row, int col, int digit) {
        
        for(int i=0; i<mat.length; i++)
        {
            if(mat[i][col] == digit || mat[row][i] == digit)
            return false;
        }
        
        int str = 3 * (row / 3);
        int stc = 3 * (col / 3);
        for(int i=str; i<str + 3; i++)
        {
            for(int j=stc; j<stc + 3; j++)
            {
                if(mat[i][j] == digit)
                return false;
            }
        }
        
        return true;
    }
    
    static boolean sudoku(int[][] mat, int row, int col) {
        
        if(row == mat.length)
        return true;
        
        int nextRow = row;
        int nextCol = col + 1;
        
        if(nextCol == mat.length)
        {
            nextRow = row + 1;
            nextCol = 0;
        }
        
        if(mat[row][col] != 0)
        return sudoku(mat, nextRow, nextCol);
        
        for(int digit=1; digit<=9; digit++)
        {
            if(isSafe(mat, row, col, digit))
            {
                mat[row][col] = digit;
                
                if(sudoku(mat, nextRow, nextCol))
                return true;
                
                mat[row][col] = 0;
            }
        }
        return false;
    }
    
    static void solveSudoku(int[][] mat) {
        // code here
        sudoku(mat, 0, 0);
        
    }
}