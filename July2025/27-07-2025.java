// Set Matrix Zeros
// Difficulty: MediumAccuracy: 52.54%Submissions: 47K+Points: 4
// You are given a 2D matrix mat[][] of size n x m. The task is to modify the matrix such that if mat[i][j] is 0, all the elements in the i-th row and j-th column are set to 0.


class Solution {
    public void setMatrixZeroes(int[][] mat) {
        int n=mat.length;
        int m=mat[0].length;
        Set<Integer> row=new HashSet<>();
        Set<Integer> columns=new HashSet<>();
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++){
                if(mat[i][j]==0){
                    row.add(i);
                    columns.add(j);
                }
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if((row.contains(i))||(columns.contains(j))){
                    mat[i][j]=0;
                }
            }
        }
    }
}