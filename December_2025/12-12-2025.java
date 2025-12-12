// Transpose of Matrix
// Difficulty: EasyAccuracy: 66.5%Submissions: 120K+Points: 2Average Time: 20m
// You are given a square matrix of size n x n. Your task is to find the transpose of the given matrix.
// The transpose of a matrix is obtained by converting all the rows to columns and all the columns to rows.


class Solution {
    public ArrayList<ArrayList<Integer>> transpose(int[][] mat) {
        // code here
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        
        for(int i = 0; i < mat.length; i++){
            ArrayList<Integer> temp = new ArrayList<>();
            for(int j = 0; j < mat[0].length; j++){
                temp.add(mat[j][i]);
            }
            list.add(temp);
        }
        
        return list;
    }
}