// Toeplitz matrix
// Difficulty: EasyAccuracy: 49.05%Submissions: 46K+Points: 2
// A Toeplitz matrix (also known as a diagonal-constant matrix) is a matrix in which every descending diagonal from left to right contains the same element.

// Given a rectangular matrix mat, determine whether it is a Toeplitz matrix or not.
// Implement the function isToeplitz(mat) that returns:

// true if the matrix is a Toeplitz matrix
// false otherwise
// Examples:

// Input: mat[][] = [[6, 7, 8],
//                 [4, 6, 7],
//                 [1, 4, 6]]
// Output: true
// Explanation: The matrix is Toeplitz because every diagonal from top-left to bottom-right has the same elements. 
// For example, the main diagonal is 6 → 6 → 6, and other diagonals like 7 → 7 and 4 → 4 are also constant. 
// Since all diagonals follow this pattern, the matrix is Toeplitz, so the output is true.
// Input: mat[][] = [[6, 3, 8],
//                 [4, 9, 7],
//                 [1, 4, 6]]
// Output: false
// Explanation: The primary diagonal elements of the given matrix are [6, 9, 6]. As the diagonal elements are not same, the given matrix is not Toeplitz Matrix.
// Constraints:
// 1 ≤ mat.size(), mat[0].size() ≤ 40
// 0 ≤ mat[i][j] ≤ 100


class Solution {
    public boolean isToeplitz(int[][] mat) {
        // code here
        int n=mat.length;
        int mm=mat[0].length;
        
        for(int i=0;i<n;i++){
            for(int j=0;j<mm;j++){
                if(mat[i][j]==-1) continue;
                int num=mat[i][j];
                int r=i+1;
                int m=j+1;
                while(r>=0 && r<n && m>=0 && m<mm){
                    if(num!=mat[r][m]) return false;
                    mat[r][m]=-1;
                    r++;
                    m++;
                }
            }
        }
        
        return true;
    }
}