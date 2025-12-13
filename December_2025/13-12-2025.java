// Swap diagonals
// Difficulty: EasyAccuracy: 81.11%Submissions: 7K+Points: 2Average Time: 9m
// Given a square matrix mat[][], the task is to swap the elements of the major and minor diagonals.



// Major Diagonal: Elements that lie from the top-left corner to the bottom-right corner of the matrix (i.e., where row index equals column index).
// Minor Diagonal: Elements that lie from the top-right corner to the bottom-left corner (i.e., where the sum of row and column indices equals n - 1).

class Solution {
    public void swapDiagonal(int[][] mat) {
        // code here
        int size = mat.length;
        int i = 0;
        int j = 0;
        
        int k = 0;
        int l = size - 1;
        while(size >= 1){
            int temp = mat[i][j];
            mat[i][j] = mat[k][l];
            mat[k][l] = temp;
            i++;j++;
            k++;l--;
            
            size--;
        }
    }
}






