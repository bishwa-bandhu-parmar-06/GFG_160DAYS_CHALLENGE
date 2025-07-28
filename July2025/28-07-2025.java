// Make Matrix Beautiful
// Difficulty: MediumAccuracy: 64.75%Submissions: 65K+Points: 4Average Time: 20m
// A beautiful matrix is defined as a square matrix in which the sum of elements in every row and every column is equal. Given a square matrix mat[][], your task is to determine the minimum number of operations required to make the matrix beautiful.
// In one operation, you are allowed to increment the value of any single cell by 1.


class Solution {
    public static int balanceSums(int[][] mat) {
        // code here
        int max = 0;
        int n = mat.length;
        
        for (int i = 0; i < n; i++){
            int sum = 0;
            for (int j = 0; j < n; j++){
                sum += mat[i][j];
                // System.out.println(mat[i][j] + " ");
            }
            max = Math.max(max, sum);
            // System.out.println(sum);
        }
        for (int i = 0; i < n; i++){
            int sum = 0;
            for (int j = 0; j < n; j++){
                sum += mat[j][i];
                // System.out.println(mat[i][j] + " ");
            }
            max = Math.max(max, sum);
            // System.out.println(sum);
        }
        int ans = 0;
        for (int i = 0; i < n; i++){
            int sum = 0;
            for (int j = 0; j < n; j++){
                sum += mat[i][j];
                // System.out.println(mat[i][j] + " ");
            }
            ans += (max - sum);
            // System.out.println(sum);
        }
        return ans;
    }
}

